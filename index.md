
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Wed Oct 13 17:17:20 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /usr/share/apache-maven-3.8.3
Java version: 17, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/17.0.0/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.8.0-1042-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 4.688|
|velocity | 3.724|
|freemarker | 3.598|
|thymeleaf | 7.901|
|mustache | 4.012|
|jade | 165.972|
|pebble | 28.619|
|handlebars | 20.798|
|jtwig | |
|scalate | 8.948|
|httl | 3.968|
|chunk | 3.828|
|htmlFlow | 2.746|
|trimou | 3.021|
|rocker | 2.917|
|ickenham | 18.843|
|rythm | 3.907|
|groovy | 1013.868|
|liqp | 8.600|
|kotlinx | 3.623|

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

