SUMMARY = "LED Trigger"
HOMEPAGE = "http://www.c-trace.de"
MAINTAINER = "Ralf Grote <r.grote@c-trace.de>"
DESCRIPTION = "LED Trigger"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI += "file://led"

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

        install -m 0755 ${WORKDIR}/led ${D}${sysconfdir}/init.d/

        ln -sf ../init.d/led ${D}${sysconfdir}/rc0.d/K10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc1.d/K10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc2.d/K10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc3.d/K10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc4.d/S10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc5.d/S10led
        ln -sf ../init.d/led ${D}${sysconfdir}/rc6.d/K10led
}

