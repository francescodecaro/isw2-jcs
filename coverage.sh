#!/bin/bash
jarDir="lib"
mkdir -p "target/site/jacoco"
java -jar lib/jacococli.jar report target/jacoco.exec --classfiles lib/jcs-1.3.jar --sourcefiles lib/jcs-1.3 --html target/site/jacoco/jcs-coverage --xml target/site/jacoco/jacoco-jcs.xml --csv target/site/jacoco/jacoco.csv