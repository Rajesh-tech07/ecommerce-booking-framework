<<<<<<< HEAD
# ecommerce-automation-framework — Test Automation Framework (Sanitized)
=======
# 🚀 Test Automation Showcase (Sanitized)
>>>>>>> e9a6030c21c25e1908e32403437d6859b90df83e

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
<<<<<<< HEAD
 │   └── test/java
 ├── src/test/resources/application.properties
 ├── test_UserDetails.csv
 ├── test_UserDetails.xlsx
 ├── pom.xml
 └── logs/
     └── ecommerce.log
=======
 │   │   ├── base/                # BaseClass, DriverFactory (sanitized)
 │   │   ├── pages/               # Page Objects (sanitized)
 │   │   └── utils/               # Helpers, XlsReader, config utils
 │   ├── test/java
 │   │   └── sanitized/
 │   │       └── DemoSanitizedTest.java
 │   └── resources/
 │       └── application.properties   # Sanitized config
 ├── test_UserDetails.csv             # Dummy test data
 ├── test_UserDetails.xlsx            # Dummy test data
 ├── pom.xml                           # Maven build/dependencies
 └── .github/workflows/ci.yml          # CI workflow
>>>>>>> e9a6030c21c25e1908e32403437d6859b90df83e
```

---

## Running tests
From project root:

mvn -Dtest=<fully.qualified.TestClass> test

Override properties at runtime:

mvn -Dxls.path=test_UserDetails.csv -Dapp.url=https://example.local -Dtest=<test> test

---

<<<<<<< HEAD
## Notes
- groupId/artifactId in pom.xml updated to: com.ecommerce : ecommerce-automation-framework
- Log file is logs/ecommerce.log (configured in src/test/resources/log4j.properties)
- If you use an IDE, refresh the project after these changes and run `mvn -DskipTests clean` locally to remove stale build artifacts under target.
=======
## 🔄 Override Demo Data or Application URL
You can override config at runtime:
```bash
mvn -Dxls.path=demo_UserDetails.csv \
    -Dapp.url=https://example.local \
    -Dtest=sanitized.DemoSanitizedTest test
```
- `XlsReader` supports **CSV & XLSX**.
- If the file is missing, it falls back to an **in‑memory demo dataset**.

---

## 🔐 Sanitization & NDA Compliance
This repository is intentionally safe for public sharing:
- All real **environment URLs**, **API endpoints**, **tokens**, and **secrets** replaced with placeholders
- Demo CSV/XLSX contain **dummy test data** only (no PII)
- No internal business logic included
- Mirrors real framework structure without exposing confidential details

---

## 💬 Purpose of This Project
- Illustrates a clean automation framework structure based on real-world practices
- Demonstrates use of Page Object Model, utilities, waits, and configuration handling
- Shows integration with CI tools such as GitHub Actions
- Designed to be simple to clone, run, and review
- Fully sanitized to avoid exposing any internal or confidential data

NDA‑friendly

 
# ecommerce-booking-framework
>>>>>>> e9a6030c21c25e1908e32403437d6859b90df83e
