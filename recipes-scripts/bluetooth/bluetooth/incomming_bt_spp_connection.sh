#!/bin/sh
#
# Script for an incomming bluetooth SPP connection
#
# c-trace GmbH / Ralf Grote
# 22.03.2018
#
#-----------------------------------------------
# variables
#-----------------------------------------------

#Check, if remote connection is up and working
#=============================================
echo "Check if bluetooth connection is working."

# Start BT Serial Port Service 
sdptool add SP

# endless loop
while [ true ]
do
     rfcomm listen /dev/rfcomm1 1
     echo "Try to reconnect BT  ..."
     cd /opt
     if [ -e disconnect ]; then
         rm disconnect
     fi
     echo " " > disconnect
done
