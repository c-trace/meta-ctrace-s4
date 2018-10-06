#!/bin/sh
#
# Check script for the ignition state 
#
# c-trace GmbH / Sergej Knauer
# 14.03.2018
#

#-----------------------------------------------
# script
#-----------------------------------------------
while [ true ]
do
    for i in {1..60}
    do
        sleep 1
        IGN=$( cat /sys/class/gpio/gpio90/value)
        if [ $IGN -eq 0 ]; then 
            break
        fi
    done

    if [ $IGN -eq 1 ]; then
        echo "Shutdown the system"	
        shutdown -h now
    fi
done

