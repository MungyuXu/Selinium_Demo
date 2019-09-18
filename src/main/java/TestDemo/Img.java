package TestDemo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;

/**
 * 截图
 */
public class Img {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");

        //getScreenshotAs方法截图
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);



//        try {
////            //截图后存放地址????    FileUtils  找不到
////            FileUtils.copyFile(srcFile,new File("D:\\stest.jpg"));
////        }catch (IOException e){
////            e.printStackTrace();
////        }


        driver.quit();
    }
}
