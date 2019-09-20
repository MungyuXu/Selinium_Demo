package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 模拟两个用户登录
 */
public class BrowserLogin {
    @Test(dataProvider = "testDate")
   public void  login(String username,String password) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("www.baidu.com");
        //点击登录按钮
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);
        //选择用户名方式登录
        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
        Thread.sleep(2000);
        //清除
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).clear();
        //输入用户名
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys(username);
        driver.findElement(By.id("TANGRAM__PSP_10__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys(password);
        //点击登录按钮登录或者键盘回车登录
//        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        //拖动元素完成验证
        WebElement move=driver.findElement(By.id("vcode-slide-button-p453"));
//        WebElement ele=driver.findElement()
        Actions action=new Actions(driver);
        action.dragAndDropBy(move,10,0).build().perform();
        //发送验证码
        driver.findElement(By.id("TANGRAM__31__button_send_mobile")).click();
    }

    @DataProvider(name="testDate")
    public Object[][] TestDateFeed(){
        //创建一个二维数组
        Object [][] baidudate=new Object[2][2];

        //设置数组元素值，第一个用户名
        baidudate[0][0]="username1";
        //第一个用户密码
        baidudate[0][1]="password1";
        //第二个用户名和密码
        baidudate[1][0]="username2";
        baidudate[1][1]="password2";
        //返回数据传给脚本
        return  baidudate;
    }
}
