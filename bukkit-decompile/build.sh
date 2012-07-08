#!/bin/sh
javac -cp ../../craftbukkit-1.2.5-R4.1-MCPC-SNAPSHOT-162.jar `find . -name '*.java'`
zip -r ../extrabiomes-xl-2.2.6-bukkit.zip .
