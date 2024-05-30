# raspberrypi-firmware-systemd-generator

A systemd-generator for mounting the bootloader partitions of the Raspberry Pi
firmware.

## DESCRIPTION

The Raspberry Pi firmware supports A/B booting thanks to the optional
configuration file [autoboot.txt].

In short, the firmware loads the file [autoboot.txt] located in the first
partition; that file specifies the partition on which the bootloader files are
located ([config.txt], kernel image...). The bootloader mounts that secondary
partition and reads its files to complete its booting task.

In all, the firmware mounts two partitions if booting via the configuration
file [autoboot.txt]:
 - the first partition holds the file [autoboot.txt]
 - the other partition holds the bootloader files ([config.txt], `kernel` image
   and `cmdline`, bootloader blobs if needed...)

[raspberrypi-firmware-generator(1)] is a [systemd.generator(7)] for mounting
the bootloader partitions of the Raspberry Pi firmware.

It generates a [systemd.mount(5)] mount unit for the booted partition set by
the firmware to the device-tree blob node `/chosen/bootloader/partition`.

That secondary `boot_partition` is mounted to `/boot/firmware` as per the new
[bookworm] specifications of the [Raspberry Pi OS]. It is mounted after the
first partition; that has to be mounted first to `/boot`. It could be mounted
either by an entry in the [fstab(5)] and the [systemd-fstab-generator(8)] or by
the [systemd-gpt-auto-generator(8)] if the partition table is GPT and if the
root device is on the same device.

_Note_: [raspberrypi-firmware-generator(1)] is written in [bash(1)].

## INSTALL

Run the following command to install *raspberrypi-firmware-generator(1)*

	$ sudo make install

Traditional variables *DESTDIR* and *PREFIX* can be overridden

	$ sudo make install PREFIX=/opt/dosh

Or

	$ make install DESTDIR=$PWD/pkg PREFIX=/usr

## BUGS

Report bugs at *https://github.com/gportay/raspberrypi-firmware-systemd-generator/issues*

## AUTHOR

Written by Gaël PORTAY *gael.portay@gmail.com*

## COPYRIGHT

Copyright (c) 2024 Gaël PORTAY

This program is free software: you can redistribute it and/or modify it under
the terms of the GNU Lesser General Public License as published by the Free
Software Foundation, either version 2.1 of the License, or (at your option) any
later version.

[Raspberry Pi OS]: https://www.raspberrypi.com/software/
[autoboot.txt]: https://www.raspberrypi.com/documentation/computers/config_txt.html#autoboot-txt
[bash(1)]: https://linux.die.net/man/1/bash
[bookworm]: https://www.raspberrypi.com/documentation/computers/config_txt.html#what-is-config-txt
[config.txt]: https://www.raspberrypi.com/documentation/computers/config_txt.html
[fstab(5)]: https://linux.die.net/man/5/fstab
[raspberrypi-firmware-generator(1)]: raspberrypi-firmware-generator
[systemd-fstab-generator(8)]: https://www.freedesktop.org/software/systemd/man/latest/systemd-fstab-generator.html
[systemd-gpt-auto-generator(8)]: https://www.freedesktop.org/software/systemd/man/latest/systemd-gpt-auto-generator.html
[systemd.generator(7)]: https://www.freedesktop.org/software/systemd/man/latest/systemd.generator.html
[systemd.mount(5)]: https://www.freedesktop.org/software/systemd/man/latest/systemd.mount.html
[tryboot]: https://www.raspberrypi.com/documentation/computers/raspberry-pi.html#fail-safe-os-updates-tryboot
