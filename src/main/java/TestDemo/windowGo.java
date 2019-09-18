package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 控制浏览器地址的前进后退
 */
public class windowGo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        System.out.println("open:"+driver.getCurrentUrl());
        Thread.sleep(2000);

        //点击新闻链接
        driver.findElement(By.linkText("地图")).click();;
        System.out.println("点击新闻链接");

        //执行浏览器后退
        driver.navigate().back();
        System.out.println("后退到百度首页");
        Thread.sleep(2000);

        //执行浏览器返回
        driver.navigate().forward();
        System.out.println("返回（向右）："+driver.getCurrentUrl());
        Thread.sleep(2000);

        driver.quit();
    }
}
