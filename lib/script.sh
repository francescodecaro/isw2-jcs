mkdir -p target/jacoco-gen/jcs-coverage/
java -jar /Users/francesco/Documents/UNIVERSITA/ISW2/isw2-jcs/lib/jacoco-0.8.5/lib/jacococli.jar report target/jacoco.exec --classfiles /Users/francesco/Documents/UNIVERSITA/ISW2/isw2-jcs/lib/jcs-1.3.jar --sourcefiles /Users/francesco/Documents/UNIVERSITA/ISW2/isw2-jcs/lib/jcs-1.3 --html target/jacoco-gen/jcs-coverage/ --xml target/jacoco-gen/jcs-coverage/file.xml --csv target/jacoco-gen/jcs-coverage/file.csv