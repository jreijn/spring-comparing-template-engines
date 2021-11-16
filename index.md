
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Tue Nov 16 01:01:07 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /usr/share/apache-maven-3.8.3
Java version: 11.0.13, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/11.0.13/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.11.0-1020-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 6.360|
|velocity | 4.997|
|freemarker | 4.905|
|thymeleaf | 10.637|
|mustache | 5.460|
|jade | 213.605|
|pebble | 6.445|
|handlebars | 26.069|
|jtwig | 10.264|
|scalate | 12.947|
|httl | 6.820|
|chunk | 6.547|
|htmlFlow | 5.580|
|trimou | 5.337|
|rocker | 5.288|
|ickenham | 8.171|
|rythm | 6.611|
|groovy | 1255.500|
|liqp | 11.015|
|kotlinx | 5.363|

If you are planning to use any template engine from the list, choose wisely, lowest is the best performance.

<div id="disqus_thread"></div>
<script type="text/javascript">
    /* * * CONFIGURATION VARIABLES * * */
    var disqus_shortname = 'ozkanpakdil';
    
    /* * * DON'T EDIT BELOW THIS LINE * * */
    (function() {
        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();
</script>

