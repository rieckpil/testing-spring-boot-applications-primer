[![Primer Course](https://rieckpil.de/wp-content/uploads/2021/06/testing-spring-boot-applications-primer-course-logo.png)](https://rieckpil.de/testing-spring-boot-applications-primer/)

# About the Primer

[![](https://img.shields.io/badge/Spring%20Boot%20Version-2.7.0-orange)](/pom.xml)
[![](https://img.shields.io/badge/Java%20Version-17-orange)](/pom.xml)
[![](https://img.shields.io/badge/Enroll-Now-orange)](https://rieckpil.de/testing-spring-boot-applications-primer/)

`master` branch: [![Build & Test Maven Project (master)](https://github.com/rieckpil/testing-spring-boot-applications-primer/workflows/Build%20&%20Test%20Maven%20Project/badge.svg)](https://github.com/rieckpil/testing-spring-boot-applications-primer/actions/workflows/maven.yml?query=branch%3Amaster)

> This is the source code for the **Primer** online course, you'll find the source code for the **Masterclass** [here](https://github.com/rieckpil/testing-spring-boot-applications-masterclass).

## Introduction

The Testing Spring Boot Applications Primer is a **beginner-friendly course on testing your Spring Boot applications**. You'll learn how to effectively write **unit, integration, and end-to-end tests** while utilizing Spring Boot's excellent test support.

- Guided Introduction For Testing Real-World Spring Boot Applications
- 15 Course Lessons Covering Unit, Integration and End-to-End Testing
- 12 Hands-On Exercises Including a Final Assessment

TL;DR:

- Getting started with testing Spring Boot applications
- Learn more about the `spring-boot-starter-test` dependency
- Write your first unit, integration and end-to-end test
- Get familiar with common Java testing libraries: JUnit 5, Mockito, Testcontainers, Selenium, etc.

Enroll [here](https://rieckpil.de/testing-spring-boot-applications-primer/) for the Testing Spring Boot Applications Primer Online Course.

## Further Resources and Links

* [Course Landing Page](https://rieckpil.de/testing-spring-boot-applications-primer)
* [Course Overview](https://rieckpil.de/courses/testing-spring-boot-applications-primer/)
* [Course Login](https://rieckpil.de/wp-login.php)
* [Password Reset](https://rieckpil.de/wp-login.php?action=lostpassword)

# Local Project Setup

## Requirements

Mandatory requirements:

* Java 17 (JDK flavour (OpenJDK/Azul/Oracle) does not matter). For the correct Java version setup I can recommend [JEnv](https://www.youtube.com/watch?v=9FVZyeFDXo0) (Mac/Linux) and the [Maven Toolchains Plugin](https://maven.apache.org/plugins/maven-toolchains-plugin/toolchains/jdk.html) (Windows)

```
$ java -version
openjdk version "17" 2021-09-14 LTS
OpenJDK Runtime Environment Zulu17.28+13-CA (build 17+35-LTS)
OpenJDK 64-Bit Server VM Zulu17.28+13-CA (build 17+35-LTS, mixed mode, sharing)
```

* Docker Engine (Community Edition is enough) and Docker Compose:

```
$ docker version
Client: Docker Engine - Community
 Version:           20.10.6
 API version:       1.41
 Go version:        go1.13.15
 Git commit:        370c289
 Built:             Fri Apr  9 22:47:17 2021
 OS/Arch:           linux/amd64
 Context:           default
 Experimental:      true

Server: Docker Engine - Community
 Engine:
  Version:          20.10.6
  API version:      1.41 (minimum version 1.12)
  Go version:       go1.13.15
  Git commit:       8728dd2
  Built:            Fri Apr  9 22:45:28 2021
  OS/Arch:          linux/amd64
  Experimental:     false

$ docker-compose version
docker-compose version 1.26.2, build eefe0d31
docker-py version: 4.2.2
CPython version: 3.7.7
OpenSSL version: OpenSSL 1.1.1g  21 Apr 2020
```

Optional requirements:

* Maven >= 3.6 (the project also includes the Maven Wrapper).

When using Maven from the command line, make sure `./mvnw -version` reports the correct Java version:

```
$ ./mvnw -version

Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: /home/rieckpil/.m2/wrapper/dists/apache-maven-3.8.4-bin/52ccbt68d252mdldqsfsn03jlf/apache-maven-3.8.4
Java version: 17.0.1, vendor: Eclipse Adoptium, runtime: /usr/lib/jvm/jdk-17.0.1+12
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-92-generic", arch: "amd64", family: "unix"
```

* IntelliJ IDEA or any IDE/Code Editor (Eclipse, NetBeans, Code, Atom, etc.)
