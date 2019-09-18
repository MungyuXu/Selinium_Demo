package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.reflect.misc.FieldUtil;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * 上传图片，模拟键盘操作 ctrl c  ctrl v等
 */
public class UploadImg {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");

        //指定图片路径
        StringSelection ss=new StringSelection("C:\\Users\\Administrator\\Downloads\\timg.jpg");

        //图片路径复制到剪切板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        System.out.println("selection:"+ss);

        //点击相机按钮
        driver.findElement(By.xpath("//*/span[@class='soutu-btn']")).click();

        //点击本地上传图片
        driver.findElement(By.xpath("//*/input[@class='upload-pic']")).click();
        Thread.sleep(2000);
        Robot robot=new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        //释放回车
        robot.keyRelease(KeyEvent.VK_ENTER);

        //按下ctrl v
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //释放 ctrl v
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);

        //点击回车enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

//        driver.quit();
    }
}
