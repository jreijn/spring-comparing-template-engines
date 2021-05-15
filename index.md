
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 10:42:02 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1047-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 4.727|
|velocity | 3.398|
|freemarker | 3.374|
|thymeleaf | 7.773|
|mustache | 3.627|
|jade | 159.288|
|pebble | 24.789|
|handlebars | 36.924|
|jtwig | |
|scalate | 7.810|
|httl | 4.760|
|chunk | 3.486|
|htmlFlow | 2.561|
|trimou | 2.804|
|rocker | 2.712|
|ickenham | 16.379|
|rythm | 3.722|
|groovy | 307.274|
|liqp | 10.708|
|kotlinx | 3.992|

