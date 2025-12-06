# ecommerce-automation-framework — Test Automation Framework (Sanitized)

A compact, NDA-safe Selenium + TestNG automation framework intended for interview and portfolio demonstrations. Sensitive URLs, tokens and environment details are replaced with placeholders.

---

## Key features
- Page Object Model (POM)
- Data-driven tests (CSV/XLSX via XlsReader)
- Reusable base setup (driver init, waits, hooks)
- Config-driven execution using application.properties
- Cross-browser support (Chrome, Edge, Firefox)
- CI-ready (Maven-based)

---

## Tech stack
- Java (project uses Java compatibility set in IDE)
- Maven
- TestNG
- Selenium WebDriver
- Apache POI (XLSX)

---

## Project layout (trimmed)
```
ecommerce-automation-framework/
 ├── src
 │   ├── main/java
 │   └── test/java
 ├── src/test/resources/application.properties
 ├── test_UserDetails.csv
 ├── test_UserDetails.xlsx
 ├── pom.xml
 └── logs/
     └── ecommerce.log
```

---

## Running tests
From project root:

mvn -Dtest=<fully.qualified.TestClass> test

Override properties at runtime:

mvn -Dxls.path=test_UserDetails.csv -Dapp.url=https://example.local -Dtest=<test> test

---

## Notes
- groupId/artifactId in pom.xml updated to: com.ecommerce : ecommerce-automation-framework
- Log file is logs/ecommerce.log (configured in src/test/resources/log4j.properties)
- If you use an IDE, refresh the project after these changes and run `mvn -DskipTests clean` locally to remove stale build artifacts under target.