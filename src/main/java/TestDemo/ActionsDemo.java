package TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 将元素拖到指定处
 */
public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
        Thread.sleep ( 2000 );

        //定位元素
        WebElement move = driver.findElement ( By.id ("draggable") );
        WebElement ele = driver.findElement ( By.id ( "droppable" ) );

        //将定位元素拖动到指定处
        Actions action =new Actions ( driver );
        action.dragAndDrop ( move,ele ).build ().perform ();

        assert (driver.findElement ( By.xpath ( "//*[@id='droppable']/p[text()='Dropped!']") ).isDisplayed ()==true);

        Thread.sleep ( 2000 );
        driver.quit ();
    }
}
