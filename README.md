# Automationpractice
https://automationpractice.com

This site emulates the operation of an online store with all the relevant attributes: the ability to register, log in, product pages, product categories, shopping cart, as well as a payment page.
Created by a subsidiary of seleniumframework.com specifically for the practice of automated testing.

I used this technologies:
Java JDK 8 is a powerful development environment for building applications and components using the Java programming language.
Selenium WebDriver is a library for various programming languages ​​that allows you to interact with browsers using browser code and driver.
Maven is a tool for automating the assembly of projects based on the description of their structure in files in the POM (Project Object Model) language, which is a subset of XML.
TestNG is a testing framework for the Java language built on top of JUnit and NUnit, but with improvements that make it more powerful and easier to use.
Allure is a test reporting tool that shows what was tested in an easy-to-use web-based report and allows everyone involved in the development process to get the most out of their day-to-day test execution.
CircleCi is a continious integration tool that allows you to run tests on a schedule as well as quickly identify problems in the program code.

Checklist:

ID: CREATE_1
Module: Create account page
Summary: Try to register by filling in all required fields with valid data.

ID: SIGN_1
Module: Sign in page	
Summary: Try sign in with valid credentials. 

ID: PAY_1	
Module: Cart payment page	
Summary: Check product price, product quantity, chosed products color and size at "Cart payment page".
				
ID: BANK_1
Module: Bank-wire payment page
Summary: Check total amount of order when choosing "Pay by bank wire".

ID: HIST_2
Module: Order history page	
Summary: Make order and pay by check, then check it by order reference at "Order history page".

ID: SIGN_2
Module: Sign in page
Summary: Try sign in with invalid credentials (empty email field; empty password field; empty all sign in fields) and receive error message.

ID: MY_ADR_1
Module: My adress page
Summary: Check that adress at "My adress page" can be updated.

ID: CART_ADR_1
Module: Cart adress page
Summary: Create new adress then check that this adress can be chosed at "Cart adress page" like a delivery adress.

ID: SUM_3
Module: Cart summary page
Summary:C heck product price, product quantity, chosed products color and size in cart.

ID: FIND_1
Module: Found page
Summary: Check found product.
