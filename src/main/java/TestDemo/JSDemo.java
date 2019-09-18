package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 滚动条常见拖动操作
 */
public class JSDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blog.csdn.net/qq_36969649/article/details/84106107");
        Thread.sleep(2000);

        WebElement wm =driver.findElement ( By.tagName("p") );

        //移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",wm );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",wm );
        Thread.sleep ( 2000 );
        //移动到元素element对象的“底端”与当前窗口的“底部”对齐
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", wm);
        Thread.sleep ( 2000 );
        //将页面滚动条拖到底部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);

        driver.quit();


    }
}
