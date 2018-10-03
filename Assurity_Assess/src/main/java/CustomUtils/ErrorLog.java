//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// captureErrorDetails - creates a text file in the Error_Logs folder, which has the test name, appended with   //
//                       the date that the test was run. Custom error messages are passed to the method as a    //
//                       string and written to the file.                                                        //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package CustomUtils;

import Config.GlobalVariables;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorLog {

    public void captureErrorDetails(String errorMessage) {

        try {
            // Get the current date
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String dateStr = sdf.format(date);

            // Build the name of the file
            String fileName = "Error_Logs/" + GlobalVariables.currentTestName + "_" + dateStr + ".txt";

            File file = new File(fileName);

            //Write the error message to the file
            FileWriter writer = new FileWriter(file, true);
            writer.append("\r\n");
            writer.append(errorMessage);
            writer.close();
        }
        catch (IOException e){
            Assert.fail("Unable to write to the error file.");
        }
    }
}
