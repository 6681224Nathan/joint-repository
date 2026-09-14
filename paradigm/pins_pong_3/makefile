MAIN = pins_pong_3.Main

.PHONY: all compile run clean

all: compile

# -d .. writes .class files into ../pins_pong_3/ (i.e. right here),
# which is where the `pins_pong_3` package must live.
compile:
	javac -d .. *.java

# The classpath root is the PARENT dir, because every file declares
# `package pins_pong_3;`. Plain `java Main` can never work.
run: compile
	java -cp .. $(MAIN)

clean:
	rm -f *.class
