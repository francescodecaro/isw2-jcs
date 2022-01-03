mkdir -p target/jacoco-gen/jcs-coverage/
java -jar lib/jacococli.jar report target/jacoco.exec --classfiles lib/jcs-1.3.jar --sourcefiles lib/jcs-1.3 --html target/site/jacoco/jcs-coverage --xml target/site/jacoco/jacoco.xml
