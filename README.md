#Comparing Template engines for Spring MVC

[![Build Status](https://travis-ci.org/jreijn/spring-comparing-template-engines.png?branch=master)](https://travis-ci.org/jreijn/spring-comparing-template-engines)

This is a demo project, which accompanied my ["Shoot-out! Template engines for the JVM"](http://www.slideshare.net/jreijn/comparing-templateenginesjvm) presentation, which shows the differences among several Java template engines in combination with Spring MVC. Template engines used in this project are:

* JSP + JSTL - v1.2
* [Freemarker](http://www.freemarker.org) - v2.3.22
* [Velocity](http://velocity.apache.org) - v1.7
* [Thymeleaf](http://www.thymeleaf.org/) - v2.1.4.RELEASE
* Mustache - Based on [JMustache](https://github.com/samskivert/jmustache) - v1.8
* [Scalate](http://scalate.fusesource.org)  - v1.7.1
* [Jade](https://github.com/neuland/jade4j) - v0.4.2
* [HTTL](http://httl.github.io/en/) - v1.0.11
* [Pebble] (http://www.mitchellbosecke.com/pebble/home) - v1.4.5


## Build and run
You need Java 7 and Maven 3 to build and run this project.
Build the project with
    
    mvn package

Run the project with

    mvn tomcat7:run

See the demo URLs:

  - http://localhost:8080/jsp
  - http://localhost:8080/freemarker
  - http://localhost:8080/velocity
  - http://localhost:8080/thymeleaf
  - http://localhost:8080/jade
  - http://localhost:8080/scalate
  - http://localhost:8080/mustache
  - http://localhost:8080/pebble
  
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


For creating the below benchmark results I used ApacheBench(Version 2.3) with the following settings:

```
ab -n 25000 -c 25 -k http://localhost:8080/jsp
```
With 25 concurrent requests and 25.000 requests in total this resulted in the following numbers:


## Benchmarks 2015

These tests were done on a local machine with the following specs:

```
Mac OS X Version 10.10.3
2,3 GHz Intel Core i7 Quad core
Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
Apache Tomcat 7.0.53 with 512M RAM
```

Results in order (high to low):

Total time taken for processing 25.000 requests with a concurrency level of 25. (lower is better)

```
Thymeleaf               3.7602 seconds
Scalate - Scaml         2.8304 seconds
Mustache (JMustache)    2.2158 seconds
Velocity                1.9958 seconds
Freemarker              1.9756 seconds
Jade4j                  1.9016 seconds
Pebble                  1.7344 seconds
JSP                     1.6888 seconds
```

*Keep in mind that in the real world, these results will differ depending on the complexity of the templates, hardware, etc, so it's just an indication and if you want to know the truth you will have to run the benchmark yourself to see how such a template engine performs in your specific environment.*

###How were the results measured?

Before the performance of each template engines was measured, there were at least 2 dry runs with the exact same settings, to make sure that initialization of the engines, warm up of the JVM and additional caches have taken place. There were at least 5 iterations of the same benchmark before calculating the average time it took.

###For Mac OSX users

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

##Contributing

In case you see an improvement to the benchmark or know about ways to improve the results, please file an issue and send a pull request.
