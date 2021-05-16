package exercise.daily;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;

public class WordDocumentReader {
	
	public static void readDocument(String filename) throws FileNotFoundException, IOException {
		
		XWPFDocument document = new XWPFDocument(new FileInputStream("./data/Commands.docx"));
		
		List<XWPFHeader> headerList = document.getHeaderList();
		
		String header = headerList.get(0).getText();
		
		String footer = document.getFooterList().get(0).getText();
		
		System.out.println(header);
		
		System.out.println(footer);
		
		document.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		readDocument("file");
	}

}
