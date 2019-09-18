package TestDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 接收弹窗并打印弹窗内显示的内容
 */
public class AlertDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //网址路径

        driver.get("file:///C:/Users/quelingfei/Desktop/test.html");
        Thread.sleep ( 2000 );

        // 接受弹窗 打印弹窗内容

        driver.switchTo ().alert ().accept ();
        System.out.println(driver.switchTo ().alert ().getText ());
        //关闭浏览器
        driver.quit ();

    }
}
