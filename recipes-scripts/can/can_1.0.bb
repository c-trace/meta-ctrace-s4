SUMMARY = "Start CAN"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Ralf Grote <r.grote@c-trace.de>"
DESCRIPTION = "Start CAN"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI += "file://can0"
SRC_URI += "file://can1"

do_install() {
        # /etc/rcS.d - während des Bootens ausführen
        # /etc/rc0.d - Halt (Shuts down the system)
        # /etc/rc1.d - Single-user Mode (Mode for administrative tasks)
        # /etc/rc2.d - Multi-user Mode (Does not configure network interfaces and does not export networks services)
        # /etc/rc3.d - Multi-user Mode with Networking (Starts the system normally)
        # /etc/rc4.d - Not used
        # /etc/rc5.d - Start the system normally with with GUI (As runlevel 3 + display manager)
        # /etc/rc6.d - Reboot

	install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d
        install -d ${D}${sysconfdir}/rc0.d
        install -d ${D}${sysconfdir}/rc1.d
        install -d ${D}${sysconfdir}/rc2.d
        install -d ${D}${sysconfdir}/rc3.d
        install -d ${D}${sysconfdir}/rc4.d
        install -d ${D}${sysconfdir}/rc5.d
        install -d ${D}${sysconfdir}/rc6.d


	install -m 0755 ${WORKDIR}/can0 ${D}${sysconfdir}/init.d/

        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc0.d/K30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc1.d/K30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc2.d/K30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc3.d/K30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc4.d/S30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc5.d/S30can0
        ln -sf ../init.d/can0 ${D}${sysconfdir}/rc6.d/K30can0
		
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc0.d/K35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc1.d/K35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc2.d/K35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc3.d/K35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc4.d/S35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc5.d/S35can1
        ln -sf ../init.d/can1 ${D}${sysconfdir}/rc6.d/K35can1
}

