package com.ihyht.alyxjs.kfzpt.portal.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

public class ExcelUtil {

    //, HttpServletResponse response
    public static void exportExcel(String fileName, List<String> titleName, List<String> dataList, HttpServletResponse response) {


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("dsdsds");

        try {


            OutputStream output = response.getOutputStream();

            response.reset();

            response.setHeader("Content-disposition", "attachment; filename=" + "text.xls");

            response.setContentType("application/octet-stream; charset=utf-8");

            workbook.write(output);

            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
