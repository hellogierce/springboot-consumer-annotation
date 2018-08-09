#!/bin/sh
#
#
APP_DIR=/app/sztapp/ccbFront
APP_NAME=ccbFront

#set java home
export JAVA_HOME=/usr/java/jdk1.8.0_152

tpid1=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
echo tpid1-$tpid1
    if [[ $tpid1 ]]; then
    echo 'Stop Process...'
    kill -15 $tpid1
fi
sleep 5
tpid2=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
    echo tpid2-$tpid2
if [[ $tpid2 ]]; then
    echo 'Kill Process!'
    kill -9 $tpid2
else
    echo 'Stop Success!'
fi



