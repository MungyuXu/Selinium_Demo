package TestDemo;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * 获取cookie
 * 获取当前时间
 */
public class CookieDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");

        driver.manage().deleteAllCookies();
        Cookie c1=new Cookie("name","name2");
        Cookie c2=new Cookie("value","value2");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);

        //获得cookie
        Set<Cookie> coo=driver.manage().getCookies();
        System.out.println("cookie的值是："+coo);
        Thread.sleep(10000);
        //删除所有cookie
//        driver.manage().deleteAllCookies();

        driver.quit();

        //获取当前时间
        DateFormat dateformat = new SimpleDateFormat( "yyyy.MM.dd - HH:mm:ss" );
        Date date =new Date ( );

        String date1=dateformat.format ( date );

        System.out.println (date1);


    }
}
