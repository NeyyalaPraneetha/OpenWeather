# OpenWeather

Used selenium Webdriver and Java to Automate this appilaction.
Have used Intellij as my IDE to build the Cucumber framework using Gerkhin language.

Need to install few jars and drivers to execute this:

1. Java jdk 1.8
2. Intellij Ultimate 2020 version as community version version wont support .js files
3. Selenium webdriver
4. Chrome driver, the version of driver and the browser should be same.
5. cucumber-core-1.2.6
6. cucumber-java-1.2.6
7. cucumber-junit-1.2.5
8. cucumber-jvm-deps-1.0.6
9. gherkin-2.12.2
10. gherkin-3.2.0

I have created feature file using teh below acceptance criteria:

This application displays the 5 day weather forecast for a given location.

**Features**
Enter city name, get 5 day weather forecast
Select day, get 3 hourly forecast
Select day again, hide 3 hourly forecast
Daily forecast should summarise the 3 hour data:
Most dominant (or current) condition
Most dominant (or current) wind speed and direction
Aggregate rainfall
Minimum and maximum temperatures

I have created **Stepdefs** file under StepImplementaion folder as stepdef.java

Created a utility called **Driverfactory** to launch the browser and exit . 

Have created **testRunner** to execute the tests using Junit and Cucumber tests

Can show a demo/ execution if required.




