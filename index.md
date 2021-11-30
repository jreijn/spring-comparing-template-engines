
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Tue Nov 30 09:20:06 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: /usr/share/apache-maven-3.8.4
Java version: 11.0.13, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/11.0.13/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.11.0-1021-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 4.753|
|velocity | 3.406|
|freemarker | 3.364|
|thymeleaf | 7.097|
|mustache | 3.557|
|jade | 122.553|
|pebble | 4.474|
|handlebars | 17.242|
|scalate | 7.143|
|httl | 3.981|
|chunk | 3.709|
|htmlFlow | 2.715|
|trimou | 2.932|
|rocker | 2.861|
|ickenham | 5.135|
|rythm | 3.625|
|groovy | 884.562|
|liqp | 7.956|
|kotlinx | 3.260|

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

