////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The methods perform an assertion, if the assertion fails, it writes a custom error message to the error text   //
// file and fails the test.                                                                                                          //
//                                                                                                                //
// assertStringsMatch - receives 2 string parameters, checks to see if they match and writes to the error file    //
// if they don't match.                                                                                           //
//                                                                                                                //
// assertBooleanType - receives 2 boolean parameters, checks to see if they match and writes to the error file    //
// if they don't match.                                                                                           //
//                                                                                                                //
// assertFieldValueContainsSubString - receives 2 string parameters, checks to see if the substring is contained  //
// in the string and writes to the error file if the substring isn't in the string                                //
//                                                                                                                //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package Validations;

import CustomUtils.ErrorLog;
import org.testng.Assert;

public class APIValidations {

    private ErrorLog myErrorLog = new ErrorLog();

    public void assertStringsMatch(String expectedString, String actualString) {

        // Check that the 2 strings match
        if (!expectedString.equals(actualString)){
            myErrorLog.captureErrorDetails(String.format("Strings don't match. Expected was %s. Actual was %s.",
                    expectedString, actualString));
            Assert.fail();
        }
    }

    public void assertBooleanType(boolean expectedResponse, boolean actualResponse){

        // Fail the test and write to the error log if the responses don't match
        if (expectedResponse != actualResponse){
            myErrorLog.captureErrorDetails(String.format("Responses don't match. Expected was %s. Actual was %s.",
                    expectedResponse, actualResponse));
            Assert.fail();
        }
    }

    public void assertFieldValueContainsSubString(String fieldValue, String subString) {

        // Fail the test and write to the error log if the field value doesn't contain the substring
        if (!fieldValue.contains(subString)){
            myErrorLog.captureErrorDetails(String.format("The description did not contain %s.", subString));
            Assert.fail();
        }
    }
}
