# guess-the-animal
An animal guessing game that uses binary trees and internationalization

## Usage
The serialization files can be of three different types: json, xml, and yaml.  You set this with command line arguments.  The default is json.  So for instance:
```
java Main -type xml
```

The language is set by Java VM flags.  The default in English.  Currently the only other language is [Esperanto](https://en.wikipedia.org/wiki/Esperanto). So for instance:
```
java -Duser.language=eo Main
```

## Credit
This project is from [Hyperskill](https://hyperskill.org/projects/132/).
