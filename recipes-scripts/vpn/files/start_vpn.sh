#!/bin/sh
#
# Startup script for the Sitec S4 vpn tunneling
#
# c-trace GmbH
# 02.01.2019
#

#-----------------------------------------------
# variables
#-----------------------------------------------
OPENVPN_CLIENT=openvpn
OPENVPN_CLIENT_DIR="/opt/scripts/vpn"
PARAMETER="wachendorff.vpn.c-trace.de.ovpn"
SLEEP=120

while [ true ] ; do
    interface_string=$( ifconfig | grep '^tun0' | cut -c 1-4 )
    if [ -n "$interface_string" ]; then
        # echo "vpn is running"
    else
        echo "vpn is not running. Start..."

        kill_string=$( ps | grep '$OPENVPN_CLIENT' | grep -v grep | cut -c 1-5 | sed "s/ //g" )
        if [ -n "$kill_string" ]; then
            kill -9 $kill_string
            sleep 10
        fi

        cd $OPENVPN_CLIENT_DIR
        $OPENVPN_CLIENT $PARAMETER &
    fi

    sleep $SLEEP
done
