# Notification System

## 📌 Description

This project implements a notification system using two creational design patterns:

- **Singleton**
- **Factory Method**

The system simulates sending notifications through different channels such as Email, SMS, Push, and dynamically added channels like Slack.

---

## 🧠 Implemented Design Patterns

### 🔹 Singleton (NotificationLogger)

**Problem it solves:**
Ensures that there is only one instance responsible for logging all notifications across the application.

**Solution:**
The `NotificationLogger` is implemented using an `enum`, which guarantees:
- A single instance
- Thread safety
- Global access

**Benefit:**
All notifications are stored in a centralized log without duplicating instances.

---

### 🔹 Factory Method (NotifierFactory)

**Problem it solves:**
Avoids coupling the client code with concrete classes (EmailNotifier, SmsNotifier, etc.).

**Solution:**
The `NotifierFactory` uses a dynamic registry (`Map<String, Supplier<Notifier>>`) to create notifier objects based on a string type.

**Benefit:**
- Easy to extend (Open/Closed Principle)
- New notification types can be added without modifying existing code

Example:
```java
Notifier notifier = NotifierFactory.create("email");
