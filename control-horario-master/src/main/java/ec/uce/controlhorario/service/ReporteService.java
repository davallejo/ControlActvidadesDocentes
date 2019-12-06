package ec.uce.controlhorario.service;

import ec.uce.controlhorario.dao.HorarioDao;
import ec.uce.controlhorario.dao.RegistroDao;
import ec.uce.controlhorario.dao.UsuarioDao;
import ec.uce.controlhorario.entidad.Asistencia;
import ec.uce.controlhorario.entidad.Horario;
import ec.uce.controlhorario.entidad.RegistroTimbre;
import ec.uce.controlhorario.entidad.Usuarios;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.sql.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReporteService {

    private final Log log = LogFactory.getLog(getClass());

    private final HorarioDao horarioDao;
    private final RegistroDao registroDao;
    private final DataSource dataSource;
    private final UsuarioDao usuarioDao;

    public ReporteService(HorarioDao horarioDao, RegistroDao registroDao, DataSource dataSource, UsuarioDao usuarioDao) {
        this.horarioDao = horarioDao;
        this.registroDao = registroDao;
        this.dataSource = dataSource;
        this.usuarioDao = usuarioDao;
    }

    public List<Asistencia> generarAsistencia(Integer periodoId, String usuarioId, Date inicio, Date fin) {
        List<Asistencia> result = new ArrayList<>();

        //Trae el horario del profesor sengun el periodo y el periodo del docente
        List<Horario> horasClase = horarioDao.findAllByPeriodoIdAndUsuariosId(periodoId, usuarioId);
        if (horasClase.size() < 1) {
            return result;
        }
        //trae el unicio horario que existe con el periodo e Id del docente
        Horario horario = horasClase.get(0);
        //Trae el listado de marcaciones del docente de inicio a fin
        List<RegistroTimbre> registro = registroDao.findAllByUsuarioIdAndFechaBetween(usuarioId, inicio, fin);


        //.withDayOfMonth(1);
        //LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());

       /* LocalDate start = horario.getPeriodo().getInicio().toLocalDate();
        LocalDate end = horario.getPeriodo().getFin().toLocalDate();*/

        //se obtiene la fecha de inicio del analisis
        LocalDate start = inicio.toLocalDate();
        //se suma 1 dia a la fecha de fin del analisis
        LocalDate end = fin.toLocalDate().plusDays(1);

        // recorremos dia a dia, los dias del semestre
        ArrayList<LocalTime> marcaciones = new ArrayList<>();
        ArrayList<String> actividades = new ArrayList<>();
        List<Registros> registrados = new ArrayList<>();
        LocalTime defecto = LocalTime.of(00, 00, 00);
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            //Se imprime el dia que se analiza
            System.out.println("procesando fecha: " + date);
            //Se asigna el dia en curso a finalDate
            LocalDate finalDate = date;
            // de cada dia tiene varias horasClase entonces recorrermos todas las horas clase del dia en curso
            //horasClase -> Es el horario del docente
            AtomicInteger var = new AtomicInteger();
            var.set(0);

            //Se obtienen las actividades del dia
            horasClase.stream().filter(q -> q.getDia() == finalDate.getDayOfWeek().getValue()).forEach(q -> {
                actividades.add(q.getActividad().getNombre());

            });

            if (actividades.isEmpty()) {
                System.out.println("Actividades del dia: " + finalDate.toString() + ", no se encontraron. ");
            } else {
                System.out.println("Actividades del dia: " + finalDate.toString() + ", son: " + actividades.toString());
            }

            //Se otienen las marcaciones de ese dia
            registro.stream().filter(r -> r.getFecha().toLocalDateTime().toLocalDate().isEqual(finalDate)).forEach(r -> {
                marcaciones.add(r.getFecha().toLocalDateTime().toLocalTime());
            });

            //Se reune todas las actividades agregando su timbre del reloj biométrico
            int indice = 0;

            for (Horario h : horasClase) {
                if (h.getDia() == finalDate.getDayOfWeek().getValue()) {
                    var.incrementAndGet();
                    Registros reg = new Registros();
                    reg.setActividad(h.getActividad().getNombre().toString());
                    reg.setInicio(h.getHoraInicio().toLocalTime());
                    reg.setFin(h.getHoraFin().toLocalTime());
                    if (!marcaciones.isEmpty()) {
                        reg.setEntrada(marcaciones.get(indice));
                        reg.setSalida(marcaciones.get(indice + 1));
                    } else {

                        reg.setEntrada(defecto);
                        reg.setSalida(defecto);
                    }
                    registrados.add(reg);
                    indice = indice + 2;
                }
            }

            //Se recorre cada actividad obtenida para controlar la asistencia
            registrados.forEach(v -> {
                Asistencia asistencia = new Asistencia();
                asistencia.setActividad(v.getActividad());  //asigna el nombre de la actividad
                asistencia.setDate(finalDate);  //asigna la fecha de la asistencia
                asistencia.setMinutosAtrazo(-1);    //asigna -1 en atraso
                asistencia.setMinutosSalida(-1);    //asigna -1 en atraso
                asistencia.setMes(finalDate.getMonthValue());   //asigna el mes de la asistencia


                //System.out.println("Evaluando ACTIVIDAD: " + h.getActividad().getNombre() + ", hora:" + timeReg.toString() + ", var= " + var1.get());
                // ChronoUnit.MINUTES.between(d1,d2)
                // positivo si d2>d1
                //Se calcula la diferencia de tiempo entre la hora que ha timbrado y la hora del horario
                //timeReg -> Es la hora en que ha timbrado
                //h -> Es el horario del docente
                long minutosEntrada = ChronoUnit.MINUTES.between(v.getEntrada(), v.getInicio());
                long minutosSalida = ChronoUnit.MINUTES.between(v.getSalida(), v.getFin());
                System.out.println(v.getEntrada() + ", " + v.getInicio().toString() + ", MinutosEntrada = " + minutosEntrada);
                System.out.println(v.getSalida().toString() + ", " + v.getFin().toString() + ", MinutosSalida = " + minutosSalida);
                long minutosEntradaAbs = Math.abs(minutosEntrada);
                long minutosSalidaAbs = Math.abs(minutosSalida);

                if (minutosEntradaAbs <= TOLERANCIA_NORMAL) {// entrada normal
                    asistencia.setMinutosAtrazo(0);
                    asistencia.setIngreso(v.getEntrada());
                    //System.out.println("ENTRADA NORMAL");

                } else if (minutosEntradaAbs >= TOLERANCIA_ATRAZO && minutosEntrada > 0) {//entrada anticipada
                    asistencia.setMinutosAtrazo(0);
                    asistencia.setIngreso(v.getEntrada());
                    //System.out.println("ENTRADA ANTICIPADA");
                } else if (minutosEntradaAbs >= TOLERANCIA_ATRAZO && minutosEntrada < 0) { // atrazo
                    asistencia.setMinutosAtrazo(minutosEntradaAbs);
                    asistencia.setIngreso(v.getEntrada());
                    //System.out.println("ENTRADA ATRAZO");
                }

                if (minutosSalidaAbs <= TOLERANCIA_NORMAL) {// salida normal
                    asistencia.setMinutosSalida(0);
                    asistencia.setSalida(v.getSalida());
                    //System.out.println("SALIDA NORMAL");

                } else if (minutosSalida <= 0 && minutosSalidaAbs >= TOLERANCIA_ATRAZO) {// salida pasada la hora
                    asistencia.setMinutosSalida(0);
                    asistencia.setSalida(v.getSalida());
                    //System.out.println("SALIDA EXTRA");
                } else if (minutosSalida >= 0 && minutosSalidaAbs >= TOLERANCIA_ATRAZO) {// salida anticipada
                    asistencia.setMinutosSalida(minutosSalidaAbs);
                    asistencia.setSalida(v.getSalida());
                    //System.out.println("SALIDA ANTICIPADA");
                }


                if (asistencia.getMinutosAtrazo() < 0 || (v.getEntrada() == defecto && v.getSalida() == defecto)) {
                    asistencia.setEstado(ESTADO_FALTA);
                    asistencia.setEstadoNum(3);
                    //System.out.println("Estado: FALTA");
                } else if (asistencia.getMinutosAtrazo() == 0 && minutosEntrada >= TOLERANCIA_NORMAL && v.getEntrada() != defecto) {
                    asistencia.setEstado(ESTADO_ENTRADA_ANTICIPADA);
                    asistencia.setEstadoNum(4);
                    //System.out.println("Entro a entrada anticipada");
                    //System.out.println("Estado: ENTRADA ANTICIPADA");

                } else if (asistencia.getMinutosAtrazo() > 0) {
                    asistencia.setEstado(ESTADO_ATRAZO);
                    asistencia.setEstadoNum(1);
                    //System.out.println("Estado: ATRAZO");
                } else if (asistencia.getMinutosAtrazo() == 0 && asistencia.getMinutosSalida() == 0 && minutosEntradaAbs <= TOLERANCIA_NORMAL && minutosSalidaAbs <= TOLERANCIA_NORMAL) {
                    asistencia.setEstado(ESTADO_NORMAL);
                    asistencia.setEstadoNum(0);
                    //System.out.println("Estado: NORMAL");
                } else if (minutosSalida < 0 && minutosSalidaAbs > TOLERANCIA_NORMAL && v.getEntrada() != defecto) {
                    asistencia.setEstado(ESTADO_SALIDA_EXTRA);
                    asistencia.setMinutosExtra(minutosSalidaAbs);
                    asistencia.setEstadoNum(5);
                    //System.out.println("Estado: Extra");

                } else if (minutosSalida > 0 && minutosSalidaAbs > TOLERANCIA_NORMAL && v.getSalida() != defecto) {
                    asistencia.setEstado(ESTADO_SALIDA_ANTICIPADA);
                    asistencia.setEstadoNum(2);
                    //System.out.println("Estado: SALIDA ANTICIPADA");
                } else if (v.getEntrada() != defecto && v.getSalida() == defecto) {
                    asistencia.setEstado(ESTADO_SIN_SALIDA);
                    asistencia.setEstadoNum(6);
                    //System.out.println("Estado: Sin Salida");
                } else if (v.getSalida() != defecto && v.getEntrada() == defecto) {
                    asistencia.setEstado(ESTADO_SIN_ENTRADA);
                    asistencia.setEstadoNum(7);
                    //System.out.println("Estado: Sin Entrada");
                }

                if (v.getEntrada() == defecto && v.getSalida() == defecto) {
                    asistencia.setMinutosAtrazo(0);
                    asistencia.setMinutosSalida(0);
                    asistencia.setIngreso(null);
                    asistencia.setSalida(null);
                }

                result.add(asistencia);
            });


            if (marcaciones.isEmpty()) {
                System.out.println("El dia " + finalDate.toString() + ", no registra marcaciones. ");
            } else {
                System.out.println("El dia " + finalDate.toString() + ", tiene las marcaciones: " + marcaciones.toString());
            }

            System.out.println("la matriz tiene: ");
            registrados.forEach(re -> {
                System.out.println("A: " + re.getActividad() + ", i: " + re.getInicio().toString() + ", f: " + re.getFin().toString() +
                        ", in: " + re.getEntrada() + ", out: " + re.getSalida());
            });

            actividades.clear();
            marcaciones.clear();
            registrados.clear();

        }


        result.forEach(r -> {
            if (r.getMinutosAtrazo() < 1) {
                r.setMinutosAtrazo(0);
            }
            if (r.getMinutosSalida() < 1) {
                r.setMinutosSalida(0);
            }
        });
        return result;
    }

    int TOLERANCIA_NORMAL = 15;
    int TOLERANCIA_ATRAZO = 15;
    String ESTADO_FALTA = "Falta";
    String ESTADO_NORMAL = "Normal";
    String ESTADO_ATRAZO = "Atrazo";
    String ESTADO_SALIDA_ANTICIPADA = "Salida Anticipada";
    String ESTADO_ENTRADA_ANTICIPADA = "Entrada Anticipada";
    String ESTADO_SALIDA_EXTRA = "Extra";
    String ESTADO_SIN_SALIDA = "Sin Salida";
    String ESTADO_SIN_ENTRADA = "Sin Entrada";


    /**
     * inicilaiza el JasperPrint para generar el reporte
     *
     * @param reportName nombre del reporte a generar relativo a {@literal /src/main/resources/report}
     * @param params     parametros del reporte
     * @param dataSource origen de datos del reporte
     * @return JasperPrint
     * @throws JRException si algun error
     */
    public JasperPrint init(String reportName, Map<String, Object> params, JRDataSource dataSource) throws JRException {
        //params.put("logo", config.isReportLogo());
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("" + reportName);
        return JasperFillManager.fillReport(stream, params, dataSource);
    }

    /**
     * inicilaiza el JasperPrint para generar el reporte
     *
     * @param reportName nombre del reporte a generar relativo a {@literal /src/main/resources/report}
     * @param params     parametros del reporte
     * @return JasperPrint
     * @throws JRException si algun error
     */
    public JasperPrint init(String reportName, Map<String, Object> params) throws JRException {
        JasperPrint print = null;
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("report/" + reportName);
            print = JasperFillManager.fillReport(stream, params, connection);

        } catch (Exception ex) {
            // ignorar error al generar reporte
            log.error("error al llenar reporte", ex);
        } finally {
            try {
                connection.close(); // cerramos la conexion
            } catch (SQLException ignored) {
                //ignorar no se requiere hacer nada aqui
            }
        }
        return print;
    }


    public ByteArrayOutputStream downloadPdf(JasperPrint jasperPrint, String filename) throws JRException, IOException {
        if (jasperPrint == null) {
            throw new RuntimeException("Error al generar reporte");
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        os.flush();
        os.close();
        return os;
    }


    public ByteArrayOutputStream openExcel(JasperPrint jasperPrint, String filename) throws JRException, IOException {
        if (jasperPrint == null) {
            throw new RuntimeException("Error al generar reporte");
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();


        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));

        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setCollapseRowSpan(false);
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        os.flush();
        os.close();
        return os;
    }

    public Usuarios findUser(String usuarioId) {
        return usuarioDao.findById(usuarioId).orElse(null);
    }
}
