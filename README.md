# 🚀 demo_project — Test Automation Showcase (Sanitized)

A compact, NDA-safe Selenium + TestNG automation framework created specifically for **interview and portfolio demonstration**. All sensitive production/staging URLs, API endpoints, and tokens have been replaced with placeholders, while the technical structure reflects a real-world automation framework.

This project demonstrates strong fundamentals in framework design, Page Object Model, utilities, data‑driven testing, and CI integration.

---

## ✨ Key Features
- **Page Object Model (POM)** for scalable and maintainable UI automation
- **Data‑driven testing** using CSV/XLSX via a custom `XlsReader` utility
- **Sanitized validation test:** `sanitized.DemoSanitizedTest`
- **Reusable base setup** (Driver initialization, waits, hooks)
- **Config‑driven execution** using `application.properties`
- **Cross‑browser support:** Chrome, Edge, Firefox
- **CI-ready:** GitHub Actions workflow running Maven tests & publishing artifacts

---

## 🧰 Tech Stack
- Java 17
- Maven
- TestNG
- Selenium WebDriver
- Apache POI (XLSX handling)
- GitHub Actions (CI pipeline)

---

## 📂 Project Layout
```
demo_project
 ├── src
 │   ├── main/java
 │   │   ├── base/                # BaseClass, DriverFactory (sanitized)
 │   │   ├── pages/               # Page Objects (sanitized)
 │   │   └── utils/               # Helpers, XlsReader, config utils
 │   ├── test/java
 │   │   └── sanitized/
 │   │       └── DemoSanitizedTest.java
 │   └── resources/
 │       └── application.properties   # Sanitized config
 ├── demo_UserDetails.csv             # Dummy demo data
 ├── demo_UserDetails.xlsx            # Dummy demo data
 ├── pom.xml                           # Maven build/dependencies
 └── .github/workflows/ci.yml          # CI workflow
```

---

## ▶️ Running the Demo Validation Test
From the project root:
```bash
mvn -Dtest=sanitized.DemoSanitizedTest test
```

---

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


"# demo_project" 
"# demo_project" 
"# demo_project"  
