/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo1;

import entidades.CursoAula;
import entidades.HorarioActividades;
import entidades.HorarioVisual;
import entidades.TipoCh;
import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Alex
 */
@Stateless
@LocalBean
public class DummyData {

    public List<HorarioActividades> fromHorarioVisual(List<HorarioVisual> horariosVisual) {
        List<HorarioActividades> horarios = new ArrayList<>();

        horariosVisual.sort(Comparator.comparing(HorarioVisual::getHora));
        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            horariosVisual.forEach(hvc -> {

                final TipoCh actividad;
                final CursoAula curso;
                //final String curso;
                final Integer id;

                //#region switch dia/fecha
                switch (finalI) {
                    case 1:
                        actividad = hvc.getActividad1();
                        curso = hvc.getCurso1();
                        id = hvc.getId1();
                        break;
                    case 2:
                        actividad = hvc.getActividad2();
                        curso = hvc.getCurso2();
                        id = hvc.getId2();
                        break;
                    case 3:
                        actividad = hvc.getActividad3();
                        curso = hvc.getCurso3();
                        id = hvc.getId3();
                        break;
                    case 4:
                        actividad = hvc.getActividad4();
                        curso = hvc.getCurso4();
                        id = hvc.getId4();
                        break;
                    case 5:
                        actividad = hvc.getActividad5();
                        curso = hvc.getCurso5();
                        id = hvc.getId5();
                        break;
                    case 6:
                        actividad = hvc.getActividad6();
                        curso = hvc.getCurso6();
                        id = hvc.getId6();
                        break;
                    default:
                        actividad = null;
                        curso = null;
                        id = null;
                }
                //#endregion

                if (actividad != null && actividad.getId() != null && actividad.getId() != 0 && curso != null && curso.getId() != null && curso.getId() != 0) {
                    Optional<HorarioActividades> horario = horarios.stream().filter(p -> p.getIdTipoch().getId().equals(actividad.getId())
                            && p.getIdCursoAula().equals(curso) && p.getHoraFin().compareTo(hvc.getHora()) == 0 && p.getDia() == finalI
                    ).findFirst();

                    if (horario.isPresent()) {
                        horario.get().setHoraFin(Time.valueOf(horario.get().getHoraFin().toLocalTime().plusHours(1)));
                    } else {
                        HorarioActividades newHorario = new HorarioActividades();
                        newHorario.setHoraInicio(hvc.getHora());
                        newHorario.setHoraFin(Time.valueOf(hvc.getHora().toLocalTime().plusHours(1)));
                        newHorario.setId(id);
                        newHorario.setIdTipoch(actividad);
                        newHorario.setIdCursoAula(curso);
                        newHorario.setIdPeriodo(hvc.getPeriodo());
                        newHorario.setIdUsuario(hvc.getUsuarios());
                        newHorario.setDia(finalI);
                        horarios.add(newHorario);
                    }
                }

            });
        }

        return horarios;
    }

    public List<HorarioVisual> horariosVisual(List<HorarioActividades> horarios) {
        //to VISUAL
        List<HorarioVisual> horariosVisual = new ArrayList<>();
        // construir dummy horas
        LocalTime start = LocalTime.of(7, 0, 0);
        for (int i = 0; i < 14; i++) {
            LocalTime hora = start.plusHours(i);
            HorarioVisual hv = new HorarioVisual();
            hv.setHora(Time.valueOf(hora));

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
        //llenar con horas activas
        horarios.forEach(e -> {
            long horas = ChronoUnit.HOURS.between(e.getHoraInicio().toLocalTime(), e.getHoraFin().toLocalTime());
            for (int i = 0; i < horas; i++) {
                LocalTime hora = e.getHoraInicio().toLocalTime().plusHours(i);
                HorarioVisual hvc = horariosVisual.stream().filter(hv -> hv.getHora().toLocalTime().compareTo(hora) == 0).findFirst().get();
                hvc.setPeriodo(e.getIdPeriodo());
                hvc.setUsuarios(e.getIdUsuario());

                try {
                    Object OActividad = hvc.getClass().getMethod("getActividad" + e.getDia())
                            .invoke(hvc);
                    TipoCh actividad = (TipoCh) OActividad;

                    Object OCurso = hvc.getClass().getMethod("getCurso" + e.getDia())
                            .invoke(hvc);
                    CursoAula curso = (CursoAula) OCurso;

                    actividad.setId(e.getIdTipoch().getId());
                    actividad.setNombre(e.getIdTipoch().getNombre());

                    curso.setId(e.getIdCursoAula().getId());
                    curso.setAula(e.getIdCursoAula().getAula());
                    curso.setNomenclatura(e.getIdCursoAula().getNomenclatura());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        return horariosVisual;
    }
}
