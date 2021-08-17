package com.citycloud.dcm.street.module.area.service.impl;

import com.citycloud.dcm.street.mapper.InputCityOperationLogMapper;
import com.citycloud.dcm.street.module.area.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.boot.logging.LoggingSystem.NONE;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    InputCityOperationLogMapper inputCityOperationLogMapper;

    @Override
    public void getExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        print( request, response);
    }


    /**
     * 导出Excel
     * @return
     */
      String print(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //创建工作表
//        Workbook wb = new HSSFWorkbook();
//        //创建工作表
//        creatSheet(wb,"2020-05-20");
//
//        /************下载**************/
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        //将内容写入流
//        wb.write(byteArrayOutputStream);
//        //使用流
//        DownloadUtil downloadUtil = new DownloadUtil();
//
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String end = dateformat.format(System.currentTimeMillis());
//        /**
//         * 第一个：文件流
//         * 第二个：response
//         * 第三个：下载的文件的名字
//         */
//        downloadUtil.download(byteArrayOutputStream, response, end+ ".xls",request);

        return NONE;
    }

//    private  void creatSheet(Workbook wb,String dateValue) {
//        //创建工作表
//        Sheet sheet = wb.createSheet();
//
//        //设置列宽
//        sheet.setColumnWidth(0, 30 * 256);
//        sheet.setColumnWidth(1, 21 * 256);
//        sheet.setColumnWidth(2, 14 * 256);
//        sheet.setColumnWidth(3, 13 * 256);
//        //定义一些公共变量
//        //行对象
//        Row nRow = null;
//        //单元格对象
//        Cell nCell = null;
//
//        //行号和列号
//        int rowNo = 0;
//        int cellNo = 0;
//
//        /************大标题的打印**************/
//        nRow = sheet.createRow(rowNo);
//        nCell = nRow.createCell(cellNo);
//        //横向合并单元格
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
//        //设置内容：
//        //设置内容：
//
//        //行高？样式？
//        nRow.setHeightInPoints(49.55f);
//        nCell.setCellStyle(ExcelUtil.bigTitle(wb));
//        nCell.setCellValue("城市管理运行情况日报表");
//
//        //换行
//        rowNo++;
//        nRow = sheet.createRow(rowNo);
//        //第二行数据
//        int secondCellNos = 0;
//        nCell = nRow.createCell(secondCellNos);
//        nRow.setHeightInPoints(39.65f);
//        nCell.setCellStyle(ExcelUtil.text(wb));
//        nCell.setCellValue("日期");
//
//        nCell = nRow.createCell(++secondCellNos);
//        nCell.setCellStyle(ExcelUtil.text(wb));
//        nCell.setCellValue(dateValue.substring(5, 7) + "月" + dateValue.substring(8, 10) + "日");
//
//        nCell = nRow.createCell(++secondCellNos);
//        nCell.setCellStyle(ExcelUtil.text(wb));
//        nCell.setCellValue("城市运行情况");
//
//        nCell = nRow.createCell(++secondCellNos);
//        nCell.setCellStyle(ExcelUtil.text(wb));
//        nCell.setCellValue("优");
//
//        /************小标题的打印**************/
//        //得先换行
//        rowNo++;
//        //创建行对象
//        nRow = sheet.createRow(rowNo);
//        nRow.setHeightInPoints(39.65f);
//        String[] titles = {"城市运行分项指标", "当日数据", "同比情况", "环比情况"};
//        //遍历标题，进行输出打印
//        for (String title : titles) {
//            nCell = nRow.createCell(cellNo++);
//            nCell.setCellValue(title);
//            nCell.setCellStyle(ExcelUtil.title(wb));
//        }
//        /************内容的打印**************/
//        //准备数据
//        //  List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, null);
//
//        List<InputCityOperationLog> list = inputCityOperationLogMapper.findbyDateValue(dateValue);
//
//
//        LinkedList<InputCityOperationLog> inputCityOperationLogsLinked = new LinkedList<>();
//
//        String[] origin = new String[]{"供水量（单位：万吨）", "管道燃气销量（单位：万立方）", "垃圾清运量（单位：吨）", "污水处理量（单位：万吨）", "“先离场后付费”使用量（单位：笔）", "道路照明亮灯率", "公共自行车租用量（单位：人次）", "热线受理（单位：件）", "纳入三联电子屏（单位：处）", "数字城管运行情况交办件（单位：件）", "数字城管运行情况紧急案卷（单位：件）"};
//
//        for (int i = 0; i < origin.length; i++) {
//            InputCityOperationLog inputCityOperationLog = new InputCityOperationLog();
//            inputCityOperationLog.setName(origin[i]);
//            inputCityOperationLog.setTb("/");
//            inputCityOperationLog.setHb("/");
//            inputCityOperationLogsLinked.add(inputCityOperationLog);
//        }
//        for (int i = 0; i < inputCityOperationLogsLinked.size(); i++)
//        {
//            for (int j = 0; j < list.size(); j++) {
//                if (inputCityOperationLogsLinked.get(i).getName().contains(list.get(j).getName())) {
//                    InputCityOperationLog tempData = inputCityOperationLogsLinked.get(i);
//                    tempData.setName(list.get(j).getName());
//                    tempData.setDateValue(list.get(j).getDateValue());
//                    tempData.setCreateTime(list.get(j).getCreateTime());
//                    tempData.setValue(list.get(j).getValue());
//                    if ("0.00%".equals(list.get(j).getTb()) || "0%".equals(list.get(j).getTb()) || "0.0%".equals(list.get(j).getTb())) {
//                        tempData.setTb("持平");
//                    } else if (list.get(j).getTb().contains("-")) {
//                        tempData.setTb(list.get(j).getTb().replace("-", "↓"));
//                    } else {
//                        tempData.setTb("↑" + list.get(j).getTb());
//                    }
//                    if ("0.00%".equals(list.get(j).getHb()) || "0%".equals(list.get(j).getHb()) || "0.0%".equals(list.get(j).getHb())) {
//                        tempData.setHb("持平");
//                    } else if (list.get(j).getHb().contains("-")) {
//                        tempData.setHb(list.get(j).getHb().replace("-", "↓"));
//                    } else {
//                        tempData.setHb("↑" + list.get(j).getHb());
//                    }
//
//                }
//
//            }
//        }
//        //将数据放入sheet中
//        for (InputCityOperationLog cp : inputCityOperationLogsLinked) {
//            //行变化
//            rowNo++;
//            nRow = sheet.createRow(rowNo);
//            nRow.setHeightInPoints(39.65f);
//            //列
//            cellNo = 0;//规1
//            //"城市运行分项指标",
//            nCell = nRow.createCell(cellNo++);
//            nCell.setCellValue(cp.getName());
//            nCell.setCellStyle(ExcelUtil.text(wb));
//
//            //"当日数据",
//            nCell = nRow.createCell(cellNo++);
//            if (cp.getValue() == null) {
//                nCell.setCellValue("/");
//            } else {
//                nCell.setCellValue(cp.getValue().toString());
//            }
//            nCell.setCellStyle(ExcelUtil.text(wb));
//            //"同比情况",
//            nCell = nRow.createCell(cellNo++);
//            nCell.setCellValue(cp.getTb());
//            nCell.setCellStyle(ExcelUtil.text(wb));
//            //"环比情况",
//            nCell = nRow.createCell(cellNo++);
//            nCell.setCellValue(cp.getHb());
//            nCell.setCellStyle(ExcelUtil.text(wb));
//
//        }
//        /************最后的文字**************/
//        rowNo++;
//        nRow = sheet.createRow(rowNo);
//        nCell = nRow.createCell(0);
//        //行高？样式？
//        nRow.setHeightInPoints(39.65f);
//        nCell.setCellStyle(ExcelUtil.endText(wb));
//        nCell.setCellValue("注：燃气集团停止向公用中心提供管道燃气销量数据。");
//        //横向合并单元格
//        sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 3));
//
//    }
}
