package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtil {

    public static void write2DArrayToExcelUtil(String[][] data, String filePath, String sheetName) {
    	
    	//check why only XSSFWorkbook() not other one HSSF something like that
        Workbook workbook = new XSSFWorkbook(); // Create new workbook
        Sheet sheet = workbook.createSheet(sheetName); // Create new sheet

        // Write data from array to sheet
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            System.out.println("Excel file written successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
