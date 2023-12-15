#!/bin/bash
#set -x
ADDRESS=$1
#TESTS=($2)
TESTS=(jsp jstachio velocity freemarker thymeleaf mustache jade pebble handlebars scalate httl chunk htmlFlow trimou rocker ickenham rythm groovy liqp)
for ip in "${TESTS[@]}"; do
  # We use -k keepalive to save on ports and because the realworld keep alive happens
  # especially with HTML since it usually is browsers that read that
  result=`ab -q -n 10000 -c 25 -k http://$ADDRESS:8080/$ip | grep "Time taken for tests"`
  echo $ip $result
  # We sleep a little to allow GCing of previous test
  sleep 5
done
