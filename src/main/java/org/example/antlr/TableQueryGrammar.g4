grammar TableQueryGrammar;

// Parser rules
query: createTableStatement | dropTableStatement | addRecordStatement | findRecordStatement
    | updateRecordStatement | deleteRecordStatement;

// createTable student (name: string(20), age:int);
createTableStatement: CreateTable tableName '(' columnDefinition (',' columnDefinition)* ')' ';'?;
dropTableStatement: DropTable tableName ';'?;
// addRecord (name = 'Zeyu Li', age = 12) to student;
addRecordStatement: AddRecord '(' columnAssignment  (',' columnAssignment)* ')' To tableName ';'?;
// find (name, age) from tableName Having name='Zeyu Li' and age>23;
findRecordStatement: FindRecord columnList From tableName (conditionList)? ';'? EOF;
updateRecordStatement: UpdateRecord '(' columnAssignment  (',' columnAssignment)* ')' From tableName conditionList;
deleteRecordStatement: DeleteRecord From tableName conditionList?;
conditionList: Having expression;
expression: logicalExpression;
columnList: '(' ((columnName (',' columnName)*) | '*')')';
logicalExpression
    : NOT logicalExpression
    |logicalExpression AND logicalExpression
    | logicalExpression OR logicalExpression
    | comparisonExpression;

comparisonExpression
    : columnName '=' dataValue
    | columnName '<' dataValue
    | columnName '>' dataValue
    | columnName '>=' dataValue
    | columnName '<=' dataValue
    | columnName '!=' dataValue;
///



columnDefinition: columnName ':' dataType;
columnAssignment: columnName '=' dataValue;
columnName: IDENTIFIER;
dataValue: INT_VALUE | STRING_VALUE | FlOAT_VALUE;

tableName: IDENTIFIER;

dataType: Integer | String '(' INT_VALUE ')' | Float;


// Lexer rules
CreateTable: [Cc][Rr][Ee][Aa][Tt][Ee][Tt][Aa][Bb][Ll][Ee];
DropTable: [Dd][Rr][Oo][Pp][Tt][Aa][Bb][Ll][Ee];
AddRecord: [Aa][Dd][Dd][Rr][Ee][Cc][Oo][Rr][Dd];
FindRecord: [Ff][Ii][Nn][Dd][Rr][Ee][Cc][Oo][Rr][Dd];
UpdateRecord: [Uu][Pp][Dd][Aa][Tt][Ee][Rr][Ee][Cc][Oo][Rr][Dd];
DeleteRecord: [Dd][Ee][Ll][Ee][Tt][Ee][Rr][Ee][Cc][Oo][Rr][Dd];

From: [Ff][Rr][Oo][Mm];
Having: [Hh][Aa][Vv][Ii][Nn][Gg];
To: ' '[Tt][Oo] ' ';
AND : [Aa][Nn][Dd];
OR : [Oo][Rr];
NOT : [Nn][Oo][Tt];
Integer: [Ii][Nn][Tt];
Float: [Ff][Ll][Oo][Aa][Tt];
String: [Ss][Tt][Rr][Ii][Nn][Gg];

INT_VALUE: ('+' | '-')? ('0'..'9')+ ;
FlOAT_VALUE: ('+' | '-')? (DIGIT+ '.' DIGIT* | '.' DIGIT+) ;

STRING_VALUE: '\'' ( ~'\'' )* '\'';
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
DIGIT : '0'..'9' ;

WS: [ \t\r\n]+ -> skip;


