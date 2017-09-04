Feature: To Merge all the users from different files with user ID in ascending order

  @Scenario
  Scenario: Task is to read users from CSV,JSON and XML files
    and merge them into CSV,JSON and XML output files in ascending order of their userids

    Given Input data files are ready to be read in data package
    #And Output XML data file is created and is empty in Output Package
    #And Output JSON data file is created and is empty in Output Package
    #And Output CSV data file is created and is empty in Output Package
    When an XML input file is read and sorted
    And a CSV input file is read and sorted
    And a JSON input file is read and sorted 
    Then all CSV,JSON,XML output files should be present with the merged data
