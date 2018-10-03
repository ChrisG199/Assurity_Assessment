
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  The class contains 4 methods for parsing data from the JSON response.                                     //
//                                                                                                            //
//  getJSONResponse - private method which will read in a URL and return a JSON body response                 //
//                                                                                                            //
//  getStringFieldValue  -  public method which receives a string field to search the response for and will   //
//                          return a string value                                                             //
//                                                                                                            //
//  getBooleanValue -  public method which receives a string field to search the response for and will return //
//                     a boolean value                                                                        //
//                                                                                                            //
//  getDescriptionByName - public method which reads in a list of promotions from the response. It then looks //
//                         for the specified name and returns the description.                                //
//                                                                                                            //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package APIFunctions;

import Config.GlobalVariables;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.*;

public class APIFunctions {

    private Response getJSONResponse (String url) {

        // Return the JSON response
        return given().
                when().
                get(url).
                then().
                contentType(ContentType.JSON).
                extract().
                response();
    }

    public String getStringFieldValue(String field) {

        Response response = getJSONResponse(GlobalVariables.url);

        // Return the string value of the field from the JSON response
        return response.body().path(field);

    }

    public Boolean getBooleanValue(String fieldName) {

        Response response = getJSONResponse(GlobalVariables.url);

        // Return the boolean value of the field
        return response.body().path(fieldName);
    }

    public String getDescriptionByName(String nameValue) {

        Response response = getJSONResponse(GlobalVariables.url);
        String description = "";

        // Read in the list of promotions
        List<Map<String, String>> promotions = response.jsonPath().getList("Promotions");

        // Find the description based on the name looked up
        for (int i = 0; i < promotions.size(); i++) {
            String name = promotions.get(i).get("Name");
            if (name.equals(nameValue)){
                description = promotions.get(i).get("Description");
            }
        }
        return description;
    }
}
