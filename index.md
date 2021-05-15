
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 14:44:03 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1047-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 5.783|
|velocity | 4.215|
|freemarker | 4.326|
|thymeleaf | 9.905|
|mustache | 4.488|
|jade | 193.556|
|pebble | 30.972|
|handlebars | 45.314|
|jtwig | |
|scalate | 9.939|
|httl | 5.585|
|chunk | 4.226|
|htmlFlow | 3.131|
|trimou | 3.377|
|rocker | 3.210|
|ickenham | 20.597|
|rythm | 4.380|
|groovy | |
|liqp | 10.974|
|kotlinx | 4.044|

If you are planning to use any template engine from the list, choose wisely, lowest is the best performance.

