SUMMARY = "udpxy"
MAINTAINER = "Pavel V. Cherenkov"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://README;md5=f210c6f38d8c7db12fdfd009dcd9438c"

inherit gitpkgv autotools-brokensep pkgconfig update-rc.d

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

SRC_URI = "git://github.com/pcherenkov/udpxy.git file://udpxy.sh"
CFLAGS_append = " -Wno-format-truncation -Wno-error=stringop-truncation "

S = "${WORKDIR}/git/chipmunk"

FILES_${PN} = "${bindir}/* ${sysconfdir}/init.d/udpxy.sh"

do_compile() {
    make -f Makefile udpxy
}

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/udpxy.sh ${D}${sysconfdir}/init.d/
    install -d ${D}${bindir}
    install -m 755 ${S}/udpxy ${D}${bindir}
}

INITSCRIPT_NAME = "udpxy.sh"
INITSCRIPT_PARAMS = "defaults"

