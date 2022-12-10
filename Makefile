all:
	javac -d bin JavaQuest.java
	java -cp bin JavaQuest
clean:
	rm bin/*.class