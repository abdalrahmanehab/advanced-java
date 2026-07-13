# Round 9 Advanced Java

A multi-module Maven workspace for advanced Java practice, examples, and future Spring Boot learning modules.

The project is structured as a parent Maven project that can group independent modules under one build. It currently targets Java 21 and is ready to grow into focused modules for data structures, Spring Boot architecture, persistence, design patterns, and functional programming.

## Tech Stack

- Java 21
- Maven
- JUnit Jupiter and Mockito versions managed for module tests
- Future Spring Boot modules for REST, service, repository, JPA, Hibernate, design patterns, and functional programming topics

## Project Structure

```text
round9-advanced-java/
├── pom.xml
├── data-structures/
│   ├── pom.xml
│   └── src/
└── README.md
```

## Modules

| Module | Purpose | Status |
| --- | --- | --- |
| `data-structures` | Examples for Java collections and related language features, including `ArrayList`, `LinkedList`, `HashSet`, streams, custom functional interfaces, and `equals`/`hashCode`. | Active |

## Planned Modules

The following modules are planned for future development:

| Planned Module | Focus |
| --- | --- |
| `spring-boot-rest` | REST APIs, controllers, request/response models, validation, and exception handling. |
| `spring-boot-service-layer` | Business logic, service orchestration, transactions, and clean application boundaries. |
| `spring-boot-repository-layer` | Repository abstractions, persistence boundaries, query methods, and data access patterns. |
| `spring-boot-jpa-hibernate` | Entity mapping, relationships, JPQL, Hibernate behavior, lazy loading, and persistence tuning. |
| `spring-boot-design-patterns` | Practical use of design patterns in Spring Boot applications. |
| `functional-programming` | Lambdas, streams, functional interfaces, `Optional`, immutability, and functional style in Java. |

## Prerequisites

- JDK 21+
- Maven 3.9+

Verify your local setup:

```bash
java -version
mvn -version
```

## Build

Build all modules from the project root:

```bash
mvn clean install
```

Run tests for all modules:

```bash
mvn test
```

Run tests for a specific module:

```bash
mvn -pl data-structures test
```

## Adding a New Module

1. Create a new module directory at the project root.
2. Add a module-specific `pom.xml` that uses `round9-advanced-java` as its parent.
3. Add the module name to the root `pom.xml` inside the `<modules>` section.
4. Keep source code under the standard Maven layout:

```text
module-name/
└── src/
    ├── main/
    │   ├── java/
    │   └── resources/
    └── test/
        ├── java/
        └── resources/
```

## Goals

- Keep each topic isolated in a dedicated module.
- Use tests to document behavior and protect examples from regressions.
- Favor clear, production-oriented examples over overly simplified snippets.
- Keep Spring Boot modules aligned with common real-world application layering.

## License

No license has been specified yet.
