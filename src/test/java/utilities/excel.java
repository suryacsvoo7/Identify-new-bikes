package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class excel {
	
	static String path;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getdata(String s, int r, int c) throws IOException {
		// TODO Auto-generated method stub
		path=System.getProperty("user.dir")+"\\testdata\\zigwheelstestdata.xlsx";
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(s);
		row=sh.getRow(r);
		cell=row.getCell(c);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
			
		}
		catch(Exception e)
		{
		data="";
		}
		return data;
	}
	
	public static void setdata(String[] bikeslist,String[] plist,String[] launchd) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testdata\\writinddata.xlsx";
		FileOutputStream filee=new FileOutputStream(path);
		XSSFWorkbook wbook=new XSSFWorkbook();
		XSSFSheet she=wbook.createSheet("hondabikes");
		//XSSFSheet she2=wbook.createSheet("popularmodels");
		XSSFRow row1=she.createRow(0);
		row1.createCell(0).setCellValue("model name");
		for(int i=0;i<bikeslist.length;i++)
		{
			XSSFRow Rowh=she.createRow(i+1);
			Rowh.createCell(0).setCellValue(bikeslist[i]);
			
		}
		row1.createCell(1).setCellValue("bike prices");
		
		for(int i=0;i<plist.length;i++)
		{
			XSSFRow Rowh=she.getRow(i+1);
			Rowh.createCell(1).setCellValue(plist[i]);
			
		}
		row1.createCell(2).setCellValue("launch dates");
		for(int i=0;i<launchd.length;i++)
		{
			XSSFRow Rowh=she.getRow(i+1);
			Rowh.createCell(2).setCellValue(launchd[i]);
			
		}

		wbook.write(filee);
     	wbook.close();
		filee.close();
		
		
		
	}

	public static void setdata(String[] popularmodels) throws IOException {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir")+"\\testdata\\data.xlsx";
		FileOutputStream filee=new FileOutputStream(path);
		XSSFWorkbook wbook=new XSSFWorkbook();
	   XSSFSheet she=wbook.createSheet("popularmodels");
		//XSSFSheet she2=wbook.createSheet("popularmodels");
		
		
		for(int i=0;i<popularmodels.length;i++)
		{
			she.createRow(i).createCell(0).setCellValue(popularmodels[i]);
		}
	
		wbook.write(filee);
		wbook.close();
		filee.close();		
	}
	

}

