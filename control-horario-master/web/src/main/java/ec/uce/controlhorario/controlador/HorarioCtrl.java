package ec.uce.controlhorario.controlador;

import ec.uce.controlhorario.dao.HorarioDao;
import ec.uce.controlhorario.dao.TipoChDao;
import ec.uce.controlhorario.entidad.Horario;
import ec.uce.controlhorario.entidad.HorarioVisual;
import ec.uce.controlhorario.entidad.TipoCh;
import ec.uce.controlhorario.service.DummyData;
import lombok.Data;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dacopanCM on 02/04/18.
 */
@Controller("horarioCtrl")
@Scope("view")
@Data
public class HorarioCtrl {

    @Autowired
    HorarioDao horarioDao;

    @Autowired
    TipoChDao tipoChDao;

    @Autowired
    DummyData dummyData;

    List<HorarioVisual> horariosVisual;
    List<TipoCh> actividades;

    @PostConstruct
    public void init() {
        List<Horario> horariosOri = horarioDao.findAllByPeriodoIdAndUsuariosId(1, 1);
        if (horariosOri.size() < 1) {
            horariosVisual = new ArrayList<>();
            LocalTime start = LocalTime.of(7, 0, 0);
            for (int i = 0; i < 14; i++) {
                LocalTime hora = start.plusHours(i);
                HorarioVisual hv = new HorarioVisual();
                hv.setHora(Time.valueOf(hora));
                hv.setActividad1(new TipoCh());
                horariosVisual.add(hv);
            }
        } else {
            horariosVisual = dummyData.horariosVisual(horariosOri);
        }
        actividades = tipoChDao.findAll();
    }

    public void onRowEdit(CellEditEvent event) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        HorarioVisual hv = (HorarioVisual) ((DataTable) event.getComponent()).getRowData();

        for (int i = 1; i < 7; i++) {
            hv.getClass().getMethod("setActividad" + i, TipoCh.class)
                    .invoke(hv, lookupActividadNombre(HorarioVisual.class.getMethod("getActividad" + i).invoke(hv)));
        }

    }

    private Object lookupActividadNombre(Object hv) {
        if (hv != null && ((TipoCh) hv).getId() != null) {
            return actividades.stream().filter(a -> a.getId().equals(((TipoCh) hv).getId())).findFirst().orElse((TipoCh) hv);
        } else return hv;
    }


    public void save() {
        try {
            horarioDao.saveAll(dummyData.fromHorarioVisual(horariosVisual));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!", null));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
        }
    }
}
