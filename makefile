all: clean compile test junit run

compile:
	javac -Xlint:unchecked ./src/*.java -d ./bin/

test:
	javac -Xlint:unchecked ./test/*.java -d ./bin/

junit:
	javac -d bin -cp bin:./lib/junit-platform-console-standalone-1.6.0.jar ./test/*.java

run:
	java -jar ./lib/junit-platform-console-standalone-1.6.0.jar --class-path bin --scan-class-path

clean:
	rm -f ./bin/*.class
