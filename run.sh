#!/bin/sh
./gradlew generate
cd generated || exit
native-image --no-fallback -H:+ReportExceptionStackTraces org.example.Main