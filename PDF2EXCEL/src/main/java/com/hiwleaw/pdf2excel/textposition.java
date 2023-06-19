/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiwleaw.pdf2excel;

/**
 *
 * @author notebook
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
  
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
  
/**
* This is an example on how to get the x/y coordinates and size of each character in PDF
*/
public class textposition extends PDFTextStripper {
  
    public textposition() throws IOException {
    }
  
    /**
     * @throws IOException If there is an error parsing the document.
     */
    public static void main( String[] args ) throws IOException {
        PDDocument document = null;
        String fileName = "C:\\Users\\k566u\\Desktop\\PDF-Table-to-Excel-Python\\test.pdf";
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new textposition();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
  
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
    }
  
    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        for (TextPosition text : textPositions) {
            System.out.println(text.getUnicode()+ " [(X=" + text.getXDirAdj() + ",Y=" +
                    text.getYDirAdj() + ") height=" + text.getHeightDir() + " width=" +
                    text.getWidthDirAdj() + "]");
        }
    }
}
