mkdir -p target/jacoco-gen/jcs-coverage/
java -jar lib/jacoco-0.8.5/lib/jacococli.jar report target/jacoco.exec --classfiles lib/jcs-1.3.jar --sourcefiles lib/jcs-1.3 --html target/jacoco-gen/jcs-coverage/ --xml target/jacoco-gen/jcs-coverage/file.xml --csv target/jacoco-gen/jcs-coverage/file.csv
