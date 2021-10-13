
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Wed Oct 13 16:45:58 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /usr/share/apache-maven-3.8.3
Java version: 11.0.12, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/11.0.12/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.8.0-1042-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 5.436|
|velocity | 4.396|
|freemarker | 4.232|
|thymeleaf | 9.582|
|mustache | 4.651|
|jade | 191.245|
|pebble | 5.803|
|handlebars | 22.906|
|jtwig | 8.786|
|scalate | 11.529|
|httl | 6.308|
|chunk | 5.331|
|htmlFlow | 4.303|
|trimou | 4.369|
|rocker | 4.087|
|ickenham | 7.203|
|rythm | 5.172|
|groovy | 1130.678|
|liqp | 9.837|
|kotlinx | 4.659|

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

