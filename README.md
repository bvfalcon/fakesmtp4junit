fakesmtp4junit
========
fakesmtp4junit based on FakeSMTP utility - simple java smtp server - and adapted for usage with JUnit 5.

Description of FakeSMTP you can read [here](http://nilhcem.com/FakeSMTP/).

Intro
--------
JavaMail [Session](https://jakarta.ee/specifications/platform/8/apidocs/javax/mail/session) is declared as final class, that make difficult to mockify it. To use JavaMail in JUnit-tests you can use this extension. This extension starts FakeSMTP-server on test startup and shut it down after test completion.

Basic usage
--------
In jour JUnit5-Test define @RegisterExtension:
```java
@RegisterExtension
static FakeSmtpJUnitExcension extension = new FakeSmtpJUnitExcension().port(2021);
```
Default values: port 25, host localhost. actions: start FakeSMTP on @BeforeAll, shut down FakeSMTP on @AfterAll and deleteEmails on @AfterEach.

Usefull functions
--------
`FakeSMTP.getEmails` -- get Emails

Usage with maven/gradle/...
--------
You can add extension in your project as described in [Jitpack How to](https://jitpack.io/#bvfalcon/fakesmtp4junit).
