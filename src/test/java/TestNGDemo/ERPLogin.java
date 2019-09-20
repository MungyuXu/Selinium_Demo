package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * erp系统，模拟两个用户登录，无论登录成功与否（用户名密码正确与否），结果都是passed
 * 本测试类未实现获取http请求状态码
 */
public class ERPLogin {
    @Test(dataProvider = "testDate")
   public void  login(String username,String password) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://ms.hcgtravels.com/");
        //清除
        driver.findElement(By.id("uid")).clear();
        //输入用户名
        driver.findElement(By.id("uid")).sendKeys(username);
        //清除、输入密码
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(password);
        //点击登录按钮登录或者键盘回车登录
//        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

    }

    @DataProvider(name="testDate")
    public Object[][] TestDateFeed(){
        //创建一个二维数组
        Object [][] baidudate=new Object[2][2];

        //设置数组元素值，第一个用户名
        baidudate[0][0]="xumengyu";
        //第一个用户密码
        baidudate[0][1]="12345678";
        //第二个用户名和密码
        baidudate[1][0]="username2";
        baidudate[1][1]="password2";
        //返回数据传给脚本
        return  baidudate;
    }
}
