# Playwright + Java Automation Playground

**Exploring locators, smart waits, Page Object Model, API testing basics, parallel execution, traces, screenshots, videos and beautiful HTML reports**

This repository is my personal playground for learning and experimenting with **Playwright for Java**.

### What's inside

- Smart locator strategies (CSS, XPath, text, role, nth, filter, chaining...)
- Effective waiting patterns (auto-waiting + explicit waits)
- Clean **Page Object Model** (POM) implementations
- Basic **API testing** with Playwright's request context
- Running tests in **parallel**
- Capturing **screenshots**, **videos** and full **traces**
- Generating beautiful **HTML reports**

### Tech Stack

- Java (17+)
- Playwright for Java
- Maven
- TestNG (or JUnit 5 – depending on the example)
- Playwright built-in HTML reporter

### Quick Setup

```bash
# Clone the repository
git clone https://github.com/YOUR-USERNAME/YOUR-REPO-NAME.git
cd YOUR-REPO-NAME

# Install dependencies & build
mvn clean install

# Install Playwright browsers (only needed once)
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium firefox webkit"
