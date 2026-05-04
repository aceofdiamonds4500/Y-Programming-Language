lexer grammar ExprLexer;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
AND : '&&' ;
OR : '|' ;
NOT : '!' ;
BECAUSE: 'because';
EQ : '=' ;

EQUIV: '==' ;
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';

COMMA : ',' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
NEEDS: '>>' ;
EXPLAIN: 'exp';
//runs libraries and executes conditionals
RUN: 'run';
//this allows for explanation bypassing, very weird and mysterious
I_SAID_SO: 'i_said_so';
TRUE: 'True';
FALSE: 'False';
REPEAT: 'repeat';
UNTIL: 'until';
IF: 'if';
ELSE: 'else';

LINE_COMMENT : '~~' ~[\r\n]* -> channel(HIDDEN) ;
BLOCK_COMMENT : '~*' .*? '*~' -> channel(HIDDEN) ;

INT : [0-9]+ ;
STRING : '"' ( ESC | ~('\\' | '"') )* '"' ;
fragment ESC : '\\' ( [btnfr"\\] ) ;

ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\n\r\f]+ -> skip ;
