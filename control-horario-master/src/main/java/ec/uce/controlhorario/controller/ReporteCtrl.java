package ec.uce.controlhorario.controller;

import ec.uce.controlhorario.dao.PeriodoDao;
import ec.uce.controlhorario.entidad.Asistencia;
import ec.uce.controlhorario.entidad.Periodo;
import ec.uce.controlhorario.entidad.Usuarios;
import ec.uce.controlhorario.service.ReporteService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReporteCtrl {

    private final Log log = LogFactory.getLog(getClass());

    private final ReporteService report;
    private final PeriodoDao periodoDao;


    public ReporteCtrl(ReporteService reporteService, PeriodoDao periodoDao) {
        this.report = reporteService;
        this.periodoDao = periodoDao;
    }

    //@GetMapping(value = "/", produces = MediaType.APPLICATION_PDF_VALUE)
    @GetMapping(value = "/")
    public void getReport(@RequestParam Integer periodoId, @RequestParam String usuarioId,
                          @RequestParam @DateTimeFormat(pattern="yyyyMMdd") Date inicio, @RequestParam @DateTimeFormat(pattern="yyyyMMdd") Date fin,
                          HttpServletResponse response) throws IOException {

        List<Asistencia> asistenciaList = report.generarAsistencia(periodoId, usuarioId,new java.sql.Date(inicio.getTime()),new java.sql.Date(fin.getTime()));
        boolean excel = false;

        Usuarios u = report.findUser(usuarioId);
        Map<String, Object> params = new HashMap<>();
        params.put("periodo", periodoDao.findById(periodoId).orElse(new Periodo()).getNombre());
        params.put("usuarioId", usuarioId);
        params.put("nombre", u.getNombreP() + " " + u.getApellidoP());
        params.put("contrato", u.getPerfiles().stream().findFirst().get().getNombre());
        params.put("horario", usuarioId);
        params.put("inicio", inicio);
        params.put("fin", fin);

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename=" + "Reporte_de_Asistencia" + usuarioId + "_" + LocalDateTime.now().toString() + ".pdf");

        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();
            JasperPrint reportPrint = report.init("horario.jasper", params, new JRBeanCollectionDataSource(asistenciaList));

            ByteArrayOutputStream os = null;
            if (excel) {
                os = report.openExcel(reportPrint, "Reporte_de_Asistencia" + usuarioId + "_" + LocalDateTime.now().toString());
                servletOutputStream.write(os.toByteArray());
//                os.flush();
//                os.close();
            } else {
                JasperExportManager.exportReportToPdfStream(reportPrint, servletOutputStream);
            }
        } catch (IOException | JRException ex) {
            log.error("error al generar reporte", ex);
            //showError("Ops!", "Error al generar reporte");
        }

    }

}
