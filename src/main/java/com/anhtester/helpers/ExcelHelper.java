package com.anhtester.helpers;

import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.*;

import java.awt.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;



    public class ExcelHelper {

        private FileInputStream fis;
        private FileOutputStream fileOut;
        private Workbook wb;
        private Sheet sh;
        private Table.Cell cell;
        private Row row;
        private CellStyle cellstyle;
        private Color mycolor;
        private String excelFilePath;
        private Map<String, Integer> columns = new HashMap<>();

        public void setExcelFile(String ExcelPath, String SheetName){
            try {
                File f = new File(ExcelPath);

                if (!f.exists()) {
                    System.out.println("File doesn't exist.");
                }

                fis = new FileInputStream(ExcelPath);
                wb = WorkbookFactory.create(fis);
                sh = wb.getSheet(SheetName);

                if (sh == null) {
                    throw new Exception("Sheet name doesn't exist.");
                }

                this.excelFilePath = ExcelPath;

                //adding all the column header names to the map 'columns'
                sh.getRow(0).forEach(cell ->{
                    columns.put(cell.getStringCellValue(), cell.getColumnIndex());
                });

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

