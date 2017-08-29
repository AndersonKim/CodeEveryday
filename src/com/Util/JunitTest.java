package com.Util;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * test and learn the Junit
 * Extends TestCase可以使用setUp和teatDown的复写函数，类似构建函数和析构函数
 * Implement Test
 */
public class JunitTest extends TestCase {

    /**
     * 建立数据库，打开数据连接等等
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * 关闭数据库连接等等
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    /**
     * 单个测试的使用
     */
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
