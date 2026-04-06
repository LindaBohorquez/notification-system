# Notification System

## Description
This project implements two creational design patterns:
- Singleton (NotificationLogger)
- Factory Method (NotifierFactory)

## Patterns

### Singleton
Ensures a single instance of NotificationLogger across the application.

### Factory Method
Allows creating different types of notifiers (Email, SMS, Push) without coupling the client code.

## How to run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.patterns.u2.Main"
