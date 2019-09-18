package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 字符串截取
 */
public class StringOpration {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");

        //sendKeys键盘输入‘selenium’ 点击百度一下按钮
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        //定位约。。。个元素
        WebElement res=driver.findElement(By.className("nums"));
        String res_string=res.getText();

        //截取
        String st1=res_string.split("约")[1];
        String search_number=st1.split("个")[0];
        System.out.println(search_number);

//        driver.quit();
    }
}
