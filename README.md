# RPN calculator

Command-line reverse polish notation (**RPN**) calculator.

Reverse Polish notation (RPN), also known as Polish postfix notation or simply postfix notation, is a mathematical notation in which operators follow their operands, in contrast to Polish notation (PN), in which operators precede their operands. It does not need any parentheses as long as each operator has a fixed number of operands. 


## Explanation
In reverse Polish notation, the operators follow their operands; for instance, to add 3 and 4, one would write 3 4 + rather than 3 + 4. If there are multiple operations, operators are given immediately after their second operands; so the expression written 3 − 4 + 5 in conventional notation would be written 3 4 − 5 + in reverse Polish notation: 4 is first subtracted from 3, then 5 is added to it. An advantage of reverse Polish notation is that it removes the need for parentheses that are required by infix notation. While 3 − 4 × 5 can also be written 3 − (4 × 5), that means something quite different from (3 − 4) × 5. In reverse Polish notation, the former could be written 3 4 5 × −, which unambiguously means 3 (4 5 ×) − which reduces to 3 20 −; the latter could be written 3 4 − 5 × (or 5 3 4 − ×, if keeping similar formatting), which unambiguously means (3 4 −) 5 ×


## Algorithm

The following algorithm evaluates input expressions using a **stack**, with the expression processed from left to right:

    for each token in the postfix expression:
	    if token is an operator:
		    operand_2 ← pop from the stack
		    operand_1 ← pop from the stack
		    result ← evaluate token with operand_1 and operand_2
		    push result back onto the stack
	    else if token is an operand:
	    push token onto the stack
    result ← pop from the stack
    
## How To Use
To clone and run this application, you'll need Java 8(or higher), Git and Maven installed on your computer. From your command line:

>Clone this repository

	git clone https://github.com/limedition/rpn-calculator.git

>Go into the repository

	cd rpn-calculator
    
>Build

	mvn clean package
    
>Run

	java -jar target/rpn-calculator-1.0-SNAPSHOT.jar

## Example of supported formats
```
    > 5 
    5.0
    > 8
    8.0
    > +
    13.0
    > q    
```
```
    > 5 8 +
    13.0
    > q
```
```
    > 5 8 +
    13.0
    > 1
    1.0
    > +
    14.0
    > q
```
## Supported arithmetic operations/operands

 - Addition (`+`)
 - Subtraction (`-`)
 - Multiplication (`*`)
 - Division (`/`)
 
## Todos

 - Write MORE Tests
 - GUI
 - History of operations

## License

Apache License

## Resources
[wikipedia](https://en.wikipedia.org/wiki/Reverse_Polish_notation)

