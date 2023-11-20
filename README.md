Veeva Automation Framework Code Execution

1. Install JAVA in your system - https://phoenixnap.com/kb/install-java-windows

2. Install Maven in your system - https://phoenixnap.com/kb/install-maven-windows

3. Clone the code from repo into your system

4. Build automation-core module and create a jar file which will be used as dependency by CP and DP1 Modules. 
To package JAR and install in local repo run the command mvn install in automation-framework project root directory where pom.xml file is present.

Test execution for CP Module
Go to CP Module root directory where pom.xml is present

Run command - mvn test verify -DsuiteFile=src/test/resources/CPTestSuite.xml

After the tests are executed for CP Module Log.txt file is generated which contains the Jacket Title,Price and top seller message shown below the product. 
Note - If no top seller message is present it displays NULL in the log file.

Along with the log file HTML report is being generated in target/cucumber-htlm-reports/Overview-features.html which shows all the tests run, No of passed/failure test cases and steps in detail.


Tests execution for  DP1 Module
Go to DP1 Module root directory where pom.xml is present

Run command - mvn test verify -DsuiteFile=src/test/resources/CPTestSuite.xml

After the tests are executed for CP Module Log.txt file is generated which contains the Jacket Title,Price and top seller message shown below the product. 
Note - If no top seller message is present it displays NULL in the log file.

Along with the log file HTML report is being generated in target/cucumber-htlm-reports/Overview-features.html which shows all the tests run, No of passed/failure test cases and steps in detail.


Build Parent module 
Go to parent project root directory

Run command - maven install -DskipTests 