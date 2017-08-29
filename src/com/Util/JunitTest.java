package com.Util;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * test and learn the Junit
 * Extends TestCase可以使用setUp和teatDown的复写函数，类似构建函数和析构函数
 * 提供了两种选择来实现测试的需求
 * 1: 使用继承的方式去继承TestCase
 * 2：使用注解的方式实现方法的粒度级别的测试（推荐）
 */
public class JunitTest {

    @BeforeClass
    public static void beforeAllTest() {
        System.out.println("before all test");
    }

    @AfterClass
    public static void afterAllTest() {
        System.out.println("after all test");
    }

    /**
     * 建立数据库，打开数据连接等等
     *
     * @throws Exception
     * @BeforeClass: 方法必须必须要是静态方法（static 声明），所有测试开始之前运行，注意区分before，是所有测试方法
     * 类似的@Before: 每一个测试方法之前运行
     */
    // @Override
    protected void setUp() throws Exception {
        System.out.println("before Class");
        //super.setUp();
    }

    /**
     * 关闭数据库连接等等
     *
     * @throws Exception
     * @AfterClass: 方法必须要是静态方法（static 声明），所有测试结束之后运行，注意区分 @After
     * 类似的@After: 每一个测试方法之后运行
     */
    //@Override
    protected void tearDown() throws Exception {
        System.out.println("after Class");
        //super.tearDown();
    }

    @Before
    public void beforeEachTest() {
        System.out.println("before test");
    }

    @After
    public void afterEachTest() {
        System.out.println("after test");
    }

    /**
     * 单个测试的使用
     */
    @Test
    public void testAdd() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int[] testCaseA = {0, 999999};
        int[] testCaseB = {0, 999999};
        int[] testResult = {0, 1999998};
        for (int i = 0; i < testCaseA.length; i++) {
            int testCase = simpleCalculator.add(testCaseA[i], testCaseB[i]);
            assertThat(testCase, is(testResult[i]));
        }

    }

}

/**
 * wait to be tested class
 */
class SimpleCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtration(int a, int b) {
        return a - b;
    }
}
