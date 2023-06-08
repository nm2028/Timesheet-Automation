 Timesheet

Problem Statement : Verifying the Timesheet dates.
    This project aims to automate the testing of the Timesheet feature on the Cognizant portal using Selenium with Java.
    The test case involves logging in to the portal, searching for the ESA Timesheet, navigating to the Timesheet page,
    verifying the first three weeks dates.

Suggested Site : https://be.cognizant.com/

*****************************************************************************************************************

Detailed Description: Main Project

    * Launch https://be.cognizant.com/ in a web browser, and verify the appropriate site is opened or not.
    * Maximize the window and verify the respective application is opened or not.
    * Visiting the profile page and Printing the details of the Employee from the Be.Cognizant Profile page.
    * Search the Timeshet in search tab and click ESA TimeSheet.
    * Then window is switched and my Homepage will be opened then click on Timesheet .
    * Then we will be directed to Timesheet summary.
    * In Timesheeet page pick the last 3 weeks dates and store in excel sheet.
    * Display the same.
    * Compare the Timesheet week dates with the Displayed week dates on Timesheet.

*****************************************************************************************************************

Requirements
    * Login credentials for the Cognizant portal
    * Java Development Kit (JDK)
    * Eclipse IDE
    * Selenium WebDriver
    * TestNG testing framework
    * cucumber framework
    * Maven build automation tool
    * Jenkins for continuous integration and delivery
    * GitHub for version control and collaboration

*****************************************************************************************************************

Key Automation Scope
The test case involves several key automation tasks, including:

    * Handling different browser windows and tabs
    * Using the search option to locate the ESA Timesheet
    * Scrolling down the web page as necessary to access certain elements

*****************************************************************************************************************

Technologies Used
This project uses the following technologies:

    * Selenium WebDriver for web automation
    * Java programming language for scripting
    * cucumber framework that supports Behavior Driven Development for automation testing of web applications.
    * TestNG testing framework for organizing and executing test cases
    * Maven build automation tool for managing dependencies and building the project
    * Eclipse IDE for developing and debugging the code
    * Jenkins for continuous integration and delivery of the project
    * GitHub for version control and collaboration among team members

*****************************************************************************************************************

Setup and Execution
To run the automated test case, follow these steps:

    * Clone the project repository from GitHub to your local machine.
    * Open Eclipse IDE and import the project as a Maven project.
    * Install the necessary dependencies by running mvn clean install in the terminal or Maven console.
    * Set up your test environment by modifying the testng.xml file as necessary.
    * Run the test case using TestNG, either through Eclipse or the command line.
    * View the test results and any captured warning messages in the console or TestNG report.

*****************************************************************************************************************

Continuous Integration and Delivery
This project is set up for continuous integration and delivery using Jenkins. To configure Jenkins for this project,
follow these steps:

    * Install Jenkins on your server or local machine.
    * Create a new Jenkins job for this project and configure it to pull from the GitHub repository.
    * Set up email notifications or other alerts for test failures or other issues.
    * Monitor the Jenkins job for continuous integration and delivery of the project.

*****************************************************************************************************************

Test Case Description
The purpose of this test case is to verify the functionality of the ESA Timesheet feature on the Cognizant portal.
The test case involves navigating to the Timesheet page, verifying the first three weeks dates against expected values.

The expected outcomes of the test case are as follows:

    * The user is able to login to the Cognizant portal and navigate to the Timesheet page.
    * The first three weeks dates on the Timesheet page match the expected values.
    * By successfully executing this test case, we can ensure that the ESA Timesheet feature is working as intended
      and provide valuable feedback to the development team for any necessary improvements or enhancements.

*****************************************************************************************************************

Test Environment Setup
Hardware Requirements:
    * A computer with at least 4GB RAM
    * Internet connectivity
Software Requirements:
    * Java Development Kit (JDK)
    * Eclipse IDE for Java Developers
    * Selenium WebDriver
    * TestNG
    * Browser (Chrome, Firefox, or Edge)
Steps to Set up Test Environment
    *. Download and install the latest version of JDK from the official Oracle website.
    *. Download and install the latest version of Eclipse IDE for Java Developers from the official Eclipse website.
    *. Launch Eclipse IDE and create a new Java project.
    *. Add the Selenium WebDriver and TestNG dependencies to the project's build path. This can be done by adding
       the following lines to the project's pom.xml file if using Maven:
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>VERSION_NUMBER</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>VERSION_NUMBER</version>
        </dependency>
    *. Download the appropriate version of the WebDriver for your preferred browser (Chrome, Firefox, or Edge)
       and add it to the project's classpath.
    *. Configure the browser and web driver settings by creating a new WebDriver instance in the test code and setting
       the appropriate browser and driver options.
With these steps completed, the test environment should be fully set up and ready for use.

*****************************************************************************************************************

Test Execution Steps
    * Launch the web browser and navigate to the Cognizant portal login page.
    * Enter the user's email id and click on the "Next" button.
    * Validate the user's account details in the BeCognizant page.
    * Click on the "All Apps & tools" button to navigate to the Apps and Tools directory.
    * Enter "Timesheet" in the search bar and press enter to search for the ESA Timesheet.
    * Click on the "ESA Timesheet" option to navigate to the ESA Timesheet page.
    * Verify the first three week dates with the expected dates that have been calculated.
    * Store the actual and expected dates in an Excel file for record-keeping or further analysis.

*****************************************************************************************************************

Test Results and Reporting
    Once the test execution is complete, TestNG generates a detailed HTML report that provides
    a comprehensive view of the test results. The report includes the overall pass/fail status of
    the test suite, along with individual test case results, including any warnings or errors that
    were captured during the execution.

    To view the report, navigate to the project directory and open the "test-output" folder. Inside
    this folder, open the "emailable-report.html" file to view the HTML report in your web
    browser.

    In the report, the results for each test case are displayed along with their corresponding
    status (pass/fail/skip). Any captured warnings or errors will be displayed in the report along
    with their descriptions and timestamps, making it easy to identify the source of any issues
    that arise during the testing process.

    To troubleshoot any issues that arise during testing, it's important to review the log files and
    error messages carefully. The log files can provide valuable insight into the cause of any
    failures or errors, and can help you identify the source of any issues.

    If you encounter any issues during the testing process, it's important to follow standard
    troubleshooting procedures, including reviewing the code and logs, checking for any
    environmental issues, and seeking guidance from experienced colleagues or online
    communities. Debugging tools and techniques can also be used to identify and isolate the
    cause of any issues that arise.

*****************************************************************************************************************

Best Practices and Guidelines

Best practices for test automation include the following:

    * Plan your testing strategy: Before starting test automation, create a test plan that outlines
      the testing approach, including the scope, objectives, and test cases.
    * Choose the right tool: Select a testing tool that suits your testing needs, taking into
      account factors such as the technology stack, testing objectives, and budget.
    * Write effective test cases: Create test cases that are clear, concise, and reusable. Test
      cases should be easy to understand and maintain, and should cover all relevant scenarios.
    * Use design patterns: Apply design patterns such as Page Object Model (POM), which can
      help you create maintainable and scalable test automation frameworks.
    * Implement proper project structure: Structure your test automation project in a modular
      and organized manner, with clear separation of concerns and responsibilities.
    * Handle synchronization issues: To handle synchronization issues, use wait statements
      that allow the script to wait for elements to load or become clickable before proceeding.
    * Handle dynamic web elements: Use dynamic locators that can identify web elements
      based on their properties, such as ID, class, or text.
    * Implement logging and reporting: Use logging and reporting mechanisms to help track
      test execution and identify any issues that arise.
    * Use version control: Implement version control to track changes to your test automation
      scripts, and to manage collaboration and code review among team members.
    * Continuously improve: Continuously review and improve your test automation scripts and
      framework, and incorporate feedback from team members and stakeholders.

*****************************************************************************************************************

Future Work and Enhancements

    There are several potential future enhancements to this test automation project. One
    possibility is to add more test cases to cover additional scenarios and edge cases. Another
    possibility is to integrate the project with other testing tools or frameworks, such as JMeter
    for load testing or Appium for mobile testing.

    Additionally, implementing continuous testing practices can help to ensure that any new
    changes or updates to the application do not break existing functionality. This can be
    achieved by setting up a continuous integration and delivery pipeline using tools such as
    Jenkins or CircleCI.

    To contribute to the project or suggest new features, interested parties can create issues or
    pull requests on the project's GitHub repository. When making contributions, it is important
    to follow best practices for code quality and organization, and to communicate clearly with
    the project maintainers about any proposed changes or additions.