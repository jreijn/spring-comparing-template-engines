
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
         google_ad_client: "ca-pub-7118095690658891",
         enable_page_level_ads: true
    });
</script>

## Spring template engine performance tests

Runs performance test(ab -q -n 1000 -c 10 http://localhost:8080/kotlinx) from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from Sat May 15 08:09:18 UTC 2021
results taken from jvm :
```
jsp Time taken for tests:   1.455 seconds
velocity Time taken for tests:   0.869 seconds
freemarker Time taken for tests:   0.770 seconds
thymeleaf Time taken for tests:   1.828 seconds
mustache Time taken for tests:   0.593 seconds
jade Time taken for tests:   15.258 seconds
pebble Time taken for tests:   2.839 seconds
handlebars Time taken for tests:   4.223 seconds
jtwig 
scalate Time taken for tests:   3.784 seconds
httl Time taken for tests:   0.557 seconds
chunk Time taken for tests:   0.474 seconds
htmlFlow Time taken for tests:   0.290 seconds
trimou Time taken for tests:   0.405 seconds
rocker Time taken for tests:   0.351 seconds
ickenham Time taken for tests:   1.908 seconds
rythm Time taken for tests:   0.787 seconds
groovy Time taken for tests:   25.372 seconds
liqp Time taken for tests:   1.574 seconds
kotlinx Time taken for tests:   0.388 seconds
```

