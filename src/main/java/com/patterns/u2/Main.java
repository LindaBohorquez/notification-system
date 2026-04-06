package com.patterns.u2;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Demo: Singleton + Factory Method ===\n");

        // Singleton test
        NotificationLogger logger1 = NotificationLogger.INSTANCE;
        NotificationLogger logger2 = NotificationLogger.INSTANCE;

        System.out.println("Same instance: " + (logger1 == logger2));

        // Factory usage
        Notifier email = NotifierFactory.create("email");
        Notifier sms = NotifierFactory.create("sms");
        Notifier push = NotifierFactory.create("push");

        email.send("cliente@mail.com", "Order #1001 confirmed");
        sms.send("+57-300-0000001", "Order #1001 confirmed");
        push.send("device-token", "Order ready to ship");

        // Dynamic registration (OCP)
        NotifierFactory.register("slack", () -> new Notifier() {
            public String channel() { return "SLACK"; }

            public void send(String r, String m) {
                NotificationLogger.INSTANCE.log(channel(), r, m);
            }
        });

        NotifierFactory.create("slack").send("#orders", "Order processed");

        // Print logs
        NotificationLogger.INSTANCE.printAll();
    }

}
