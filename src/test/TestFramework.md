###Following a Git pull from Github, Engineering 92’s Final Project, a test framework for the Spartan Scheduler made by Engineering 87 can be run with some brief modifications:

1. A properties.properties file will need to be created and added to the resources folder, in which the user will have to add (variable names in keywords):

- A Username and Password for the website login

- A BrowserName of choice from firefox, chrome or edge

- A DBUserName and DBPassWord to connect to a local SQL database and a DBURL linking to that database.

- A schedulerPageURL linking to your localhost with port of your choosing, along with the following pages coming after your base localhost URL following a forward slash:

  - traineesPageURL

  - trainersPageURL

  - coursesPageURL

  - courseInfoPageURL

  - centresPageURL

  - accountPageURL

2. An SQL datafile containing testable dummy data for the website which can be provided upon request and added to the resources folder.

The TestRunner file in the Cucumber folder can run over 100 tests focusing on the behaviour of users accessing the website while a full suite of over 500 unit tests can be run from the Tests folder.

These tests will need to be updated as developments are made to the website, especially with regards to web element identification keywords.

Taking our project forward, another group may wish to investigate how to test multiple screen sizes. 