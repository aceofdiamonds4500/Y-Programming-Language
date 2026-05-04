parser grammar ExprParser;
options { tokenVocab=ExprLexer; }

program
    : stat+ exec EOF
    | exec EOF
    ;

//Any statement. 
stat
    : expl
    | ID '=' expr
    | expr
    | exec
    | loop
    | call
    | cond
    ;

//This is the explanation, it powers the predicate-like rules
expl 
    : EXPLAIN ID '(' stat ')' '{' (expl|stat)* '}'
    | BECAUSE expr NEEDS expr
    ;
//Essentially, a do-while loop
loop
    : REPEAT '{' (expl|stat)* '}' UNTIL '(' eval ')' ;

//This executes libraries like console i/o
//It ends an exec with "because I said so", because I said so
exec: RUN ID* SEMI BECAUSE I_SAID_SO;

//Calls an explanation with input
//Normally this would be handled by the interpreter
call
    : ID '(' expr(',' expr)* ')';

//if statements
cond
    : IF '(' eval ')' RUN ';'
    | IF '(' eval ')' RUN ';' ELSE 
    | IF '(' eval ')' RUN ';' ELSE cond
    ;

// Anything that a program needs for evaluation
expr
    : ID
    | INT
    | STRING
    | TRUE
    | FALSE
    | expl
    | NOT expr
    | expr AND expr
    | expr OR expr
    | expr ADD expr
    | expr SUB expr
    | expr MUL expr
    | expr DIV expr
    | call
    ;
    
//conditionals, EX x == y
eval
    : TRUE
    | FALSE
    | expr sign expr
    | expr AND expr sign expr
    | expr OR expr sign expr
    | NOT expr
    ;
sign
    : EQUIV
    | LT
    | LTE
    | GT
    | GTE
    ;parser grammar ExprParser;
options { tokenVocab=ExprLexer; }

program
    : stat+ EOF
    | exp EOF
    ;

stat
    : BECAUSE ID NEEDS expr
    | ID '=' expr
    | expr
    ;


exp : ID '(' expr (',' expr)* ')' ;

expr: ID
    | INT
    | exp
    | 'not' expr
    | expr 'and' expr
    | expr 'or' expr
    | ID ADD ID
    | ID SUB ID
    | ID MUL ID
    | ID DIV ID
    ;
