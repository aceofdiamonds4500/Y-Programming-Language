# Y-Programming-Language
The Y Programming Language, with a lexer made in ANTLR.

### Current Example That Compiles
tester.y
```
because x >> 2
because y >> 3

~~add = x + y
~*
sub = x - y
mul = x * y
div = x / y
*~

exp add_2(x = x + 2){
    because x >> in ~~console input
    exp add_1(x = x + 1){
        because x >> 2
    }
    because z >> "\n"
    because z >> out
    because x >> out ~~console output
}

~~almost successful fibonacci sequence
exp fib(x = x + y){
   if(x < 2) run;
      because fib(x) >> x - 1
      because fib(y) >> x - 2
}

loop_int = 1  ~~loop conditional
repeat{
  because loop_int >> out
} until (loop_int == 5)

add_2(4)

~~libraries are installed at the end of the program
run console_in console_out;
    because i_said_so
```
