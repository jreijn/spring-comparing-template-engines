
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 10:17:48 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1047-azure", arch: "amd64", family: "unix"
```
|Engine Name | Seconds|
|------------|--------|
|jsp | 5.124|
|velocity | 3.542|
|freemarker | 3.489|
|thymeleaf | 7.908|
|mustache | 3.619|
|jade | 149.716|
|pebble | 27.513|
|handlebars | 39.795|
|jtwig | |
|scalate | 8.808|
|httl | 4.914|
|chunk | 3.781|
|htmlFlow | 2.621|
|trimou | 2.769|
|rocker | 2.732|
|ickenham | 18.160|
|rythm | 3.826|
|groovy | |
|liqp | 9.421|
|kotlinx | 3.174|
```

