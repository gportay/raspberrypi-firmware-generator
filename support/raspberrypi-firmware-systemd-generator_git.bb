LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

SRC_URI = "git://github.com/gportay/raspberrypi-firmware-systemd-generator.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "7273665506b23c950a9c1855e9c7521ae1fb5848"

S = "${WORKDIR}/git"

inherit systemd

do_configure () {
	:
}

do_compile () {
	:
}

do_install () {
	install -D ${S}/raspberrypi-firmware-generator ${D}${libdir}/systemd/system-generators/raspberrypi-firmware-generator
}

FILES:${PN} += "${libdir}/system/systemd-generators/raspberrypi-firmware-generator"
