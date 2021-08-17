package com.citycloud.dcm.street.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Slf4j
public class CheckCardExportExcelUtil {

    /**
     * 合并相同内容单元格导出
     *
     * @param headers      标题集合 tilte的长度应该与list中的model的属性个数一致
     * @param dataset      内容集合
     * @param mergeColumns 合并单元格的列
     */
    public static void toExcelMergeCell(String[] headers, List<Map<String, String>> dataset, String[] mergeColumns, HttpServletRequest request, HttpServletResponse response) {
        if (headers.length == 0) {
            return;
        }
        //初始化excel模板
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        try {
            sheet = workbook.createSheet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化head，填值标题行（第一行）
        Row row0 = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            //创建单元格，指定类型
            Cell cell_1 = row0.createCell(i, Cell.CELL_TYPE_STRING);
            cell_1.setCellValue(headers[i]);
        }

        List<PoiModel> poiModels = new ArrayList<PoiModel>();
        Iterator<Map<String, String>> iterator = dataset.iterator();
        //这里1是从excel的第二行开始，第一行已经塞入标题了
        int index = 1;
        while (iterator.hasNext()) {
            Row row = sheet.createRow(index);
            // 取得当前这行的map，该map中以key，value的形式存着这一行值
            Map<String, String> map = iterator.next();
            // 循环列数，给当前行塞值
            for (int i = 0; i < headers.length; i++) {
                String old = "";
                // old存的是上一行统一位置的单元的值，第一行是最上一行了，所以从第二行开始记
                if (index > 1) {
                    old = poiModels.get(i) == null ? "" : poiModels.get(i).getContent();
                }

                String value = map.get(headers[i]);
                CellRangeAddress cra = null;
                // 循环需要合并的列
                for (String mergeColumn : mergeColumns) {
                    PoiModel poiModel = null;
                    if (index == 1) {
                        poiModel = new PoiModel();
                        poiModel.setOldContent(value);
                        poiModel.setContent(value);
                        poiModel.setRowIndex(1);
                        poiModel.setCellIndex(i);
                        poiModels.add(poiModel);
                        old = value;
                        break;
                    }
                    poiModel = poiModels.get(i);
                    int rowStartIndex = poiModel.getRowIndex();
                    int rowEndIndex = index - 1;
                    int cellIndex = poiModel.getCellIndex();
                    String content = poiModel.getContent();
                    String preOldContent = poiModels.get(0).getOldContent();
                    String preValue = map.get(headers[0]);
                    boolean isHeaderEquals = mergeColumn.equals(headers[i]);

                    if (i == 0 && isHeaderEquals && !content.equals(value)) {
                        if (rowStartIndex != rowEndIndex) {
                            cra = new CellRangeAddress(rowStartIndex, rowEndIndex, cellIndex, cellIndex);
                            sheet.addMergedRegion(cra);
                        }
                        // 重新记录该列的内容为当前内容，行标记改为当前行标记
                        poiModel.setContent(value);
                        poiModel.setRowIndex(index);
                        poiModel.setCellIndex(i);
                    } else if (i > 0 && isHeaderEquals) {
                        if (!content.equals(value) || (content.equals(value) && !preOldContent.equals(preValue))) {
                            if (rowStartIndex != rowEndIndex) {
                                cra = new CellRangeAddress(rowStartIndex, rowEndIndex, cellIndex, cellIndex);
                                sheet.addMergedRegion(cra);
                            }
                            poiModels.get(i).setContent(value);
                            poiModels.get(i).setRowIndex(index);
                            poiModels.get(i).setCellIndex(i);
                        }
                    }
                    if (isHeaderEquals && index == dataset.size()) {
                        if (i == 0) {
                            if (content.equals(value)) {
                                cra = new CellRangeAddress(rowStartIndex, index, cellIndex, cellIndex);
                                sheet.addMergedRegion(cra);
                            }
                        } else if (i > 0) {
                            if (content.equals(value) && preOldContent.equals(preValue)) {
                                cra = new CellRangeAddress(rowStartIndex, index, cellIndex, cellIndex);
                                sheet.addMergedRegion(cra);
                            }
                        }
                    }
                }
                Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                cell.setCellValue(value);
                // 在每一个单元格处理完成后，把这个单元格内容设置为old内容
                poiModels.get(i).setOldContent(old);
            }
            index++;
        }

        /************下载**************/
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //将内容写入流
        try {
            workbook.write(byteArrayOutputStream);
            //使用流
            DownloadUtil downloadUtil = new DownloadUtil();
            downloadUtil.download(byteArrayOutputStream, response, DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN) + ".xlsx", request);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Excel导出流异常:", e);
        }

    }

    /**
     * 导出excel,使用流返回.
     *
     * @param response
     * @param data
     */
    public static void excelExport(HttpServletResponse response, List<?> data) {
        try (ExcelWriter writer = ExcelUtil.getWriter(true)) {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN) + ".xlsx");
            //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("测试", "UTF-8") + ".xlsx");
            writer.write(data, true);
            writer.flush(response.getOutputStream());
        } catch (IOException e) {
            log.error("Excel导出流异常:", e);
        }
    }

    /**
     * 读取excel表格内容返回List<Map>
     *
     * @param inputStream excel文件流
     * @param head        表头数组
     * @param headerAlias 表头别名数组
     * @return
     */
    public static List<Map<String, Object>> importExcel(InputStream inputStream, String[] head, String[] headerAlias) {
        ExcelReader reader = getExcelReader(inputStream, head, headerAlias);
        if (reader == null) {
            return null;
        }
        //读取指点行开始的表数据（以下介绍的三个参数也可以使用动态传入，根据个人业务情况修改）
        //1：表头所在行数  2：数据开始读取位置   Integer.MAX_VALUE:数据读取结束行位置
        List<Map<String, Object>> read = reader.read(1, 2, Integer.MAX_VALUE);
        return read;
    }

    /**
     * 读取excel表格内容返回List<Bean>
     *
     * @param inputStream excel文件流
     * @param head        表头数组
     * @param headerAlias 表头别名数组
     * @return
     */
    public static <T> List<T> importExcel(InputStream inputStream, String[] head, String[] headerAlias, Class<T> bean) {
        ExcelReader reader = getExcelReader(inputStream, head, headerAlias);
        if (reader == null) {
            return null;
        }
        //读取指点行开始的表数据（从0开始）
        List<T> read = reader.read(1, 2, bean);
        return read;
    }

    /**
     * 读取excel表格内容
     *
     * @param inputStream excel文件流
     * @param head        表头数组
     * @param headerAlias 表头别名数组
     * @return
     */
    private static ExcelReader getExcelReader(InputStream inputStream, String[] head, String[] headerAlias) {
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Object> header = reader.readRow(1);
        //替换表头关键字
        if (ArrayUtils.isEmpty(head) || ArrayUtils.isEmpty(headerAlias) || head.length != headerAlias.length) {
            return null;
        } else {
            for (int i = 0; i < head.length; i++) {
                if (head[i].equals(header.get(i))) {
                    reader.addHeaderAlias(head[i], headerAlias[i]);
                } else {
                    return null;
                }

            }
        }
        return reader;
    }

}