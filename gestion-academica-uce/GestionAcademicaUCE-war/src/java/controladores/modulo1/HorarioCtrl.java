/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo1;

import entidades.CursoAula;
import entidades.HorarioActividades;
import entidades.HorarioVisual;
import entidades.Periodo;
import entidades.Roles;
import entidades.TipoCh;
import entidades.Usuarios;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import sesiones.estandar.PeriodoFacade;
import sesiones.estandar.RolesFacade;
import sesiones.estandar.TipoChFacade;
import sesiones.estandar.UsuariosFacade;
import sesiones.modulo1.CursoAulaDao;
import sesiones.modulo1.DummyData;
import sesiones.modulo1.HorarioDao;

/**
 *
 * @author Alex
 */
@ManagedBean(name = "horarioCtrl")
@ViewScoped
public class HorarioCtrl {

    @Inject
    HorarioDao horarioDao;
    @Inject
    TipoChFacade tipoChDao;
    @Inject
    DummyData dummyData;
    @Inject
    CursoAulaDao cursoAula;

    @Inject
    UsuariosFacade usuariosFacade;
    @Inject
    PeriodoFacade periodoFacade;
    @Inject
    RolesFacade rolesFacade;

    private List<HorarioVisual> horariosVisual;
    private List<TipoCh> actividades;
    private List<CursoAula> cursos;

    private List<Periodo> periodos;
    private List<Usuarios> usuarios;
    private Periodo periodo;
    private Usuarios usuario;

    private String selectedUser;
    private Integer selectedPeriodo;
    private String urlReporte;
    private Date selectedInicio, selectedFin;

    public HorarioCtrl() {

    }

    @PostConstruct
    public void init() {
        actividades = new ArrayList<>();
        TipoCh a1 = new TipoCh(0, "");
        actividades.add(a1);
        actividades.addAll(tipoChDao.findAll());

        cursos = new ArrayList<>();
        //CursoAula c1 = new CursoAula();
        //c1.setId(0);
       // c1.setAula(0);
        //c1.setNomenclatura("");
        //cursos.add(c1);
        cursos.addAll(cursoAula.findAllAulasByOrder());

        // Roles
        Roles rol = rolesFacade.findAll().stream().filter(r -> r.getNombre().toLowerCase().contains("docente")).findFirst().orElse(null);
        //usuarios = usuariosFacade.findAll();
        usuarios = usuariosFacade.findUsuario();
        usuarios = usuarios.stream().filter(u -> u.getRolUsuarioList().stream().anyMatch(r -> r.getCodRol().equals(rol))).collect(Collectors.toList());

        periodos = periodoFacade.findAll();
    }

    private void loadHorario() {
        List<HorarioActividades> horariosOri = horarioDao.findAllByPeriodoIdAndUsuariosId(periodo.getId(), usuario.getId());

        if (horariosOri.size() < 1) {
            horariosVisual = new ArrayList<>();
            LocalTime start = LocalTime.of(7, 0, 0);
            for (int i = 0; i < 14; i++) {
                LocalTime hora = start.plusHours(i);
                HorarioVisual hv = new HorarioVisual();
                hv.setHora(Time.valueOf(hora));
                hv.setPeriodo(periodo);
                hv.setUsuarios(usuario);
                try {
                    for (int j = 1; j < 7; j++) {
                        hv.getClass().getMethod("setActividad" + j, TipoCh.class)
                                .invoke(hv, new TipoCh());

                        hv.getClass().getMethod("setCurso" + j, CursoAula.class)
                                .invoke(hv, new CursoAula());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                horariosVisual.add(hv);
            }
        } else {
            horariosVisual = dummyData.horariosVisual(horariosOri);
        }

        horariosVisual.forEach(hv -> {
            hv.setPeriodo(periodo);
            hv.setUsuarios(usuario);
        });
    }

    public void onRowEdit(CellEditEvent event) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        HorarioVisual hv = (HorarioVisual) ((DataTable) event.getComponent()).getRowData();

        for (int i = 1; i < 7; i++) {
            hv.getClass().getMethod("setActividad" + i, TipoCh.class)
                    .invoke(hv, lookupActividadNombre(HorarioVisual.class.getMethod("getActividad" + i).invoke(hv)));
        }
        for (int i = 1; i < 7; i++) {
            hv.getClass().getMethod("setCurso" + i, CursoAula.class)
                    .invoke(hv, lookupCurso(HorarioVisual.class.getMethod("getCurso" + i).invoke(hv)));
        }

    }

    private Object lookupActividadNombre(Object hv) {
        if (hv != null && ((TipoCh) hv).getId() != null) {
            TipoCh tch = actividades.stream().filter(a -> a.getId().equals(((TipoCh) hv).getId())).findFirst().orElse((TipoCh) hv);
            TipoCh hv2 = (TipoCh) hv;
            hv2.setNombre(tch.getNombre());
            return hv2;
        } else {
            return new TipoCh();
        }
    }

    private Object lookupCurso(Object hv) {
        if (hv != null && ((CursoAula) hv).getId() != null) {
            CursoAula ca = cursos.stream().filter(a -> a.getId().equals(((CursoAula) hv).getId())).findFirst().orElse((CursoAula) hv);
            CursoAula hv2 = (CursoAula) hv;
            hv2.setNomenclatura(ca.getNomenclatura());
            hv2.setAula(ca.getAula());
            return hv2;
        } else {
            return new CursoAula();
        }
    }

    public void save() {
        try {
            List<HorarioActividades> hvs = dummyData.fromHorarioVisual(horariosVisual);
            horarioDao.deleteFromUser(selectedUser);
            hvs.forEach(c -> horarioDao.edit(c));
            loadHorario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!", null));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            loadHorario();
        }
    }

    public void onPeriodoProfesorChange() {
        horariosVisual = new ArrayList<>();
        try {
            System.out.println("p->" + selectedPeriodo + ", u->" + selectedUser);
            periodo = periodos.stream().filter(p -> p.getId() == selectedPeriodo).findFirst().orElse(null);
            usuario = usuarios.stream().filter(p -> p.getId().equals(selectedUser)).findFirst().orElse(null);
            System.out.println("p->" + periodo + ", u->" + usuario);

            loadHorario();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onPeriodoChange() {
        periodo = periodos.stream().filter(p -> p.getId() == selectedPeriodo).findFirst().orElse(null);
        if (periodo != null) {
            selectedInicio = periodo.getInicio();
            selectedFin = periodo.getFin();
        }
    }

    public void generarReporte(ActionEvent event) {
        String url = "http://localhost:9090/?periodoId=%d&usuarioId=%s&inicio=%s&fin=%s";
        //String url = "http://10.20.1.181:9090/?periodoId=%d&usuarioId=%s&inicio=%s&fin=%s";
        //String url = "http://10.20.1.181:9090/?periodoId=%d&usuarioId=%s";
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        urlReporte = String.format(url, selectedPeriodo, selectedUser, DATE_FORMAT.format(selectedInicio), DATE_FORMAT.format(selectedFin));

        String javaScriptText = "window.open('" + urlReporte + "', 'popupWindow', 'dependent=yes, menubar=no, toolbar=no');";
        RequestContext.getCurrentInstance().execute("document.getElementById(\"bModalRol\").click();");
    }

    public HorarioDao getHorarioDao() {
        return horarioDao;
    }

    public void setHorarioDao(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }

    public TipoChFacade getTipoChDao() {
        return tipoChDao;
    }

    public void setTipoChDao(TipoChFacade tipoChDao) {
        this.tipoChDao = tipoChDao;
    }

    public DummyData getDummyData() {
        return dummyData;
    }

    public void setDummyData(DummyData dummyData) {
        this.dummyData = dummyData;
    }

    public List<HorarioVisual> getHorariosVisual() {
        return horariosVisual;
    }

    public void setHorariosVisual(List<HorarioVisual> horariosVisual) {
        this.horariosVisual = horariosVisual;
    }

    public List<TipoCh> getActividades() {
        return actividades;
    }

    public void setActividades(List<TipoCh> actividades) {
        this.actividades = actividades;
    }

    public CursoAulaDao getCursoAula() {
        return cursoAula;
    }

    public void setCursoAula(CursoAulaDao cursoAula) {
        this.cursoAula = cursoAula;
    }

    public List<CursoAula> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoAula> cursos) {
        this.cursos = cursos;
    }

    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public PeriodoFacade getPeriodoFacade() {
        return periodoFacade;
    }

    public void setPeriodoFacade(PeriodoFacade periodoFacade) {
        this.periodoFacade = periodoFacade;
    }

    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }

    public void setRolesFacade(RolesFacade rolesFacade) {
        this.rolesFacade = rolesFacade;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Integer getSelectedPeriodo() {
        return selectedPeriodo;
    }

    public void setSelectedPeriodo(Integer selectedPeriodo) {
        this.selectedPeriodo = selectedPeriodo;
    }

    public String getUrlReporte() {
        return urlReporte;
    }

    public void setUrlReporte(String urlReporte) {
        this.urlReporte = urlReporte;
    }

    public Date getSelectedInicio() {
        return selectedInicio;
    }

    public void setSelectedInicio(Date selectedInicio) {
        this.selectedInicio = selectedInicio;
    }

    public Date getSelectedFin() {
        return selectedFin;
    }

    public void setSelectedFin(Date selectedFin) {
        this.selectedFin = selectedFin;
    }

}
