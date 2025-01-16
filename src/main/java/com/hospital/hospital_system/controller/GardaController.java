package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.GardaDto;
import com.hospital.hospital_system.models.Garda;
import com.hospital.hospital_system.service.DocumentException;
import com.hospital.hospital_system.service.GardaService;
import com.hospital.hospital_system.service.PdfExportService;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class GardaController {

    private static final Logger logger = LoggerFactory.getLogger(GardaController.class);
    private final GardaService gardaService;

    @Autowired
    public GardaController(GardaService gardaService) {
        this.gardaService = gardaService;
    }

    // Afișarea listei de gărzi cu posibilitatea de filtrare
    @GetMapping("/garda")
    public String getGardaPage(@RequestParam(value = "search", required = false) String searchTerm,
                               @RequestParam(value = "idDoc", required = false) Integer idDoc,
                               @RequestParam(value = "idAsistent", required = false) Integer idAsistent,
                               @RequestParam(value = "persTip", required = false) String persTip,
                               Model model) {
        try {
            List<GardaDto> gardaList;  // schimbă numele variabilei pentru consistență
            if (searchTerm != null && !searchTerm.isEmpty() || idDoc != null || idAsistent != null || persTip != null) {
                gardaList = gardaService.searchGarda(searchTerm, idDoc, idAsistent, persTip);
            } else {
                gardaList = gardaService.findAllGarda();
            }
            model.addAttribute("gardaList", gardaList);  // actualizează modelul cu gardaList
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("idDoc", idDoc);
            model.addAttribute("idAsistent", idAsistent);
            model.addAttribute("persTip", persTip);
            logger.info("Accessing /garda endpoint: Retrieved {} garda", gardaList.size());
            return "garda";  // te asiguri că view-ul este corect
        } catch (Exception e) {
            logger.error("Error occurred while retrieving garda", e);
            model.addAttribute("error", "An error occurred while retrieving the list of garda.");
            return "error";
        }
    }

    // Formular pentru adăugarea unei noi gărzi
    @GetMapping("/garda/new")
    public String showAddGardaForm(Model model) {
        model.addAttribute("garda", new GardaDto());
        return "new-garda";
    }

//    @PostMapping("/garda/add")
//    public String addGarda(@ModelAttribute GardaDto gardaDto) {
//        gardaService.addGarda(gardaDto);
//        return "redirect:/garda";
//    }

    @PostMapping("/garda/add")
    public String addGarda(@ModelAttribute GardaDto gardaDto) {
        try {
            // Dacă consumabilele folosite sunt nule, setează o valoare default
            if (gardaDto.getConsumabileFolosite() == null) {
                gardaDto.setConsumabileFolosite("N/A");  // Exemplu de valoare default
            }

            gardaService.addGarda(gardaDto);  // Adaugă garda folosind DTO-ul
            return "redirect:/garda";  // Redirecționează după adăugare
        } catch (Exception e) {
            logger.error("Error adding new garda: {}", e.getMessage());
            return "error";  // Răspuns în caz de eroare
        }
    }



    // Formular pentru editarea unei gărzi
    @GetMapping("/garda/edit/{id}")
    public String showEditGardaForm(@PathVariable int id, Model model) {
        GardaDto gardaDto = gardaService.findById(id);
        model.addAttribute("garda", gardaDto);
        return "edit-garda";
    }

    // Actualizarea unei gărzi existente
    @PostMapping("/garda/update/{id}")
    public String updateGarda(@PathVariable int id, @ModelAttribute GardaDto gardaDto) {
        try {
            gardaService.updateGarda(id, gardaDto); // actualizează garda folosind DTO-ul
            return "redirect:/garda"; // Redirecționează după actualizare
        } catch (Exception e) {
            logger.error("Error updating garda with id {}: {}", id, e.getMessage());
            return "error";  // Răspuns în caz de eroare
        }
    }

    // Ștergerea unei gărzi
    @GetMapping("/garda/delete/{id}")
    public String deleteGarda(@PathVariable int id, Model model) {
        try {
            gardaService.deleteGarda(id);
            return "redirect:/garda";  // Dacă totul merge bine, redirecționează către lista de gărzi
        } catch (Exception e) {
            logger.error("Error occurred while deleting garda with ID {}: {}", id, e.getMessage());
            model.addAttribute("error", "An error occurred while deleting the garda. Please try again later.");
            return "error";  // Afișează o pagină de eroare personalizată
        }
    }



    // Metoda care salvează garda
    @PostMapping("/save")
    public String saveGarda(@ModelAttribute("garda") Garda garda, Model model) {
        try {
            gardaService.saveGarda(garda);
            return "redirect:/garda";  // Redirecționează către pagina de vizualizare gărzi
        } catch (Exception e) {
            model.addAttribute("error", "A apărut o eroare la salvarea gărzii.");
            return "garda-form";  // Dacă există o eroare, rămâne pe aceeași pagină
        }
    }


    @GetMapping("/garda/export")
    public void exportGardaData(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=garda_data.csv");

        List<GardaDto> gardaList = gardaService.findAllGarda();

        try (CSVWriter writer = new CSVWriter(response.getWriter())) {
            String[] header = {"ID Garda", "ID Doctor", "ID Asistent", "Tip Persoană", "Data Început", "Data Sfârșit", "Nr. Pacienți Îngrijiți", "Consumabile Folosite"};
            writer.writeNext(header);

            for (GardaDto garda : gardaList) {
                String[] data = {
                        String.valueOf(garda.getIdGarda()),
                        String.valueOf(garda.getIdDoc()),
                        String.valueOf(garda.getIdAsistent()),
                        garda.getPersTip(),
                        garda.getDataInceput().toString(),
                        garda.getDataSfarsit().toString(),
                        String.valueOf(garda.getNrPacientiIngrijiti()),
                        garda.getConsumabileFolosite()
                };
                writer.writeNext(data);
            }
        }
    }

    @Autowired
    private PdfExportService pdfExportService;

    @GetMapping("/exportGarda")
    public ResponseEntity<byte[]> exportGarda() throws IOException, DocumentException {
        logger.info("Export PDF requested for Garda"); // Log pentru debugging

        // Obținem lista de gărzi din serviciu
        List<GardaDto> gardaList = gardaService.findAllGarda();

        // Generăm fișierul PDF cu lista de gărzi

        ByteArrayOutputStream pdfStream = pdfExportService.generateGardaTablePdf(gardaList);

        // Transformăm în byte array pentru a trimite ca răspuns
        byte[] pdfBytes = pdfStream.toByteArray();

        logger.info("PDF generated successfully for Garda");

        // Returnăm PDF-ul ca răspuns cu header-ul necesar pentru descărcare
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=GardaList.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
