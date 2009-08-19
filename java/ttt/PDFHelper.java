// TeleTeachingTool - Presentation Recording With Automated Indexing
//
// Copyright (C) 2003-2008 Peter Ziewer - Technische Universit�t M�nchen
// 
//    This file is part of TeleTeachingTool.
//
//    TeleTeachingTool is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    TeleTeachingTool is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with TeleTeachingTool.  If not, see <http://www.gnu.org/licenses/>.

/*
 * Created on 08.02.2007
 *
 * Author: Peter Ziewer, TU Munich, Germany - ziewer@in.tum.de
 */
package ttt;

import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

// Helper class generate PDF script by use of iText
//
// iText is a Free Java-PDF library by Bruno Lowagieand Paulo Soares
// http://www.lowagie.com/iText/
// published under the MPL and LGPL license


public class PDFHelper {
    Recording recording;
    String filename;
    Document pdfDocument;
    PdfWriter pdfWriter;
    Table table;

    public PDFHelper(Recording recording) throws IOException {
        this.recording = recording;
        // initialize PDF
        try {
            // step 1: creation of a document-object
            pdfDocument = new Document();
            // turn to landscape
            if (pdfDocument.getPageSize().height() > pdfDocument.getPageSize().width())
                pdfDocument.setPageSize(new com.lowagie.text.Rectangle(pdfDocument.getPageSize().height(), pdfDocument
                        .getPageSize().width()));
            pdfDocument.setMargins(10, 10, 10, 10);

            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            filename = recording.getDirectory() + recording.getFileBase() + ".pdf";
            pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream(filename));
            pdfWriter.setStrictImageSequence(true);

            // step 3: we open the document
            pdfDocument.open();

        } catch (DocumentException e) {
            // TODO: throw exception instead?
            e.printStackTrace();
            pdfDocument = null;
            pdfWriter = null;
            throw new IOException(e.toString());
        }
    }

    public void writeNextIndex(int i, Image screenshot) throws IOException {
        // write screenshot to pdf
        // step 4: we add content
        try {
            if (i == 0) {
                // new table
                table = new Table(2);
                table.setWidth(92);
                table.setBorder(0);
                table.setSpacing(5);
                table.setPadding(0);
                table.setCellsFitPage(true);

                // add header
                Table headerTable = new Table(2);
                float[] widths = { 0.2f, 0.8f };
                headerTable.setWidths(widths);
                // headerTable.setWidth(90f);
                Phrase phrase1 = new Phrase("\nScript ");
                phrase1.font().setStyle(Font.BOLD);
                Phrase phrase2 = new Phrase("   generated by TTT\n ");
                phrase1.font().setStyle(Font.NORMAL);
                phrase2.font().setSize(8);
                phrase1.add(phrase2);
                Cell cell = new Cell(phrase1);
                cell.setColspan(2);
                cell.setBorder(0);
                headerTable.addCell(cell);
                String[] cellTexts = { " ", " ", "Title:", recording.prefs.name, "Date:",
                        new Date(recording.prefs.starttime).toString(), "Duration:",
                        Constants.getStringFromTime(recording.getDuration(), false) + " min", "Pages:",
                        "" + recording.index.size() };
                for (String string : cellTexts) {
                    cell = new Cell(string);
                    cell.setBorder(0);
                    headerTable.addCell(cell);
                }
                cell = new Cell(headerTable);
                cell.setBorder(0);
                table.addCell(cell);
            }

            com.lowagie.text.Image image = com.lowagie.text.Image.getInstance(screenshot, null);
            Cell cell = new Cell(image);
            cell.setBorder(0);            
            table.addCell(cell);

            // write table
            if (i + 1 == recording.index.size())
                pdfDocument.add(table);

            // TODO: set thumbnail
            // pdfWriter.setThumbnail()

        } catch (BadElementException e) {
            e.printStackTrace();
            throw new IOException(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new IOException(e.toString());
        }
    }

    public void close() {
        // step 5: we close the document
        pdfDocument.close();
    }
}
