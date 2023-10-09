grammar hello;
@header{
    package: com.example.gen.hello;
}

s: 'hello' ID ;
ID: [a-z]+;
WS :[\t\r\n]+ -> skip;