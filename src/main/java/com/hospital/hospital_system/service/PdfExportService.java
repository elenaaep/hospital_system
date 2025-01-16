package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.GardaDto;
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

    // Funcția care generează PDF-ul pentru lista de gărzi
    public ByteArrayOutputStream generateGardaTablePdf(List<GardaDto> gardaList) throws DocumentException, IOException {
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();

        // Creăm PdfWriter pentru a scrie în ByteArrayOutputStream
        PdfWriter writer = new PdfWriter(pdfStream);

        // Creăm obiectul PdfDocument
        PdfDocument pdfDocument = new PdfDocument(writer);

        // Creăm Document pentru a adăuga elemente
        Document document = new Document(pdfDocument);

        // Creăm tabelul cu 8 coloane (în funcție de structura gărzii)
        Table table = new Table(8);
        table.addCell("ID Garda");
        table.addCell("ID Doctor");
        table.addCell("ID Asistent");
        table.addCell("Tip Persoană");
        table.addCell("Data Început");
        table.addCell("Data Sfârșit");
        table.addCell("Nr. Pacienți Îngrijiți");
        table.addCell("Consumabile Folosite");

        // Iterăm prin lista de gărzi și adăugăm datele în tabel
        for (GardaDto garda : gardaList) {
            table.addCell(String.valueOf(garda.getIdGarda()));
            table.addCell(String.valueOf(garda.getIdDoc()));
            table.addCell(String.valueOf(garda.getIdAsistent()));
            table.addCell(garda.getPersTip());
            table.addCell(garda.getDataInceput().toString());
            table.addCell(garda.getDataSfarsit().toString());
            table.addCell(String.valueOf(garda.getNrPacientiIngrijiti()));
            table.addCell(garda.getConsumabileFolosite());
        }

        // Adăugăm tabelul în document
        document.add(table);

        // Închidem documentul pentru a finaliza PDF-ul
        document.close();

        return pdfStream;
    }
}
