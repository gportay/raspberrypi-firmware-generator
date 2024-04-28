#
# Copyright 2024 Gaël PORTAY
#           2024 Rtone
#
# SPDX-License-Identifier: LGPL-2.1-or-later
#

PREFIX ?= /usr/local

.PHONY: all
all: check

.PHONY: install
install:
	install -D -m 755 raspberrypi-firmware-generator $(DESTDIR)$(PREFIX)/lib/systemd/system-generators/raspberrypi-firmware-generator

.PHONY: uninstall
uninstall:
	rm -f $(DESTDIR)$(PREFIX)/lib/systemd/system-generators/raspberrypi-firmware-generator

.PHONY: check
check: raspberrypi-firmware-generator
	shellcheck $^
