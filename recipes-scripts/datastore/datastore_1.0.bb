SUMMARY = "Create DataStore folder"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Ralf Grote <r.grote@c-trace.de>"
DESCRIPTION = "Create DataStore folder"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

do_install() {
	install -d ${D}/opt/DataStore
        install -d ${D}/opt/DataStore/backup
        install -d ${D}/opt/DataStore/export
        install -d ${D}/opt/DataStore/export/error
        install -d ${D}/opt/DataStore/export/send
        install -d ${D}/opt/DataStore/import
        install -d ${D}/opt/DataStore/language
        install -d ${D}/opt/DataStore/settings
        install -d ${D}/opt/DataStore/update
        install -d ${D}/opt/DataStore/working
        install -d ${D}/opt/DataStore/working/events
        install -d ${D}/opt/DataStore/working/lists
        install -d ${D}/opt/DataStore/working/logs
}

FILES_${PN} += "/opt/DataStore/*"

