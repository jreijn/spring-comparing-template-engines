
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 15:01:29 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1047-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 5.765|
|velocity | 4.337|
|freemarker | 4.267|
|thymeleaf | 9.730|
|mustache | 4.558|
|jade | 195.747|
|pebble | 31.708|
|handlebars | 45.285|
|jtwig | |
|scalate | 9.505|
|httl | 5.553|
|chunk | 4.019|
|htmlFlow | 2.897|
|trimou | 3.268|
|rocker | 3.166|
|ickenham | 20.402|
|rythm | 4.300|
|groovy | 313.453|
|liqp | 12.324|
|kotlinx | 4.640|

If you are planning to use any template engine from the list, choose wisely, lowest is the best performance.

<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

