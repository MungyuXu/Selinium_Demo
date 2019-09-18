package TestDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 不同窗口切换
 * 1. driver.getWindowHandle();  返回的是字符串，获取当前窗口的句柄
 * 2. driver.getWindowHandles(); 返回的是 Set<String> ，获取所有窗口
 */
public class ElementOpration {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.jd.com");
        Thread.sleep(1000);

        //for links 新开一个浏览器窗口
        String defaultWindow=driver.getWindowHandle();
        WebElement phoneLink=driver.findElement(By.linkText("手机"));

        //scroll to phoneLink
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView;",phoneLink);

        //open link in a window;click
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(phoneLink).perform();

        Set<String> currentWindows=driver.getWindowHandles();
        System.out.println("当前窗口数量："+currentWindows.size());
        Thread.sleep(5000);

        //*******defaultWindow是打开的手机页面的窗口
        for(String window:currentWindows){
            if (!window.endsWith(defaultWindow)){
                driver=driver.switchTo().window(window);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                //隐式等待
                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
                System.out.println("!!!!!!");
                Thread.sleep(3000);
                break;
            }
        }
        driver.quit();
    }
}
