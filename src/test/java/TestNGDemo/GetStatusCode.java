package TestNGDemo;

import okhttp3.Request;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.logging.Level;

/**
 * 获取请求状态码
 * ！！！有问题，目前取不到frame下的i
 */
public class GetStatusCode {
    @Test
    public void demo1()
    {
        // simple page (without many resources so that the output is
        // easy to understand
        String url = "http://www.w3school.com.cn/tiy/t.asp?f=ajax_httprequest_js_1";
        DownloadPage(url);
    }

    private static  void  DownloadPage(String url){
        ChromeDriver driver=null;
        try {
            ChromeOptions options=new ChromeOptions();
            DesiredCapabilities cap=DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY,options);
            LoggingPreferences logPrefs =new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            cap.setCapability(CapabilityType.LOGGING_PREFS,logPrefs);
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            driver=new ChromeDriver(cap);

            System.out.println("navigate to:"+url);
            driver.navigate().to(url);

            driver.switchTo(). frame("i");
            WebElement element=driver.findElement(By.cssSelector("body > button"));
            element.click();

            String currentURL =driver.getCurrentUrl();
            System.out.println("currentURL:"+currentURL);

            LogEntries logs=driver.manage().logs().get("performance");

            int status=-1;
            System.out.println("\nList of log entries:\n");
            Iterator<LogEntry> iterator=logs.iterator();
            LogEntry lastRequest;
            String megUrl;
            String method=null;

            JSONObject response=null;
            do {
                lastRequest=iterator.next();
                JSONObject json=new JSONObject(lastRequest.getMessage());
                JSONObject message=json.getJSONObject("message");
                method=message.getString("method");
                if (method!=null && "Network.responseReceived".equals(method))
                {
                    JSONObject params=message.getJSONObject("params");
                    response=params.getJSONObject("response");
                }
            }while (iterator.hasNext());

            //最后的请求，适用ajax或post请求
            String messageUrl=response.getString("url");
            status =response.getInt("status");
            System.out.println("return response for --"+messageUrl+":"+status);
            System.out.println("headers:"+response.get("headers"));
            System.out.println("\nstatus code"+status);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (driver !=null){
                driver.quit();
            }
        }
    }


}
