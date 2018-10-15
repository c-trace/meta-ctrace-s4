#!/bin/sh
#
# Check script for the digital inputs
#
# c-trace GmbH / Sergej Knauer
# 12.10.2018
#

#-----------------------------------------------
# variables
#-----------------------------------------------
SLEEP_TIME=1      # wait 1s
DIN1=$( cat /sys/class/gpio/gpio88/value)
DIN2=$( cat /sys/class/gpio/gpio85/value)
DIN3=$( cat /sys/class/gpio/gpio80/value)

#-----------------------------------------------
# script
#-----------------------------------------------
while [ true ]
do
   sleep $SLEEP_TIME
   IGN=$( cat /sys/class/gpio/gpio90/value)
   if [ $IGN -eq 1 ]; then
      continue
   fi

   TMP=$( cat /sys/class/gpio/gpio88/value)
   if [ $DIN1 -ne $TMP ]; then
      DIN1=$TMP
      if [ -e /tmp/din1 ]; then
         rm /tmp/din1
      fi
      echo " " > /tmp/din1
   fi

   TMP=$( cat /sys/class/gpio/gpio85/value)
   if [ $DIN2 -ne $TMP ]; then
      DIN2=$TMP
      if [ -e /tmp/din2 ]; then
         rm /tmp/din2
      fi
      echo " " > /tmp/din2
   fi

   TMP=$( cat /sys/class/gpio/gpio80/value)
   if [ $DIN3 -ne $TMP ]; then
      DIN3=$TMP
      if [ -e /tmp/din3 ]; then
         rm /tmp/din3
      fi
      echo " " > /tmp/din3
   fi
done

