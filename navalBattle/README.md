Exercise Naval Battle (*)
=========================

This project is an example to take as a basis for the different projects of the subject.
The project is based on Maven 3 and already has a set of preconfigured tools:

* JUnit
* Cucumber-JVM
* Cobertura
* PMD
* CheckStyle

Commands:

* To compile and run the tests: _mvn clean test_
* To generate an executable jar package: _mvn clean package_. The resulting package will be found in the target directory with the name that has been specified in the finalName of pom.xml.
* To run the tests and measure coverage: _mvn clean coverage:coverage_. The resulting report will be found in target/site/cobertura/index.html.
* To check the style with CheckStyle: _mvn clean checkstyle:checkstyle_. The resulting report will be found in target/site/checkstyle.html




(*) Since I had a project with name exercise2, then to avoid conflict with the master, the name navalBattle was used.
