
     <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
     <script>
          (adsbygoogle = window.adsbygoogle || []).push({
               google_ad_client: "ca-pub-7118095690658891",
               enable_page_level_ads: true
          });
     </script>

## Spring template engine performance tests

Runs performance test(ab -q -n 1000 -c 10 http://localhost:8080/kotlinx | grep "Time taken for tests") from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 07:28:12 UTC 2021
results taken from jvm :
```
jsp Time taken for tests:   1.652 seconds
velocity Time taken for tests:   0.904 seconds
freemarker Time taken for tests:   0.864 seconds
thymeleaf Time taken for tests:   2.154 seconds
mustache Time taken for tests:   0.658 seconds
jade Time taken for tests:   19.971 seconds
pebble Time taken for tests:   3.187 seconds
handlebars Time taken for tests:   4.836 seconds
jtwig 
scalate Time taken for tests:   4.267 seconds
httl Time taken for tests:   0.606 seconds
chunk Time taken for tests:   0.527 seconds
htmlFlow Time taken for tests:   0.363 seconds
trimou Time taken for tests:   0.515 seconds
rocker Time taken for tests:   0.394 seconds
ickenham Time taken for tests:   2.142 seconds
rythm Time taken for tests:   0.939 seconds
groovy Time taken for tests:   29.681 seconds
liqp Time taken for tests:   1.708 seconds
kotlinx Time taken for tests:   0.507 seconds
```

