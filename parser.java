parser grammar ExprParser;
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
