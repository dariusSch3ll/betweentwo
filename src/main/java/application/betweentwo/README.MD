Help -> Eclipse Marketplace...
Search e(fx)clipse 3.6.0 -> Install
-> trust certificates

Back to Eclipse IDE -> File -> New -> Other...

Download JavaFX at https://gluonhq.com/products/javafx/
For me it was JavaFX version 19 SDK for Windows

extract the .zip file to a location you remember, for me I put it in my eclipse workspace directory
back to Eclipse IDE -> Windows -> Preferences
Search for User Libaries -> New...
Type in any name, for me it was "JavaFX" then -> OK
back in USER Libaries windows click on the new Creates Libary JavaFX and click on ADD EXTERNAL JARs...
go to your folder where u extracted the JavaFX folder, for me I put it in my eclipse workspace directory
now go into that folder and u will see a directory called "lib"
now u select every "javafx. " File and press -> OPEN
Back in User Libaries and then click -> Apply and Close
Back in Eclipse IDE right-click on your project in the Package Exlporer(the left menu in Eclipse), in this case "BurgerMenue"
build path -> configure build path -> libaries -> add libary -> user libary -> check JavaFx -> then apply

Error: JavaFX runtime components are missing, and are required to run this application

-> on the RUN button -> run configurations -> Java Application -> New application -> Arguments type this:
--module-path "D:\eclipse-workspace\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml
then your good to go





