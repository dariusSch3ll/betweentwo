<!-- ABOUT THE PROJECT -->
## About The Project






<!-- GETTING STARTED -->
## Getting Started

Project Created with Eclipse IDE

Help -> Eclipse Marketplace... Search e(fx)clipse 3.6.0 -> Install -> trust certificates
Back to Eclipse IDE -> File -> New -> Other...

Download JavaFX at https://gluonhq.com/products/javafx/ For me it was JavaFX version 19 SDK for Windows

Extract the .zip file to a location you remember, for me I put it in my eclipse workspace directory.


Error: JavaFX runtime components are missing, and are required to run this application

On the RUN button -> run configurations -> Java Application -> New application -> Arguments type this:
   ```
   --module-path "ur\path\to\JavaFX_19_SDK\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml
   ``` then your good to go



### Installation


1. Clone the repo
   ```
   git clone git@github.com:dariusSch3ll/betweentwo.git
   ```
2. In Eclipse IDE
   ```
   File -> Import... -> Maven -> Existing Maven Project -> In Root directory, Browse the downloaded repository -> Finish
   ```
4. Get Started



<!-- ROADMAP -->
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish



<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


