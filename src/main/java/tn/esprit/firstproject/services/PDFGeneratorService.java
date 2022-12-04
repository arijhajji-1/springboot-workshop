package tn.esprit.firstproject.services;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.repositories.IContratRepository;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PDFGeneratorService {
    @Autowired
    private IContratRepository contratRepository ;



    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(7);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase(" ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Date debut", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Fin", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Archive", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Specialite", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Etudiant", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
        for (Contrat user : contrats) {
            table.addCell(String.valueOf(user.getIdContrat()));
            table.addCell(String.valueOf(user.getDateDebutContrat()));
            table.addCell(String.valueOf(user.getDateFinContrat()));

            table.addCell(String.valueOf(user.getArchive()));
            table.addCell(String.valueOf(user.getMontantContrat()));
            table.addCell(String.valueOf(user.getSpecialite()));
            table.addCell(String.valueOf(user.getEtudiant().getNom()));

        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        HtmlWriter.getInstance(document, new FileOutputStream("images_wrong.html"));
        HtmlWriter writer = HtmlWriter.getInstance(document, new FileOutputStream("images_right.html"));
        writer.setImagepath("./");


        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.PINK);



        Image jpg = Image.getInstance("Logo_ESPRIT_Ariana.jpg");
        jpg.scalePercent(5);
        jpg.setAlignment(Image.ALIGN_TOP);

        document.add(jpg);
        Paragraph p = new Paragraph("Liste des Contrats", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        document.add(new Paragraph("         " +
                ""));
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        fontParagraph.setSize(12);
        Font fontParagraph2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontParagraph2.setSize(12);
        fontParagraph2.setColor(Color.red);
        Paragraph paragraph2 = new Paragraph("Signature", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);

        Font fontParagraph1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontParagraph1.setSize(12);
        List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
        for (Contrat user : contrats) {

            Paragraph paragraph3 = new Paragraph(user.getEtudiant().getNom(), fontParagraph1);
            paragraph3.setAlignment(Paragraph.FOOTNOTE);

            Paragraph paragraph4 = new Paragraph(user.getEtudiant().getPrenom(), fontParagraph1);
            paragraph4.setAlignment(Paragraph.FOOTNOTE);

            Paragraph paragraph5 = new Paragraph(String.valueOf(user.getDateDebutContrat()), fontParagraph1);
            paragraph5.setAlignment(Paragraph.FOOTNOTE);

            Paragraph paragraph6 = new Paragraph(String.valueOf(user.getDateFinContrat()), fontParagraph1);
            paragraph6.setAlignment(Paragraph.FOOTNOTE);

            Paragraph paragraph7 = new Paragraph(String.valueOf(user.getMontantContrat()), fontParagraph1);
            paragraph7.setAlignment(Paragraph.FOOTNOTE);

            Paragraph paragraph8 = new Paragraph(String.valueOf(user.getSpecialite()), fontParagraph1);
            paragraph8.setAlignment(Paragraph.FOOTNOTE);
Paragraph paragraph9 = new Paragraph("-----------------------",fontParagraph1);
paragraph9.setAlignment(Paragraph.FOOTNOTE);


            Paragraph paragraph10 = new Paragraph(String.valueOf(user.getIdContrat()),fontParagraph1);
            paragraph10.setAlignment(Paragraph.FOOTNOTE);
            document.add(new Paragraph("Numero du contrat:",fontParagraph2));
            document.add(paragraph10);
            document.add(new Paragraph("Nom:",fontParagraph2));
            document.add(paragraph3);
            document.add(new Paragraph("Prenom:",fontParagraph2));
            document.add(paragraph4);
            document.add(new Paragraph("DateDebut:",fontParagraph2));
            document.add(paragraph5);
            document.add(new Paragraph("DateFin:",fontParagraph2));
            document.add(paragraph6);
            document.add(new Paragraph("Montant:",fontParagraph2));
            document.add(paragraph7);
            document.add(new Paragraph("Specialite:",fontParagraph2));
            document.add(paragraph8);
            document.add(paragraph9);
        }

        document.add(paragraph2);
        document.close();

    }
}


