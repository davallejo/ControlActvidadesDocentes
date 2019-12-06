package ec.uce.controlhorario;

import ec.uce.controlhorario.dao.HorarioDao;
import ec.uce.controlhorario.entidad.Horario;
import ec.uce.controlhorario.entidad.HorarioVisual;
import ec.uce.controlhorario.service.DummyData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlhorarioApplicationTests {

    @Autowired
    DummyData dummyData;

    @Autowired
    HorarioDao horarioDao;

    @Test
    public void contextLoads() {
        List<Horario> horariosOrg = horarioDao.findAll();
        List<HorarioVisual> horarioVisuals = dummyData.horariosVisual(horariosOrg);
        List<Horario> horarios = dummyData.fromHorarioVisual(horarioVisuals);

        System.out.println(horariosOrg.size() + " | " + horarioVisuals.size() + " | " + horarios.size());

        assertEquals(horariosOrg.size(), horarios.size());

    }

}
