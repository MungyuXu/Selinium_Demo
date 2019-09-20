package TestNGDemo;
import org.testng.annotations.*;

/**
 *  @Test(enabled = false) 方法被忽略不执行
 *  @DataProvider 为测试方法提供数据
 * @BeforeMethod 在每个测试方法 前 执行   @AfterMethod 在每个测试方法 后 执行
 * @BeforeClass 被注释的方法将在当前类的第一个测试方法调用前运行  @AfterClass
 * @BeforeGroups 被配置的方法将在列表中的gourp前运行。这个方法保证在第一个属于这些组的测试方法调用前立即执行（通过组的形式来运行多个测试方法）
 * （ex：@Test（groups="xxx"））
 * @BeforeTest 被注释的方法将在测试运行前运行  @AfterTest
 * @BeforeSuite 被注释的方法将在所有测试运行前运行(在beforeTest前)   @AfterSuite
 * alwaysRun：对于每个bufore方法(beforeSuite, beforeTest, beforeTestClass 和 beforeTestMethod, 但是不包括 beforeGroups):
 *                 　  如果设置为true，被配置的方法将总是运行而不管它属于哪个组。
 *                 　  对于after方法(afterSuite, afterClass, ...): 如果设置为true，被配置的方法甚至在一个或多个先调用的方法失败或被忽略时也将运行。
 * dependsOnGroups：这个方法依赖的组列表
 * dependsOnMethod：这个方法依赖的方法列表
 * enabled：这个类的方法是否激活
 * groups：这个类或方法所属的分组列表
 * inheritGroups：如果设置为true，这个方法被属于在类级别被@Test annotation指定的组例如：
 */
public class HelloTestNG {

    @BeforeClass
    public void setUp() {
        System.out.println("beforeclass:在当前类第一个测试方法执行之前执行");
        // code that will be invoked when this test is instantiated
    }

    @BeforeSuite
    public  void  beforeSuit(){
        System.out.println("beforeSuit:在所有测试运行前运行（在beforeTest前）");
    }

    @AfterClass
    public  void  afterClass(){
        System.out.println("afterclass：当前类所有方法执行完以后执行");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethos:在每个测试方法执行前执行（每个测试方法执行前都执行一次本方法）");
    }

    @BeforeTest
    public  void  beforeTest(){
        System.out.println("BeforeTest:被注释的方法将在测试运行前运行(在beforeClass之前执行)");
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        int a=0;
        assert (a==1):"断言结果为false，该方法后面的语句不执行";
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

    @Test(timeOut = 1)
    public  void  test1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("1");
    }

}