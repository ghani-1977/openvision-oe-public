SUMMARY = "Kraven HD skin for Enigma2"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python-imaging python-subprocess python-requests python-lxml enigma2-plugin-systemplugins-mphelp"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI= "git://github.com/KravenHD/KravenHD.git file://pli.png"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/* ${sysconfdir}/*"

do_compile() {
}

do_install() {
    cp -r --preserve=mode,links ${S}/usr ${D}/
    cp -r --preserve=mode,links ${S}${sysconfdir} ${D}/
    install -m 0644 ${WORKDIR}/pli.png ${D}${datadir}/enigma2/KravenHD/
}

do_postrm_append() {
#!/bin/sh
rm -rf ${datadir}/enigma2/KravenHD
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/KravenHD
rm -rf ${libdir}/enigma2/python/Components/Converter/KravenHD*
rm -rf ${libdir}/enigma2/python/Components/Renderer/KravenHD*
echo "                                                          "
echo "              ...Skin successful removed.                 "
echo "                                                          "
}
