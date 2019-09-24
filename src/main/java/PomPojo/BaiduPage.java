package PomPojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 百度网页 实体类
 */
public class BaiduPage {
    //元素定位//登录链接
    @FindBy(xpath = ".//*[@id='u1']/a[7]")
    WebElement login_link;

    //选择用户名登录方式
//    @FindBy(xpath = ".//*[@id='TANGRAM__PSP_10__footerULoginBtn']")
    @FindBy(id ="TANGRAM__PSP_10__footerULoginBtn" )
    WebElement Ulogin;

    //定位用户名文本框
    @FindBy(id = "TANGRAM__PSP_10__userName")
    WebElement username_link;

    //定位密码文本框
    @FindBy(id = "TANGRAM__PSP_10__password")
    WebElement password_link;

    //登录按钮
    @FindBy(id = "TANGRAM__PSP_10__submit")
    WebElement login_submit;

//业务逻辑和操作方法

    //登录方法

    public void login(String username,String password) throws InterruptedException {

        login_link.click();
        Thread.sleep(1000);
        Ulogin.click();
        username_link.click();
        username_link.sendKeys(username);
        password_link.click();
        password_link.sendKeys(password);
        login_submit.click();


    }


}



