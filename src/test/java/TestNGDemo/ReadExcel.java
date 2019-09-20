package TestNGDemo;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

/**
 * poi读取Excel
 */
public class ReadExcel {
    public static void main(String[] args) throws IOException {
        Workbook workbook= WorkbookFactory.create(new File("C:\\Users\\Administrator\\Desktop\\test.xls"));
        System.out.println("文件中sheets数量为："+workbook.getNumberOfSheets());

        //加载sheet
        @SuppressWarnings("resourse")
        Sheet sh1=workbook.getSheetAt(0);

        for (Row row:sh1){
            int i=0;
            for (Cell cell:row){
                cell.setCellType(CellType.STRING);
                String value=cell.getStringCellValue();
                System.out.println("value:"+value);
                i++;
            }
            System.out.println();
        }
        //获取实际总行数
        System.out.println(sh1.getPhysicalNumberOfRows());
        //获取实际总列数
        System.out.println(sh1.getColumnStyle(0));
    }



//    //创建二维数组存储文件数据
//   @DataProvider(name ="testdata")
//
//    public Object[][] TestDataFeed() throws Exception{
//
//           //文件路径
//         Workbook workbook = WorkbookFactory.create(new File (".\\Files\\test-data.xlsx"));
//         System.out.println("sheets"+workbook.getNumberOfSheets());
//
//          //加载sheet
//        @SuppressWarnings("resource")
//        Sheet sh1 = workbook.getSheetAt(0);
//
//       //设置Cell的类型，就可以把纯数字作为String类型读取
//        for(Row row:sh1) {
//			 int i=0;
//			 for(Cell cell:row) {
//				 cell.setCellType(CellType.STRING);
//				 String value =cell.getStringCellValue();
//				 System.out.println("value:"+ value+"");
//				 i++;
//			 }
//
//			 System.out.println();
//		 }
//
//         //创建二维数组
//        int numberrow =sh1.getPhysicalNumberOfRows();
//        Object[][] baidudata =new Object[numberrow][2];
//
//        for(int i=0;i<numberrow;i++) {
//
//			 baidudata[i][0] =sh1.getRow(i).getCell(0).getStringCellValue();
//			 baidudata[i][1] =sh1.getRow(i).getCell(1).getStringCellValue();
//		 }
//
//          //数据返回给脚本
//		return baidudata;
//
//	 }

}
