#!/bin/sh
./gradlew generate
cd generated || exit
native-image --no-fallback org.example.ContantValue
./org.example.contantvalue