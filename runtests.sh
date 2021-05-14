#!/bin/bash
set -x
git config --global user.email "action@github.com"
git config --global user.name "GitHub Action"

JVMVER=$1
TESTS=(jsp velocity freemarker thymeleaf mustache jade pebble handlebars jtwig scalate httl chunk htmlFlow trimou rocker ickenham rythm groovy liqp kotlinx)
> result-$1.txt

mvn -version
mvn -B spring-boot:run &
JPID=$!
sleep 80 # waiting for spring boot to start

for ip in "${TESTS[@]}"; do
  result=`ab -q -n 1000 -c 10 http://localhost:8080/$ip | grep "Time taken for tests"`
  echo "$ip $result" >> result-$1.txt
done
kill -9 $JPID
git config pull.rebase true
sleep $[ ( $JVMVER % 20 ) + 1 ]s


sonuc=`cat result-$1.txt`
date=`date`

#git checkout gh-pages
#git switch gh-pages
cat > index.md <<EOL

## Spring template engine performance tests

Runs performance test from [Github Actions](https://github.com/ozkanpakdil/spring-comparing-template-engines/actions) and updates here.

### Results from $date

\`\`\`
$sonuc
\`\`\`

EOL

#git add .
#git commit -m "updating the page"
#git push
#git switch master
#git push
exit 0