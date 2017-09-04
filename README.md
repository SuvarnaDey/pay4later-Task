
Developer – Suvarna Dey
Below has been used to complete the given task.
OO Programming Language – JAVA
IDE – Eclipse
Build Tool – Maven
Framework – Behavior Driven Development (BDD - Cucumber)
Below are the design details used for implementing the given task.
Location – src/test/java
Feature Package:
It includes feature file which contains the given task or requirement in Gherkin Language (Given, When, Then). It represents the problem statement as a behavior described in an agile world today.
Implementation Package:
The implementation package contains two classes:
1.	stepDefinition class that contains the java code for the feature file.
2.	TestRunner Class is used in JUNIT framework for test run. It more like a starting point for Junit to start executing your tests. 
dataReader Package:
The package contains various classes to read data from the input XML, CSV and JSON files. It passes on the data read in the form of arraylists to various classes which has implementation for writing data into output files.
mergeDataPacakge:
The package contains various classes to create output files and write data in these files. The classes receive arraylists from the reader classes and writes them in the format specified. The action also contains merging of data from CSV, JSON and XML input files.
SortByUserID Package:
It contains the code for sorting the data that is read from the input data files into ascending order of userids. It accepts the unsorted data in the form of arraylist and returns the sorted data again in the form of arraylist.
Data Package:
It contains the .csv,.json,.xml input files having user data
Output Package:
It contains the output files with the merged and sorted data.
