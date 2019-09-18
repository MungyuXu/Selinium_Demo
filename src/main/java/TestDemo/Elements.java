package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * 获取所有关于关键字元素并打印元素的个数 or 循环打印搜索结果的标题
 */
public class Elements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");

        WebElement text=driver.findElement(By.id("kw"));
        text.sendKeys("测试");
        text.submit();
        Thread.sleep(2000);

        //匹配第一页搜索结果的标题，循环打印
        List<WebElement> result=driver.findElements(By.xpath("//div/div/h3"));

        //打印元素的个数
        System.out.println(result.size());

        //循环打印搜索结果的标题
        for (WebElement re:result){
            System.out.println(re.getText());
        }

        System.out.println("-------------------");

        //打印第n结果的标题
        WebElement nText=result.get(result.size()-10);
        System.out.println(nText.getText());

//        driver.quit();
    }
}
