# JavaEnigma

An implementation of the Nazi cipher machine used during World War II.

Featuring:

+ Easy to use API
+ Configurable rotor, plugboard and reflectors
+ Unit tested
+ BSD Licenced

***

## Usage
### Basic usage
Instantiate a new machine using the __EnigmaMachineBuilder__, the builder will
prompt the user for all the required configuration returning a functioning
__EnigmaMachine__ instance.

    EnigmaMachine enigmaMachine = EnigmaMachineBuilder
                                   .addRotor1(RotorType.I)
                                   .addRotor2(RotorType.II,
                                   .addRotor3(RotorType.III)
                                   .addReflector(ReflectorType.Umkehrwalze_B)
                                   .build();

The __EnigmaMachine__ instance can encrypt a single character or process a String
of text. The __EnigmaMachine__ instance stores rotor positions so any additional
material encrypted will be enciphered using the rotor positions after the last
call to __.encrypt()__.

    enigmaMachine.encrypt("SETECASTRONOMY");

The enigma machine can only encrypt uppercase alphabetic characters, with no
spaces or punctuation. Therefore all data passed to the encryption device will
be converted to uppercase and stripped of non-compatible characters.

### Advanced usage

### Custom rotors

### TODO
+ Plugboard functionality
+ Create a way to implement custom rotors and reflectors

### Dependencies
+ TestNG
+ Mockito
***

## Implementation

***
## Thanks
Thanks to Marcin Wrzeszcz and Hugh O'Brien for the inspiration to create the
library.

## References
+ http://www.idahoquad.com/how_enigma.html
+ http://users.telenet.be/d.rijmenants/en/enigmatech.htm
+ http://theturingcentenary.files.wordpress.com/2012/06/paper-enigma-pdf.png
+ http://www.codesandciphers.org.uk/enigma/example1.htm
+ http://www.codesandciphers.org.uk/enigma/rotorspec.htm
+ https://www.youtube.com/watch?v=V4V2bpZlqx8
+ http://en.wikipedia.org/wiki/Enigma_machine
+ http://en.wikipedia.org/wiki/Enigma_rotor_details
