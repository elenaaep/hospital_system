package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.PacientiDto;
import com.hospital.hospital_system.models.Pacienti;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfExportService {

    public ByteArrayOutputStream generatePacientTablePdf(List<PacientiDto> pacienti) throws DocumentException, IOException {
        // Crearea unui flux de ieșire pentru PDF
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Inițializare PdfWriter și PdfDocument
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);

        // Crearea documentului
        Document document = new Document(pdfDocument);
        document.add(new Paragraph("Lista Pacienților").setFontSize(20).setBold());


        // Crearea unui tabel cu 13 coloane
        Table table = new Table(13);

        // Adăugarea antetului tabelului
        table.addCell("ID");
        table.addCell("Nume");
        table.addCell("Prenume");
        table.addCell("CNP");
        table.addCell("Data Nașterii");
        table.addCell("Gen");
        table.addCell("Vârstă");
        table.addCell("Adresă");
        table.addCell("Telefon");
        table.addCell("Email");
        table.addCell("Grupa de sânge");
        table.addCell("Rh");
        table.addCell("Acțiuni");

        // Adăugarea datelor pacienților
        for (PacientiDto pacient : pacienti) {
            table.addCell(String.valueOf(pacient.getIdPacient()));
            table.addCell(pacient.getNume());
            table.addCell(pacient.getPrenume());
            table.addCell(pacient.getCnp());
            table.addCell(pacient.getDataNasterii().toString());  // Poți formata data dacă este nevoie
            table.addCell(pacient.getGen());
            table.addCell(String.valueOf(pacient.getVarsta()));
            table.addCell(pacient.getAdresa());
            table.addCell(String.valueOf(pacient.getTel()));
            table.addCell(pacient.getEmail());
            table.addCell(pacient.getGrupaSange());
            table.addCell(pacient.getRh());
            table.addCell(""); // Acțiuni (poți adăuga și acțiuni, dar sunt inutile într-un PDF static)
        }

        // Adăugarea tabelului în document
        document.add(table);

        // Închiderea documentului PDF
        document.close();

        // Returnarea fișierului PDF generat
        return byteArrayOutputStream;
    }
}
