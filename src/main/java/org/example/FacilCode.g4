grammar FacilCode;

// Regla inicial que define la estructura general de un programa.
programa             : declaraciones sentencias;

// Regla para declaraciones múltiples.
declaraciones        : declaracion+;

// Regla para una declaración, que consiste en un tipo de dato seguido de una lista de identificadores.
declaracion          : tipo_dato lista_identificadores ';';

// Regla para tipos de datos válidos.
tipo_dato            : 'int' | 'float' | 'char' | 'void';

// Regla para una lista de identificadores separados por comas.
lista_identificadores : identificador (',' identificador)*;

// Regla para identificadores. Pueden comenzar con una letra y contener letras, dígitos y guiones bajos.
IDENTIFICADOR        : [a-zA-Z] [a-zA-Z0-9_]*;

// Regla para un identificador, simplemente corresponde al token IDENTIFICADOR definido anteriormente.
identificador        : IDENTIFICADOR;

// Regla para una lista de sentencias.
sentencias           : sentencia+;

// Regla para una sentencia, puede ser una asignación, una estructura de control, un retorno, una declaración o una expresión seguida de un punto y coma.
sentencia            : asignacion
                     | estructura_control
                     | retorno
                     | declaracion
                     | expresion ';';

// Regla para una asignación, que consiste en un identificador seguido de un signo igual y una expresión.
asignacion           : identificador '=' expresion;

// Regla para una estructura de control 'if' opcionalmente seguida de 'else'.
estructura_control   : IF '(' expresion ')' bloque (ELSE bloque)?;

// Regla para un bloque de código entre llaves.
bloque               : '{' sentencias '}';

// Regla para una sentencia de retorno opcionalmente seguida de una expresión.
retorno              : RETURN expresion?;

// Regla para una expresión, que puede ser un término, una expresión seguida de un operador y otra expresión, o una expresión entre paréntesis.
expresion            : termino
                     | expresion operador expresion
                     | '(' expresion ')';

// Regla para un término, que puede ser un identificador, un número o una expresión entre paréntesis.
termino              : identificador
                     | numero
                     | '(' expresion ')';

// Regla para un número, que puede ser un entero o un decimal.
numero               : entero | decimal;

// Regla para un entero, que consiste en uno o más dígitos.
entero               : DIGITO+;

// Regla para un decimal, que consiste en uno o más dígitos seguidos de un punto y luego uno o más dígitos.
decimal              : DIGITO+ '.' DIGITO+;

// Definición de un dígito del 0 al 9.
DIGITO               : [0-9];

// Regla para operadores aritméticos y booleanos.
operador             : ADD | SUB | MUL | DIV
                     | EQ | NEQ | LT | GT | LEQ | GEQ
                     | AND | OR;

// Palabras reservadas adicionales.
IF                   : 'if';
ELSE                 : 'else';
RETURN               : 'return';
TRUE                 : 'true';
FALSE                : 'false';

// Expresiones aritméticas y booleanas.
ADD                  : '+';
SUB                  : '-';
MUL                  : '*';
DIV                  : '/';
EQ                   : '==';
NEQ                  : '!=';
LT                   : '<';
GT                   : '>';
LEQ                  : '<=';
GEQ                  : '>=';
AND                  : '&&';
OR                   : '||';

// Ignorar espacios en blanco y comentarios.
WS                   : [ \t\r\n]+ -> skip;
COMMENT              : '//' ~[\r\n]* -> skip;

// Manejo de errores.
ERROR                : . -> channel(HIDDEN);
