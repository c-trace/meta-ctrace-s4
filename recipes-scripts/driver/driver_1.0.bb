SUMMARY = "Driver"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Ralf Grote <r.grote@c-trace.de>"
DESCRIPTION = "Driver"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI += "file://*.rpm"
SRC_URI += "file://install_driver.sh"

do_install() {
        install -d ${D}/home/root/driver
        install -m 0755 ${WORKDIR}/*.rpm ${D}/home/root/driver

        install -m 0755 ${WORKDIR}/install_driver.sh ${D}/home/root

        install -d ${D}${sysconfdir}
        install -m 0755 ${WORKDIR}/modules ${D}${sysconfdir}
}

FILES_${PN} += "/home/root/*"
FILES_${PN} += "/home/root/driver/*"
FILES_${PN} += "${sysconfdir}/*"

