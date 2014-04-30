#Comparing Template engines for Spring MVC

[![Build Status](https://travis-ci.org/jreijn/spring-comparing-template-engines.png?branch=master)](https://travis-ci.org/jreijn/spring-comparing-template-engines)

This is a demo project to show the differences among several Java template engines in combination with Spring MVC. Template engines used in this project are:

* JSP + JSTL - v1.2
* [Freemarker](http://www.freemarker.org) - v2.3.19
* [Velocity](http://velocity.apache.org) - v1.7
* [Thymeleaf](http://www.thymeleaf.org/) - v2.1.2.RELEASE
* Mustache - Based on [JMustache](https://github.com/samskivert/jmustache) - v1.8
* [Scalate](http://scalate.fusesource.org)  - v1.6.1
* [Jade](https://github.com/neuland/jade4j) - v0.4.0
* [Rythm](http://rythmengine.org/) - v1.4.0
* [HTTL](http://httl.github.io/en/) - v1.0.11


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
  - http://localhost:8080/rythm
  
## Benchmarking

In case you want to benchmark the different template engines I would recommend using Apache HTTP server benchmarking tool or Siege an HTTP/HTTPS stress tester.

    $ ab -n 10000 -c 10 http://localhost:8080/jsp
    $ ab -n 10000 -c 10 http://localhost:8080/velocity
    $ ab -n 10000 -c 10 http://localhost:8080/freemarker
    $ ab -n 10000 -c 10 http://localhost:8080/thymeleaf
    $ ab -n 10000 -c 10 http://localhost:8080/mustache
    $ ab -n 10000 -c 10 http://localhost:8080/jade

On my local machine with the following specs I did some benchmarks.

```
Mac OS X Version 10.8.5
2.53 GHz Intel Core 2 Duo
Java(TM) SE Runtime Environment (build 1.7.0_21-b12)
Tomcat 7.0.41 with 512M RAM
```

For creating my benchmarks I used ApacheBench, Version 2.3 <$Revision: 1430300 $> with the following settings:

```
ab -n 25000 -c 25 http://localhost:8080/jsp
```
With 25 concurrent requests and 25.000 requests in total this resulted in the following numbers:

```
Thymeleaf				21.8436 seconds
Jade4j					13.7044 seconds
Scalate - Scaml			12.1704 seconds
Mustache (JMustache)	8.8148 seconds
Freemarker				8.5574 seconds
Velocity				8.5052 seconds
JSP						8.8278 seconds
						
```

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

In case you see an improvement to the benchmark or know about ways to improve the results, please file an issue and send a pull request.
