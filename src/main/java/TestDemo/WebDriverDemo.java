package TestDemo;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

/**
 * 打开浏览器进入网址，设置浏览器宽高
 */
public class WebDriverDemo {
    public static void main(String[] args) throws InterruptedException {

        Logger logger=Logger.getLogger("baidu");
//        PropertyConfigurator.configure(".\\Log4j.properties");


        //指定浏览器驱动路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
       //初始化浏览器命名为driver
        WebDriver driver=new ChromeDriver();
        //窗口最大化
        driver.manage().window().maximize();
        //使用get方法打开百度
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        //设置浏览器宽高
        driver.manage().window().setSize(new Dimension(480,800));
        //关闭浏览器
        driver.quit();
        logger.info("退出浏览器");
    }
}
