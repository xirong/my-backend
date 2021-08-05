#!/bin/bash
#Function:java analys


if [ $# -eq 1 ];then
        get_java_pid=$1
else
        echo "Need java pid!"
        exit 1
fi

if [ `whoami` != 'admin' ];then
    echo "Need user is Admin !"
    exit 2
fi

JAVA_PATH_JAVA=`ps ux | grep java | grep -v 'grep' | grep -v 'get_java' |awk '{print $11}'`
JAVA_HOME_BIN=`echo ${JAVA_PATH_JAVA%/*}`
JAVA_HOME=`echo ${JAVA_HOME_BIN%/*}`
java_hump_log=/home/admin/logs/javaJVMlog_`date "+%Y%m%d%H%M%S"`
mkdir -p ${java_hump_log}
opration_log_format="pid${get_java_pid}.`date "+%Y%m%d%H%M%S"`"

echo "----START COLLECT LOG FOR PID ${get_java_pid}----"

echo "4. get codecache..."
scp -r -p wille.liq@peconsole.et2:/home/wille.liq/mytool/jmxterm-1.0-alpha-4-uber.jar /tmp/jmxterm-1.0-alpha-4-uber.jar
jmxterm_path=/tmp/jmxterm-1.0-alpha-4-uber.jar
if [ ! -f ${jmxterm_path} ];then
    echo "No jmxterm-1.0-alpha-4-uber.jar file ,need add!!"
    #exit 1
fi
$JAVA_HOME/bin/jcmd $get_java_pid ManagementAgent.start_local >/dev/null 2>&1
result=`echo "get -d java.lang -b name=Code\ Cache,type=MemoryPool Usage" | $JAVA_HOME/bin/java -jar ${jmxterm_path} -l $get_java_pid -v silent -n`
$JAVA_HOME/bin/jcmd $get_java_pid ManagementAgent.stop >/dev/null 2>&1

committed=`echo ${result} | awk -F"=|;" '{print $3}' | sed 's/\ //g'`
     init=`echo ${result} | awk -F"=|;" '{print $5}' | sed 's/\ //g'`
      max=`echo ${result} | awk -F"=|;" '{print $7}' | sed 's/\ //g'`
     used=`echo ${result} | awk -F"=|;" '{print $9}' | sed 's/\ //g'`

let committed=$committed/1014/1024
let      init=$init/1024/1024
let       max=$max/1024/1024
let      used=$used/1024/1024
echo "committed:${committed}M, init: ${init}M, max: ${max}M, used: ${used}M" > ${java_hump_log}/codecache.${opration_log_format}


echo ""
echo "----FINISH COLLECT LOG FOR PID ${get_java_pid}----"
echo "Scan file in ${java_hump_log} "