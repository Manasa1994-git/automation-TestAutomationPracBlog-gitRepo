package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ReadExcelUtil {

    public static void readExcelData(String filePath, String sheetName) {
        try {
            // Load the Excel file
            FileInputStream file = new FileInputStream(filePath);

            // Create a Workbook instance, // detects format and returns correct implementation
            Workbook workbook = WorkbookFactory.create(file);

            // Get the sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            // Get number of rows
            int rowCount = sheet.getPhysicalNumberOfRows();

            // Read each row and cell
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue; //  skip blank row safely

                int colCount = row.getPhysicalNumberOfCells();

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        System.out.print(cell.toString() + "  ");
                    }
                }
                System.out.println();
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // For quick testing
    public static void main(String[] args) {
        String filePath = "/Users/manasa/Documents/ExcelTestData.xlsx";  // Replace with actual path
        String sheetName = "Login";

        readExcelData(filePath, sheetName);
    }
}
