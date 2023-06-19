/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiwleaw.pdf2excel;

/**
 *
 * @author notebook
 */
import io.github.jonathanlink.PDFLayoutTextStripper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Temp {
	public static void main(String[] args) {
		String string = null;
        try {
            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("C:\\Users\\k566u\\Desktop\\PDF-Table-to-Excel-Python\\test2.pdf"), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
        System.out.println(string);
	}
}