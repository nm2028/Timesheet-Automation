Feature: Timesheet Testing

  Scenario: Check dates on Timesheet
    Given user is on login page
    When user enters emailId and clicks on next button
    Then user is navigated to the home page and userName and job role is printed
    When user clicks on All Apps & tools then user is navigated to Apps and Tools Directory
    When user enters Timesheet and press enter and clicks ESA timesheet
    Then window is switched
    And Timesheet is clicked
    Given user is on Timesheet Page
    When The first three week dates are checked with the calculated expected dates
    And Store the actual and expected dates in the excel file
 
