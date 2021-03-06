SUMMARY = "Bluetooth"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Ralf Grote <r.grote@c-trace.de>"
DESCRIPTION = "Bluetooth"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI += "file://*.conf"
SRC_URI += "file://*.sh"
SRC_URI += "file://bluetooth"

do_install() {
        install -d ${D}${sysconfdir}/bluetooth
        install -m 0755 ${WORKDIR}/input.conf ${D}${sysconfdir}/bluetooth
        install -m 0755 ${WORKDIR}/main.conf ${D}${sysconfdir}/bluetooth
        install -m 0755 ${WORKDIR}/network.conf ${D}${sysconfdir}/bluetooth

        install -d ${D}${sysconfdir}/scripts
        install -m 0755 ${WORKDIR}/incomming_bt_spp_connection.sh ${D}${sysconfdir}/scripts

        install -d ${D}/home/root/activate_bluetooth
        install -m 0755 ${WORKDIR}/bluetooth ${D}/home/root/activate_bluetooth
        install -m 0755 ${WORKDIR}/activate_bluetooth.sh ${D}/home/root
}

FILES_${PN} += "${sysconfdir}/*"
FILES_${PN} += "${sysconfdir}/scripts/*"
FILES_${PN} += "/home/root/*"
FILES_${PN} += "/home/root/activate_bluetooth/*"

