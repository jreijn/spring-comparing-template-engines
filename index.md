
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 10000 -c 10 http://localhost:8080/TEMPLATE) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat Jun 12 11:04:04 UTC 2021
results taken from mvn and jvm :Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /usr/share/apache-maven-3.8.1
Java version: 16.0.1, vendor: Azul Systems, Inc., runtime: /opt/hostedtoolcache/jdk/16.0.1/x64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.8.0-1033-azure", arch: "amd64", family: "unix"

|Engine Name | Seconds|
|------------|--------|
|jsp | 4.586|
|velocity | 3.207|
|freemarker | 3.133|
|thymeleaf | 7.145|
|mustache | 3.298|
|jade | 137.775|
|pebble | 25.898|
|handlebars | 17.371|
|jtwig | |
|scalate | 7.785|
|httl | 3.442|
|chunk | 3.368|
|htmlFlow | 2.335|
|trimou | 2.642|
|rocker | 2.473|
|ickenham | 16.750|
|rythm | 3.449|
|groovy | 853.091|
|liqp | 9.462|
|kotlinx | 3.262|

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

