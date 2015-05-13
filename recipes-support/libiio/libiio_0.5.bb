DESCRIPTION = "Analog Devices Libiio"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

SRCREV = "c273b2de99c2419e11a1d1fa25dd992e5d0d3c2b"
SRCBRANCH = "2014_R2"

# ${PV} is pulled from the recipe filename, e.g. helloworld_2.7.bb -> ${PV} expands to "2.7".
# We use immediate evaluation to define a new var PVBASE holding the original value of ${PV}.
PVBASE := "${PV}"

# We need to tell bitbake about our current directory structure or we won't be able to find patches after we mess with ${PV}
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PVBASE}:"

# Then redefine PV to tack the repository rev onto the base version. This is evaluated at fetch time.
# Then the package will get rebuilt any time the relevant part of the source tree changes.
PV = "${PVBASE}.${SRCPV}"

# Now we format the source code URI.
SRC_URI = "git://github.com/analogdevicesinc/libiio.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit autotools cmake

DEPENDS += "libxml2 bison flex ncurses avahi"

PARALLEL_MAKE = ""
