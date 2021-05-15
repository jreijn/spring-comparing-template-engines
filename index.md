
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 1000 -c 10 http://localhost:8080/) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 08:45:37 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1047-azure", arch: "amd64", family: "unix"
```
jsp Time taken for tests:   1.610 seconds
velocity Time taken for tests:   0.937 seconds
freemarker Time taken for tests:   0.815 seconds
thymeleaf Time taken for tests:   2.051 seconds
mustache Time taken for tests:   0.610 seconds
jade Time taken for tests:   20.570 seconds
pebble Time taken for tests:   3.270 seconds
handlebars Time taken for tests:   4.774 seconds
jtwig 
scalate Time taken for tests:   4.312 seconds
httl Time taken for tests:   0.598 seconds
chunk Time taken for tests:   0.509 seconds
htmlFlow Time taken for tests:   0.340 seconds
trimou Time taken for tests:   0.407 seconds
rocker Time taken for tests:   0.365 seconds
ickenham Time taken for tests:   2.154 seconds
rythm Time taken for tests:   0.908 seconds
groovy Time taken for tests:   29.185 seconds
liqp Time taken for tests:   1.894 seconds
kotlinx Time taken for tests:   0.576 seconds
```

