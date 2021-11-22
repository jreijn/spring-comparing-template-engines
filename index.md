
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Mon Nov 22 21:28:09 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /usr/share/apache-maven-3.8.3
Java version: 11.0.13, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/11.0.13/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.11.0-1021-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 5.328|
|velocity | 4.135|
|freemarker | 3.852|
|thymeleaf | 8.639|
|mustache | 4.228|
|jade | 169.686|
|pebble | 5.111|
|handlebars | 20.870|
|scalate | 8.960|
|httl | 4.739|
|chunk | 4.305|
|htmlFlow | 3.185|
|trimou | 3.408|
|rocker | 3.330|
|ickenham | 5.928|
|rythm | 4.140|
|groovy | 987.361|
|liqp | 8.553|
|kotlinx | 3.953|

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

