package TestDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

/**
 * 判断网页title是否与设定title一致，
 * 使用断言，若断言值为false，则不执行后面的语句
 * 需要设置VM options为 -ea
 */
public class baiduDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        System.out.println("获取浏览器打开页面的url为："+driver.getCurrentUrl());
        System.out.println("获取当前页面标题为："+driver.getTitle());

        //判断网页是否是“百度一下，你就知道”
        try {
//            String url="百度一下,你就知道";
            String url="测试";
            //断言为false时就不执行后面的语句了，要配置VM options为-ea
            assert url.equals(driver.getTitle()):"no";
//          assert(url.equals(driver.getTitle()));
            Boolean a=url.equals(driver.getTitle());
            System.out.println("a的值为:"+a);
            System.out.println("yes");
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
