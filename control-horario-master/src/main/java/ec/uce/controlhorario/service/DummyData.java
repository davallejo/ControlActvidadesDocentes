package ec.uce.controlhorario.service;

import ec.uce.controlhorario.dao.*;
import ec.uce.controlhorario.entidad.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DummyData {

    private final PeriodoDao periodoDao;
    private final PerfilDao perfilDao;
    private final HorarioDao horarioDao;
    private final UsuarioDao usuarioDao;
    private final RegistroDao registroDao;
    private final TipoChDao tipoChDao;

    public DummyData(PeriodoDao periodoDao, PerfilDao perfilDao, HorarioDao horarioDao, UsuarioDao usuarioDao, RegistroDao registroDao, TipoChDao tipoChDao) {
        this.periodoDao = periodoDao;
        this.perfilDao = perfilDao;
        this.horarioDao = horarioDao;
        this.usuarioDao = usuarioDao;
        this.registroDao = registroDao;
        this.tipoChDao = tipoChDao;
    }


    public List<Horario> fromHorarioVisual(List<HorarioVisual> horariosVisual) {
        List<Horario> horarios = new ArrayList<>();

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

                if (actividad != null && actividad.getId() != null && curso != null && curso.getId() != null && curso.getId() != 0) {
                    Optional<Horario> horario = horarios.stream().filter(p -> p.getActividad().getId().equals(actividad.getId())
                            && p.getCurso().equals(curso) && p.getHoraFin().compareTo(hvc.getHora()) == 0
                    ).findFirst();

                    if (horario.isPresent()) {
                        horario.get().setHoraFin(Time.valueOf(horario.get().getHoraFin().toLocalTime().plusHours(1)));
                    } else {
                        Horario newHorario = new Horario();
                        newHorario.setHoraInicio(hvc.getHora());
                        newHorario.setHoraFin(Time.valueOf(hvc.getHora().toLocalTime().plusHours(1)));
                        newHorario.setId(id);
                        newHorario.setActividad(actividad);
                        newHorario.setCurso(curso);
                        newHorario.setPeriodo(hvc.getPeriodo());
                        newHorario.setUsuarios(hvc.getUsuarios());
                        newHorario.setDia(finalI);
                        horarios.add(newHorario);
                    }
                }

            });
        }

        return horarios;
    }

    public List<HorarioVisual> horariosVisual(List<Horario> horarios) {
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
                hvc.setPeriodo(e.getPeriodo());
                hvc.setUsuarios(e.getUsuarios());
                switch (e.getDia()) {
                    case 1:
                        hvc.setActividad1(e.getActividad());
                        hvc.setCurso1(e.getCurso());
                        hvc.setId1(e.getId());
                        break;
                    case 2:
                        hvc.setActividad2(e.getActividad());
                        hvc.setCurso2(e.getCurso());
                        hvc.setId2(e.getId());
                        break;
                    case 3:
                        hvc.setActividad3(e.getActividad());
                        hvc.setCurso3(e.getCurso());
                        hvc.setId3(e.getId());
                        break;
                    case 4:
                        hvc.setActividad4(e.getActividad());
                        hvc.setCurso4(e.getCurso());
                        hvc.setId4(e.getId());
                        break;
                    case 5:
                        hvc.setActividad5(e.getActividad());
                        hvc.setCurso5(e.getCurso());
                        hvc.setId5(e.getId());
                        break;
                    case 6:
                        hvc.setActividad6(e.getActividad());
                        hvc.setCurso6(e.getCurso());
                        hvc.setId6(e.getId());
                        break;
                }
            }
        });

        return horariosVisual;
    }
}
