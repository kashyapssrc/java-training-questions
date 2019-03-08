/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ofs.training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author vinothkumarc
 * @since  Aug 30, 2018
 */
@Test
public class MathTest {

    // test methods
    // non-test methods

    Math math;

    @BeforeClass
    private void initClass() {
        math = new Math();
    }

    @Test(dataProvider = "testDivide_positiveDP")
    private void testDivide_positive1(int dividend, int divisor, int expectedResult) {
        try {
            int actualResult = math.divide(dividend, divisor);
            Assert.assertEquals(actualResult, expectedResult, "Given input " + dividend + ", " + divisor);
        } catch (Exception e) {
            Assert.fail("Unexpected exception for input "
                        + dividend
                        + ", "
                        + divisor
                        + ". Expected result is "
                        + expectedResult
                        + ".",
                        e);
        }
    }

    @DataProvider
    private Object[][] testDivide_positiveDP() {
        return new Object[][] {
                                { 10, 2, 5 },
                                { 20, 2, 10 },
                                { 50, 2, 25 },
                                { 100, 50, 2 }
        };
    }

//    @Test
    private void testDivide_negative() {
        try {
            math.divide(50, 0);
            Assert.fail("Expected an exception.");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Can not divide by zero");
        }
    }

    @AfterClass
    private void afterClass() {

    }
}
