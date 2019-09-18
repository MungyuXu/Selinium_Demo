package TestDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 页面元素定位。
 * sendKeys给文本框输入内容
 */
public class GetElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://baidu.com");

        //id定位
//        WebElement wid=driver.findElement(By.id("kw"));

        //实测定位到百度右上角链接文字  精确查询
//        WebElement wid=driver.findElement(By.linkText("学术"));
        //模糊匹配
//        WebElement wid =driver.findElement(By.partialLinkText("新"));

        //name定位
        WebElement wid=driver.findElement(By.name("wd"));
        //classname定位
//        WebElement wid =driver.findElement(By.className("s_ipt"));

        //tagname定位??
//        WebElement wid=driver.findElement(By.tagName("input"));


        //定位到文本，将文本高亮显示
        //创建一个JavaScriptExecutor对象
        JavascriptExecutor js= (JavascriptExecutor) driver;

        //新闻文本高亮显示颜色
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);",wid,"background: orange; border: 2px solid red;");

        Thread.sleep(2000);

//        wid.sendKeys("test!!!");
        Thread.sleep(6000);
         driver.quit();
    }
}

    //xpath定位
        /*id:
        driver.findElement(By.xpath("//*[@id='kw']"))
        name:
        driver.findElement(By.xpath("//*[@name='wd']"))
        className:
        driver.findElement(By.xpath("//input[@class='s_ipt']"))
        css:
        driver.findElement(By.xpath("/html/body/form/span/input"))
        form：
        driver.findElement(By.xpath("//form[@id='form']/span/input"))
        id和name定位：
        driver.findElement(By.xpath("//input[@id='kw' and @name='wd']"))*/

        //css定位
        /*id css:
        driver.findElement(By.cssSelector("#kw")
        name css :
        driver.findElement(By.cssSelector("[name=wd]")
        className css :
        driver.findElement(By.cssSelector(".s_ipt")
        span css:
        driver.findElement(By.cssSelector("span.soutu-btn> input#kw")
        form css:
        driver.findElement(By.cssSelector("form#form > span > input")*/
