#!/bin/sh
#
# Install driver
#

#-----------------------------------------------
# script
#-----------------------------------------------
cd /home/root/driver

smart install *.rpm

rm -rf /home/root/driver
rm -f /home/root/install_driver.sh

