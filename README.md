java-maze
=========

# About

Couldn't help to do a quick-terminal only port of js-maze to Java.

# Build

javac -cp src/ -d lib/ src/net/caballorenoir/maze/main.java 

# Run

java -cp lib/ net.caballorenoir.maze.main WIDTH HEIGHT

# Create JAR file.

After building:
	jar cfv maze.jar lib
	jar cfm maze.jar manifest.txt

# Run JAR file.

java -jar maze.jar

