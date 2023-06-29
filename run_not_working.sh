#!/bin/sh
./gradlew generate
cd generated || exit
native-image --no-fallback --initialize-at-run-time=org.example.ContantValue org.example.ContantValue
./org.example.contantvalue