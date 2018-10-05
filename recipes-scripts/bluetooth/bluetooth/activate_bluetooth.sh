#!/bin/sh
#
# Script for activate bluetooth
#

#-----------------------------------------------
# script
#-----------------------------------------------
cd /home/root/activate_bluetooth
cp -v bluetooth /etc/init.d/
chmod +x /etc/init.d/bluetooth

rm -rf /home/root/activate_bluetooth
rm -f /home/root/activate_bluetooth.sh

reboot

