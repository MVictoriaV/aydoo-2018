Exercise Fibonacci 3
====================

This project is an example to take as a basis for the different projects of the subject. The project is based on Maven 3 and already has a set of preconfigured tools:

JUnit
Cucumber-JVM
Cobertura
PMD
CheckStyle
Commands:

To compile and run the tests: mvn clean test
To generate an executable jar package: mvn clean package. The resulting package will be found in the target directory with the name that has been specified in the finalName of pom.xml.
To run the tests and measure coverage: mvn clean coverage:coverage. The resulting report will be found in target/site/cobertura/index.html.
To check the style with CheckStyle: mvn clean checkstyle:checkstyle. The resulting report will be found in target/site/checkstyle.html
