package com.cyn.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-06
 */
public class ExcelExportDemo {

    @GetMapping("getExcel")
    public void getExcel(HttpServletRequest request, HttpServletResponse httpResponse) {
        generateDownloadTemplate(httpResponse, request);
    }

    private void generateDownloadTemplate(HttpServletResponse response, HttpServletRequest request) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("test");
        sheet.setColumnWidth(0, 15 * 256);
        sheet.setColumnWidth(1, 15 * 256);
        sheet.setColumnWidth(2, 15 * 256);
        Row row = null;
        XSSFCellStyle style = workbook.createCellStyle();
        // 字体红色
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        style.setFont(font);

        // 合并列
        CellRangeAddress tipRow = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(tipRow);
        row = sheet.createRow(0);
        Cell tipCell = row.createCell(0);
        tipCell.setCellValue("test tip");
        tipCell.setCellStyle(style);
        // 表头
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("name");
        row.createCell(1).setCellValue("tel");
        row.createCell(2).setCellValue("sex");
        try {
            response.setContentType("application/octet-stream;charset=UTF-8");
            //默认Excel名称
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("excelDemo.xlsx", "UTF-8"));
            response.flushBuffer();
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
