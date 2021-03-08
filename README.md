# guess-the-animal
An animal guessing game that uses binary trees and internationalization

## Usage
The serialization files can be of three different types: JSON, XML, and YAML.  These are set this with command line arguments.  The default is JSON.  The language is set by Java VM flags.  The default in English.  Currently the only other language is [Esperanto](https://en.wikipedia.org/wiki/Esperanto).

### Gradle Console
The easiest way to launch the application is to use Gradle's `run` task with a plain console:
```
gradle --console plain run
```
This defaults to English and JSON.  To change to XML or YAML you need to use the `--args` flag, like this:
```
gradle --console plain run --args="-type xml"
```
Changing the language requires changing the `build.gradle` file.  See comments at the top of the file.

### Java Jar
The Gradle console isn't very responsive, nor very protable, so you might want to use Java jar files instead. To do this:
* copy `build-jar.gradle` to `build.gradle`
* follow the instructions in the comments of the build file

## Credit
This project is from [Hyperskill](https://hyperskill.org/projects/132/).

This project uses [Gradle Shadow](https://github.com/johnrengelman/shadow) by John Engelman
