#Comparing Spring MVC Template engines

This is a demo project to show the differences among several Java template engines in combination with Spring MVC. Template engines used in this project are:

* JSP + JSTL - v1.2
* [Freemarker](http://www.freemarker.org) - v2.3.19
* [Velocity](http://velocity.apache.org) - v1.7
* [Thymeleaf](http://www.thymeleaf.org/) - v2.1.0.RELEASE
* Mustache - Based on [JMustache](https://github.com/samskivert/jmustache) - v1.8
* [Scalate](http://scalate.fusesource.org)  - v1.6.1
* [Jade](https://github.com/neuland/jade4j) - v0.3.17
* [Rythm](http://rythmengine.org/) - v1.4.0
* [HTTL] (http://httl.github.io/en/) - v1.0.11


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

    $ ab -n 10000 -c 4 http://localhost:8080/jsp
    $ ab -n 10000 -c 4 http://localhost:8080/velocity
    $ ab -n 10000 -c 4 http://localhost:8080/freemarker
    $ ab -n 10000 -c 4 http://localhost:8080/thymeleaf
    $ ab -n 10000 -c 4 http://localhost:8080/mustache
    $ ab -n 10000 -c 4 http://localhost:8080/jade

Or:

    $ siege -b -r 2500 -c 4 http://localhost:8080/jsp
    $ siege -b -r 2500 -c 4 http://localhost:8080/velocity
    $ siege -b -r 2500 -c 4 http://localhost:8080/freemarker
    $ siege -b -r 2500 -c 4 http://localhost:8080/thymeleaf
    $ siege -b -r 2500 -c 4 http://localhost:8080/mustache
    $ siege -b -r 2500 -c 4 http://localhost:8080/jade

On my local machine with the following specs I did some benchmarks.

```
Mac OS X Version 10.8.5
2.53 GHz Intel Core 2 Duo
Java(TM) SE Runtime Environment (build 1.7.0_21-b12)
Tomcat 7.0.41 with 512M RAM
```

For creating my benchmarks I used Siege with the following settings:

```
siege -q -b -r 1000 -c 25 http://localhost:8080/scalate
```

With 25 concurrent requests and 1000 repetitions this resulted in the following numbers:

```
Thymeleaf				28.47 seconds
Jade4j					19.55 seconds
Scalate - Scaml			46.66 seconds
Mustache (JMustache)	15.05 seconds
Freemarker				14.55 seconds
Velocity				14.56 seconds
JSP						14.35 seconds
						
```

In case you see an improvement to the benchmark or know about ways to improve the results, please file and issue and send a pull request.