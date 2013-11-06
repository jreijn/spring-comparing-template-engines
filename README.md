#Comparing Template engines

This is a demo project to show the differences among several Java template engines in combination with Spring MVC:

* JSP + JSTL
* [Freemarker](http://www.freemarker.org) 
* [Velocity](http://velocity.apache.org)
* [Thymeleaf](http://www.thymeleaf.org/)
* Mustache - Based on [JMustache](https://github.com/samskivert/jmustache)
* [Scalate](http://scalate.fusesource.org)
* [Jade](https://github.com/neuland/jade4j)
* [Rythm](http://rythmengine.org/)

## Build and run
You need Java 7 and Maven 3 to build and run this project.
Build the project with
    
    mvn clean package

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

Or:

    $ siege -b -r 2500 -c 4 http://localhost:8080/jsp
    $ siege -b -r 2500 -c 4 http://localhost:8080/velocity
    $ siege -b -r 2500 -c 4 http://localhost:8080/freemarker
    $ siege -b -r 2500 -c 4 http://localhost:8080/thymeleaf
