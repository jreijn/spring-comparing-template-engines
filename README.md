# Comparing Template engines for Spring MVC

[![Build Status](https://travis-ci.org/jreijn/spring-comparing-template-engines.png?branch=master)](https://travis-ci.org/jreijn/spring-comparing-template-engines)

This is a demo project, which accompanied my ["Shoot-out! Template engines for the JVM"](http://www.slideshare.net/jreijn/comparing-templateenginesjvm) presentation, which shows the differences among several Java template engines in combination with Spring MVC. Template engines used in this project are:

* JSP + [JSTL](https://jstl.java.net/) - v1.2
* [Freemarker](http://www.freemarker.org/) - v2.3.28.RELEASE
* [Velocity](http://velocity.apache.org/) - v1.7
* [Velocity Tools](http://velocity.apache.org/tools/) - v2.0
* [Thymeleaf](http://www.thymeleaf.org/) - v3.0.11.RELEASE
* Mustache - Based on [JMustache](https://github.com/samskivert/jmustache) - v1.14
* [Scalate](http://scalate.fusesource.org/)  - v1.9.3
* [Jade4j](https://github.com/neuland/jade4j) - v1.2.7
* [HTTL](http://httl.github.io/en/) - v1.0.11
* [Pebble](https://pebbletemplates.io/) - v3.0.7
* [Handlebars](http://jknack.github.io/handlebars.java/) - v4.1.2
* [chunk](http://www.x5software.com/chunk/) - v3.5.0
* [HtmlFlow](https://github.com/xmlet/HtmlFlow/) - v3.5
* [Trimou](http://trimou.org/) - v2.5.0.Final
* [Rocker](https://github.com/fizzed/rocker/) - v1.2.1
* [Ickenham](https://github.com/enpassant/ickenham) - v1.4.1
* [Rythm](http://rythmengine.org/) - v1.3.0
* [Groovy Templates](https://groovy.apache.org/) - v2.5.6
* [Liqp - Jekyll](https://github.com/bkiers/Liqp) - v0.7.9
* [kolinx.html](https://github.com/Kotlin/kotlinx.html) - v7.1

## Build and run
You need Java 8 and Maven 3 to build and run this project.
Build the project with

    mvn package

Run the project with

    mvn spring-boot:run

See the demo URLs:

  - http://localhost:8080/jsp or http://localhost:8080/
  - http://localhost:8080/freemarker
  - http://localhost:8080/velocity
  - http://localhost:8080/thymeleaf
  - http://localhost:8080/jade
  - http://localhost:8080/scalate
  - http://localhost:8080/mustache
  - http://localhost:8080/pebble
  - http://localhost:8080/handlebars
  - http://localhost:8080/httl  
  - http://localhost:8080/chunk
  - http://localhost:8080/htmlFlow
  - http://localhost:8080/trimou
  - http://localhost:8080/rocker
  - http://localhost:8080/ickenham
  - http://localhost:8080/rythm
  - http://localhost:8080/groovy
  - http://localhost:8080/liqp
  - http://localhost:8080/kotlinx

## Benchmarking

In case you want to benchmark the different template engines I would recommend using Apache HTTP server benchmarking tool or Siege an HTTP/HTTPS stress tester.
You can try any of the following URLs.

    $ ab -n 10000 -c 10 http://localhost:8080/jsp
    $ ab -n 10000 -c 10 http://localhost:8080/velocity
    $ ab -n 10000 -c 10 http://localhost:8080/freemarker
    $ ab -n 10000 -c 10 http://localhost:8080/thymeleaf
    $ ab -n 10000 -c 10 http://localhost:8080/mustache
    $ ab -n 10000 -c 10 http://localhost:8080/jade
    $ ab -n 10000 -c 10 http://localhost:8080/pebble
    $ ab -n 10000 -c 10 http://localhost:8080/handlebars
    $ ab -n 10000 -c 10 http://localhost:8080/scalate
    $ ab -n 10000 -c 10 http://localhost:8080/httl
    $ ab -n 10000 -c 10 http://localhost:8080/chunk
    $ ab -n 10000 -c 10 http://localhost:8080/htmlFlow
    $ ab -n 10000 -c 10 http://localhost:8080/trimou
    $ ab -n 10000 -c 10 http://localhost:8080/rocker
    $ ab -n 10000 -c 10 http://localhost:8080/ickenham
    $ ab -n 10000 -c 10 http://localhost:8080/rythm
    $ ab -n 10000 -c 10 http://localhost:8080/groovy
    $ ab -n 10000 -c 10 http://localhost:8080/liqp
    $ ab -n 10000 -c 10 http://localhost:8080/kotlinx

For creating the below benchmark results I used ApacheBench (version 2.4.25) with the following settings:

```
ab -n 25000 -c 25 -k http://localhost:8080/jsp
```
With 25 concurrent requests and 25.000 requests in total this resulted in the following numbers:


## Benchmarks 2018

These tests were done on a local machine with the following specs:

```
Spring-Boot: 2.1.2.RELEASE
Windows 10 (1803, build: 17134.523)
3,60 GHz Intel Core i5-8350U Quad core
java version "1.8.0_192"
Java(TM) SE Runtime Environment (build 1.8.0_192-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.192-b12, mixed mode)
Apache Tomcat 9.0.14
```

Results in order (high to low):

Total time taken for processing 25.000 requests with a concurrency level of 25 (lower is better).

```
Jade4j                  567.7 seconds
Handlebars              147.7 seconds
Scalate - Scaml         33.33 seconds
Pebble                  27.92 seconds
HTTL                    24.61 seconds
Thymeleaf               24.09 seconds
Velocity                23.07 seconds
Freemarker              11.80 seconds
jTwig                   10.95 seconds
Mustache (JMustache)    8.836 seconds
JSP                     7.888 seconds
```

## Benchmarks 10.2019

These tests were done on a local machine with the following specs:

```
Spring-Boot: 2.1.4.RELEASE
Windows 10 (1803, build: 17134.706)
3,60 GHz Intel Core i5-8350U Quad core
java version "1.8.0_221"
Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
Apache Tomcat 9.0.17
```

Results in order (high to low):

Total time taken for processing 25.000 requests with a concurrency level of 25. (lower is better)

```
Groovy                  ~ 800 seconds
Jade4j                  684.7 seconds
Handlebars              161.8 seconds
Scalate - Scaml         34.38 seconds
Velocity                27.49 seconds
Pebble                  25.63 seconds
HTTL                    22.86 seconds
jTwig                   21.23 seconds
Liqp                    19.60 seconds
Ickenham                19.50 seconds
Thymeleaf               18.33 seconds
Rythm                   17.84 seconds
Rocker                  17.63 seconds
Mustache (JMustache)    15.75 seconds
HtmlFlow                15.62 seconds
Chunk                   15.04 seconds
Trimou                  15.02 seconds
Freemarker              14.74 seconds
JSP                     11.22 seconds
```

*Keep in mind that in the real world, these results will differ depending on the complexity of the templates, hardware, etc, so it's just an indication and if you want to know the truth you will have to run the benchmark yourself to see how such a template engine performs in your specific environment.*

Chunk produces pages with variable length. I haven't investigated it yet. ab might fail, and for Chunk use:

    $ ab -n 25000 -c 25 -l http://localhost:8080/chunk

### How were the results measured?

Before the performance of each template engines was measured, there were at least 2 dry runs with the exact same settings, to make sure that initialization of the engines, warm up of the JVM and additional caches have taken place. There were at least 5 iterations of the same benchmark before calculating the average time it took.

### For Mac OS X users

Mac OS X has only 16K ports available that won't be released until socket
TIME_WAIT is passed. The default timeout for TIME_WAIT is 15 seconds.
Consider reducing in case of available port bottleneck.

You can check whether this is a problem with netstat:

    # sysctl net.inet.tcp.msl
    net.inet.tcp.msl: 15000

Now if you want to change this you can do so by doing:

    # sudo sysctl -w net.inet.tcp.msl=1000
    net.inet.tcp.msl: 15000 -> 1000

In case you still run into problem you might want to read [this thread](http://stackoverflow.com/questions/1216267/ab-program-freezes-after-lots-of-requests-why/1217100#1217100) on ephemeral ports.

## Contributing

In case you see an improvement to the benchmark or know about ways to improve the results, please file an issue and send a pull request.
