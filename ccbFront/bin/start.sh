#!/bin/sh
#
#
APP_DIR=/app/sztapp/ccbFront/
APP_NAME=ccbFront

#set java home
export JAVA_HOME=/usr/java/jdk1.8.0_152

if [ ! -d $APP_DIR"/logs/" ];then
    mkdir $APP_DIR/logs
fi

rm -f $APP_DIR/logs/tpid
nohup $JAVA_HOME/bin/java  -jar $APP_DIR/"$APP_NAME".jar > /dev/null 2>&1 &
echo $! > $APP_DIR/logs/tpid
echo "进程ID:"$!
echo Start Success!

