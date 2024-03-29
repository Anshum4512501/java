package com.xtremesoftech.eims.lessonplanning.pdfgeneration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.xtremesoftech.eims.lessonplanning.model.LessonPlan;;
public class PdfGeneration {
	private static String FILE = "/home/anshoo/ThirdPdf.pdf";
	
   public  void generatePdf() {
	   LessonPlan lplan = new LessonPlan();
	   try {
           Document document = new Document();
           PdfWriter.getInstance(document, new FileOutputStream(FILE));
           document.open();
           addMetaData(document);
           addTitlePage(document);
           addContent(document,lplan);
           document.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   private  void addTitlePage(Document document)
           throws DocumentException {
       Paragraph preface = new Paragraph();
       // We add one empty line
       addEmptyLine(preface, 1);
       // Lets write a big header
       preface.add(new Paragraph("Teacher Student Lesson Plan"));

       addEmptyLine(preface, 1);
       // Will create: Report generated by: _name, _date
       preface.add(new Paragraph(
               "Report generated by: " + System.getProperty("user.name") + ", " + new Date() ));
       addEmptyLine(preface, 1);
       preface.add(new Paragraph(
               " "
               ));

       addEmptyLine(preface, 1);

       document.add(preface);
       // Start a new page
//       document.newPage();
   }
private void addMetaData(Document document) {
	// TODO Auto-generated method stub
	
}
private  void addContent(Document document ,LessonPlan lplan) throws IOException, DocumentException {
	// TODO Auto-generated method stub
	  createPdf(document,lplan);
	
}
public   void createPdf(Document document,LessonPlan lplan) throws IOException, DocumentException {
	  
	    // I see 3 columns in your example
	    PdfPTable table = new PdfPTable(6);
	    // The first column appears to have double the width of the other columns
	    table.setWidths(new int[]{ 1,1,1,1, 1, 1});
	    // the first row consists of 1 cell that spans the 3 columns
	    PdfPCell c1 = new PdfPCell(new Phrase("Teacher"));
	    c1.setColspan(3);
	    table.addCell(c1);
	    PdfPCell c2 = new PdfPCell(new Phrase(lplan.getLessonInfo().getTeacher()));
	    c2.setColspan(3);
	    table.addCell(c2);
	    
	    // Then follows a row with normal cells
	    PdfPCell c3 = new PdfPCell(new Phrase("Term"));
	    c3.setColspan(1);
	    table.addCell(c3);
	    PdfPCell c4 = new PdfPCell(new Phrase(lplan.getLessonInfo().getTerm()));
	    c4.setColspan(1);
	    table.addCell(c4);
	    PdfPCell c5 = new PdfPCell(new Phrase("From"));
	    c5.setColspan(1);
	    table.addCell(c5);
	    PdfPCell c6 = new PdfPCell(new Phrase(lplan.getLessonInfo().getDurationFrom()));
	    c6.setColspan(1);
	    table.addCell(c6);
	    PdfPCell c7 = new PdfPCell(new Phrase("To"));
	    c7.setColspan(1);
	    table.addCell(c7);
	    PdfPCell c8 = new PdfPCell(new Phrase(lplan.getLessonInfo().getDurationTo()));
	    c8.setColspan(1);
	    table.addCell(c8);
	    // Again we have a row with 1 cell that spans 3 columns
	    PdfPCell c9 = new PdfPCell(new Phrase("Class"));
	    c9.setColspan(1);
	    table.addCell(c9);
	    PdfPCell c10 = new PdfPCell(new Phrase(lplan.getLessonInfo().getClassName()));
	    c10.setColspan(2);
	    table.addCell(c10);
	    PdfPCell c11 = new PdfPCell(new Phrase("Subject"));
	    c11.setColspan(1);
	    table.addCell(c11);
	    PdfPCell c12 = new PdfPCell(new Phrase(lplan.getLessonInfo().getSubject()));
	    c12.setColspan(2);
	    table.addCell(c12);
	    
	    
	    // Now we have a row with 1 normal cell and 1 that spans 2 columns
	   
	    PdfPCell c13 = new PdfPCell(new Phrase("Topic"));
	    c13.setColspan(2);
	    table.addCell(c13);

	    PdfPCell c14 = new PdfPCell(new Phrase(lplan.getLessonInfo().getTopic()));
	    c14.setColspan(4);
	    table.addCell(c14);
	    
	    
	    PdfPCell c15 = new PdfPCell(new Phrase("Key Vocab"));
	    c15.setColspan(2);
	    table.addCell(c15);

	    PdfPCell c16 = new PdfPCell(new Phrase(lplan.getLessonInfo().getKeyVocabulary()));
	    c16.setColspan(4);
	    table.addCell(c16);
	    
	    
	    PdfPCell c17 = new PdfPCell(new Phrase("Resources"));
	    c17.setColspan(2);
	    table.addCell(c17);

	    PdfPCell c18 = new PdfPCell(new Phrase(lplan.getLessonInfo().getResources()));
	    c18.setColspan(4);
	    table.addCell(c18);
	    
	    // now we can add the table
	    document.add(table);
	    document.close();
	    System.out.println("Pdf Generated");
	}
private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}
}
