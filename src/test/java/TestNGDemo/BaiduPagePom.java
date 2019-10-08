package TestNGDemo;

import PomPojo.BaiduPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * pom模式  百度网页实体类BaiduPage在PomPOJO包中
 */
public class BaiduPagePom {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
    }

    @Test
    public  void  testLogin() throws InterruptedException {
        BaiduPage bd= PageFactory.initElements(driver,BaiduPage.class);
        bd.login("username","password");
    }
}
