#!/bin/bash
#set -x
ADDRESS=$1
TESTS=("$2") 

for ip in "${TESTS[@]}"; do
  result=`ab -q -n 10000 -c 100 http://$ADDRESS:8080/$ip | grep "Time taken for tests"`
  echo $ip $result
done
