# Daraz Test Automation Framework

## Overview

This repository contains a test automation framework for the **Daraz.lk** (https://www.daraz.lk/#?) website, developed for the IS4102 – Advanced Software Quality Assurance course. The framework leverages **Selenium WebDriver** and **TestNG**, following the **Page Object Model (POM)** design pattern to ensure modularity, readability, and maintainability of test scripts.

The test cases focus on essential e-commerce functionalities, such as filtering products by category and price, sorting results, and verifying search functionality. The framework is designed to support scalability and cross-browser testing.

---

## Key Features

- **Page Object Model (POM)**: Each page is represented by a dedicated Java class, encapsulating locators and actions specific to that page.
- **Data-Driven Testing**: TestNG’s `@DataProvider` enables testing with dynamic input data for increased test coverage.
- **Cross-Browser Compatibility**: Configurable to run on multiple browsers.
- **Reporting and Assertions**: Provides built-in reporting and assertions to validate test outcomes.
- **Reusable Utility Classes**: Common functionalities such as browser setup, scrolling, and price validation are abstracted into utility methods.

---

## Test Cases
The framework includes the following test cases, designed to verify key functionalities of the Daraz.lk website:

- Filter DSLR Cameras by Price

Verifies category navigation, price filtering, and product listing for DSLR cameras.

- Search Wallets, Filter by Brand, and Sort by Price

Tests the ability to search for wallets, apply a brand filter, and sort products by price (Low to High).

- Price Filtering for Phones
 
Checks that price filtering works correctly within specified minimum and maximum price ranges.
Each test script is self-contained and uses assertions to validate the expected outcomes. Detailed logs and console outputs provide insights into test execution results.

---
### Components

- **Page Classes**: Each webpage is represented by a class in the `pages` package, encapsulating locators and action methods for that page.
- **Utility Classes**: Contains common utility functions (e.g., browser setup) that support reusable actions across the framework.
- **Test Data**: Dynamic data for testing is provided via the `@DataProvider` annotation in `dataProvider` classes, allowing parameterized test execution.

---

## Prerequisites

- **Java** 11 or higher
- **Maven** for dependency management
- **Selenium WebDriver** and **TestNG** (defined in `pom.xml`)
- Supported browsers: **Chrome**, **Firefox**, **Edge**

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Rashmina-Senadheera/IS4102
   cd 20020961



