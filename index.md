
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Mon Nov 29 20:42:45 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: /usr/share/apache-maven-3.8.4
Java version: 11.0.13, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/11.0.13/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.11.0-1021-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 5.105|
|velocity | 4.114|
|freemarker | 4.168|
|thymeleaf | 9.194|
|mustache | 4.306|
|jade | 154.113|
|pebble | 5.384|
|handlebars | 21.775|
|scalate | 8.918|
|httl | 4.665|
|chunk | 4.387|
|htmlFlow | 3.130|
|trimou | 3.467|
|rocker | 3.447|
|ickenham | 6.120|
|rythm | 4.138|
|groovy | 1077.385|
|liqp | 9.292|
|kotlinx | 4.571|

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

