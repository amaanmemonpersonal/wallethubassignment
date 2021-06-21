# Pro Mobileapp Automation

Supported Platforms
Appium supports app automation across a variety of platforms, like iOS, Android, and Windows. Each platform is supported by one or more "drivers", which know how to automate that particular platform. Choose a driver below for specific information about how that driver works and how to set it up:

Android
- The UiAutomator2 Driver
- Macaca Inspector
   install macaca on windows:- (npm install macaca-cli -g)
   run macaca on windows:- (npm install app-inspector -g)
- The Windows Driver (for Windows Desktop apps)


Highlights:
Support for Mobile, Web and API testing
Parallel test execution
Support for Selenium Grid
Custom test listeners (support for integration with various APIs)
Page Object pattern
Eye candy reports (with screenshots) deployed on standalone server

Technology stack:
TestNG (test runner)
Appium (mobile testing)
Selenium (web app testing)
REST-assured (REST API testing)
Allure (reporting)

Why Appium?
- You don't have to recompile your app or modify it in any way, due to use of standard automation APIs on all platforms.
- You can write tests with your favorite dev tools using any WebDriver-compatible language such as Java, JavaScript (Node)and Python with the Selenium WebDriver API and language-specific client libraries.
- You can use any testing framework.
- Appium has built-in mobile web and hybrid app support. Within the same script you can switch seamlessly between native app automation and webview automation, all using the WebDriver model that's already the standard for web automation.

Prerequisite
- Java should be installed and java path should be set.(version 7 and above)
- Android studio should be installed.(version 22 and above)
- Node js should be installed. (supported version 10+)
- Setup Appium command server setup/ download and install appium GUI exe latest
- Install Google USB Driver latest
- Install IDE -eclispse/Intelligent/android studio
- Set the environment variables for java jdk and android SDK.

Running tests
Upload apk on the jenkins
Prepare a TestNG Test Case (Appium_TestNG_Sample_One) class file
Run this TestNG class after launching Appium server by right clicking on the TestNG.xml–>RunAs–>TestNG Suite

- On VM (http://192.168.1.177:8080) on conncected Android device with android version of (8.1.0)
  1. Order entry test cases for AMO - http://192.168.1.177:8080/job/OrderEntrAMO/
  2. Order entry test cases for SIMPLE - http://192.168.1.177:8080/job/OrderEntrySIMPLE/
  3. Order entry test cases for CO - http://192.168.1.177:8080/job/OrderEntryCO/
  4. Order entry test cases for OCO - http://192.168.1.177:8080/job/OrderEntryOCO/
  5. Order entry test cases for all negative scenarios - http://192.168.1.177:8080/job/OrderEntryNegative/

- On BrowserStack(http://mobile-ci.rksv.net:8080) on One plus 7 real device with android version of (9.0)
  1. Order entry sanity test cases - http://mobile-ci.rksv.net:8080/job/android-pro-automated-tests-os9/
  
Reporting
We use maven surefire plugin which automatically generates xml test reports and stored in target/surefire-reports. And these XML files are transformed to an HTML report by Allure.






