// mind you, this has a lot of example code
lexer grammar ExprLexer;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
AND : 'and' ;
OR : 'or' ;
NOT : 'not' ;
BECAUSE: 'because';
EQ : '=' ;
COMMA : ',' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
NEEDS: '>>' ;

INT : [0-9]+ ;
ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\n\r\f]+ -> skip ;
