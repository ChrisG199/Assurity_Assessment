////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The test performs 3 validations:                                                                               //
// 1. Checks if the name in the JSON response is Carbon credits                                                   //
// 2. Checks if the value for CanRelist is true                                                                   //
// 3. Checks if the description of the object with Name = "Gallery" contains "2x larger image" as part of the     //
// description.                                                                                                   //
//                                                                                                                //
// If any of the tests fail, a custom error will be written to a text file, stored under the Error_Logs folder.   //
// An report called "Assessment_Extent.html" will be created under the test_output folder after each run          //
//                                                                                                                //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import Config.GlobalVariables;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import APIFunctions.APIFunctions;
import Validations.APIValidations;

import java.lang.reflect.Method;

public class AssessmentTests {

    private APIFunctions myAPI = new APIFunctions();
    private APIValidations myValidate = new APIValidations();

    @BeforeMethod
    public void getMethodName(Method method) {

        // Get the name of the test being run
        GlobalVariables.currentTestName = method.getName();
    }

    @Test (priority = 0, testName = "Assessment Test")
    public void testAssessment() {

        // Read in the JSON body
        Response response = myAPI.getJSONResponse(GlobalVariables.url);

        // Read in the name from the JSON response
        String actualName = myAPI.getStringFieldValue("Name", response);

        // Compare the name received to the name expected
        myValidate.assertStringsMatch("Carbon credits", actualName);

        // Read in the name from the JSON response
        boolean actualResponse = myAPI.getBooleanValue("CanRelist", response);

        // Compare the name received to the name expected
        myValidate.assertBooleanType(true, actualResponse);

        // Read in the name from the JSON response
        String description = myAPI.getDescriptionByName("Gallery", response);

        // Compare the name received to the name expected
        myValidate.assertFieldValueContainsSubString(description, "2x larger image");
    }
}
