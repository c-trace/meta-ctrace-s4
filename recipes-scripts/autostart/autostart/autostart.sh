#!/bin/sh

# Script to mount the first partition of an usbstick and extracting the inital setup files.
# Author : Michael Richter
# Copyright TODO


#### Global Vars / Config ####
scriptDir="/home/root/"             #maybe replay by ${0%/*},  see https://stackoverflow.com/a/3588939
scriptName="autostart.sh"           #maybe replay by ${0##*/}, see https://stackoverflow.com/a/3588939
usbPartition="/dev/sda1"
mountPoint="/mnt/usbstick"
initSetupTarGzFile="initialsetup.tar.gz"
extractTargetPath="/"


#### Locals ####
retTar=1
retTouch=1
retMv=1

#### Functions ####
errorecho()
{
    errorstring="$1"
    echo "[${0##*/}] ERROR: $errorstring" >&2
}

myecho()
{
    msg="$1"
    echo "[${0##*/}] $msg"
}

umountusb()
{
    myecho "Unmounting $mountPoint."
    umount $mountPoint
    
    if [ $? -eq 0 ]
    then 
        myecho "Unmounting $mountPoint succeed."
        return 0
    else
        errorecho "Unmounting $mountPoint failed."
        return 1
    fi
}


#### MAIN ####
myecho "Searching for first partition of usbstick ($usbPartition)"
while [ ! -e $usbPartition ]; do
    sleep 1
    continue;
done

mkdir -p $mountPoint

myecho "Mounting first partition of usbstick $usbPartition to $mountPoint :"
mount -t auto -o ro $usbPartition $mountPoint

if [ -f $mountPoint/$initSetupTarGzFile ]
then
    myecho "Extracting initial setup files to the target:"
    tar -vxf $mountPoint/$initSetupTarGzFile -C $extractTargetPath
    retTar=$?
    myecho "Running sync (may take some time)."
    sync
else
    errorecho "No initial setup files on the usbstick found!"
    
    umountusb
    
    exit 1
fi

#check for command tar succeed
if [ $retTar -eq 0 ]
then
    myecho "Initial setup files successfully exctracted."
 
    #move/rename 'path to script/name of script' to 'path to script/_name of script'
    #mv $scriptDir/$scriptName $scriptDir/_$scriptName
    #retMv=$?
    
    myecho "Deleting $scriptDir/$scriptName"
    rm -f $scriptDir/$scriptName
    retMv=$?
else
    errorecho "Extraction of initial setup files failed!"
    
    umountusb
    
    exit 1
fi
    
#check for command touch succeed
if [ $retMv -eq 0 ]
then
    if umountusb
    then
        myecho "Finished."
    else
        myecho "Failed."
    fi
else
    errorecho "Initial setup not correctly finished!"
    
    umountusb
    
    exit 1
fi
