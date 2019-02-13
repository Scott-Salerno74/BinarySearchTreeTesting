# BinarySearchTreeTesting
Practicing Testing Using Tools Like Mockito, JUnit , and Log4j with Search Tree, UI, and Data Bases


Things to make sure of if project isn't running

1. Make sure that 'src' folder is marked as root
   - Right click TestingProject/src > 'Mark directory as Root'
2. Need to explicitly create an 'out' folder
   - mkdir TestingProject/out
   - File > Project Structure > Project
       - Project SDK -> 1.8
       - Project Language Level -> SDK default (8 - Lambdas, type annotations, etc)
       - Project Compiler Output -> TestingProject/out

## Opening the project for the first time

Intellij > File > Open > TestingProjec (If BinarySearchTreeTesting is the root folder in the project explorer, the project probably won't work)

File > Project Structure 
- In the 'Sources' Tab, make sure that on the right side of  the screen, 'src' and 'Resources' are listed under 'Source Folders'
  - If not select the folder, and click on 'Sources' above, where it says 'Mark as:'



ON MAC:

1. Install maven: https://maven.apache.org/install.html
2. Then we need to add Maven to PATH variable: https://stackoverflow.com/questions/9134712/setting-up-maven-3-properly
3. Run 'mvn -v' to verify that it has installed and been added to your Path correctly

Notes:
pom.xml - The required dependencies for Mockito, JUnit and Log4J are defined in pom.xml, located at /TestingProject/pom.xml.  Make sure pom.xml is located at the root of 'TestingProject'  In IntelliJ, go to either Build > Build project or Build > Rebuild Project.  

Once Maven downloads the dependencies, they will be located at 'External Libraries' in the Project Explorer.  If they still aren't downloading, right click on the project, go to 'Add framework support...', and check 'Maven'. Once you click 'Okay', Maven will resolve and download the dependencies.  Whenever you make a change to the pom.xml file, a pop up will appear that will say 'Maven projects need to be imported'.  Clicking 'Import Changes' will make Maven download everything.  Alternatively, right click on the project, go down to 'Maven' and click 'Reimport'.  

All of the dependencies should be located under 'External Libraries'

## Using JUnit in intelliJ
With Intellij, J-unit 5 is available with the newest Version. I Used JUnit 5 to conduct my Tests, However we imported Junit 4.2 from our Pom.xml.
To Create a Test in IntelliJ, You must click on the name of the class You are looking to test. Once it is Highlighted, Press Alt+Enter and you are given the option to create a test. From there you create a test with the testing material you want and for us it was Junit. 
From There You import the Junit material and go ahead. 
Assertions in Junit help to find problems when testing the code.


## LOG4J

1. Create resources folder.  Put log4j2-test.json in that folder.
2. Right click project
3. Project Strucutre
4. Click Resourcs Folder
5. Click 'Sources' above
6. 'Resources' should be listed under 'Source Folders' to the right.

More about configuration: http://logging.apache.org/log4j/2.x/manual/configuration.html



