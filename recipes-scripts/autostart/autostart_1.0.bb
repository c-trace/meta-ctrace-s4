SUMMARY = "Autostart Script"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Michael Richter <m.richter@c-trace.de>"
DESCRIPTION = "Autostart Script"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI += "file://autostart"
SRC_URI += "file://autostart.sh"

do_install() {
        # /etc/rcS.d - während des Bootens ausführen

        install -d ${D}${sysconfdir}/rcS.d

        install -m 0755 ${WORKDIR}/autostart ${D}${sysconfdir}/init.d/

        ln -sf ../init.d/autostart ${D}${sysconfdir}/rcS.d/S90autostart

        install -d ${D}/home/root
        install -m 0755 ${WORKDIR}/autostart.sh ${D}/home/root/
}

FILES_${PN} += "/home/root/*"

