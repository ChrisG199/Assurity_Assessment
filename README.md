# Assurity_Assessment
Chris Gill Assessment

Prerequisites:

Java 1.8

Installation:

Download the “Assurity Assess” project to your Mac or PC.

Running the tests:

Run from IDE:

Open the project in a Java IDE (Eclipse or IntelliJ). Go to the “TestNG” folder (in the main project directory), right click and choose run.
A report called Assessment_Extent.html will be created under the test_ouput folder

Run from command line:

Open the terminal (Mac) or command line prompt (PC) and go to the project directory. Run the following command:

mvn clean test -DsuiteXmlFile=AssessmentTest.xml

A report called Assessment_Extent.html will be created in the folder: Assurity_Assess/target/surfire-reports.

Test Coverage

The test performs 3 validations:

1. Checks if the name in the JSON response is Carbon Credits.
2. Checks if the value for CanRelist is true.
3. Checks if the description of the promotions object with Name = “Gallery” contains “2x larger image” as part of the description.

Built With

Java
TestNG
Maven

Author

Chris Gill
