package TestNGDemo;
import org.testng.annotations.*;

public class HelloTestNG {

    @BeforeClass
    public void setUp() {
        System.out.println("beforeclass:在当前类第一个测试方法执行之前执行");
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        int a=0;
        assert (a==1):"断言结果为false";
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

    //方法被忽略不执行
//    @Test(enabled = false)
}