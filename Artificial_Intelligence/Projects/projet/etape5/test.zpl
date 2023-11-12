var x1 integer >= 0 ;
var x2 integer >= 0 ;

maximize res : (17 * x1) + (12 * x2) ;

subto c1 : (10 * x1) + (7 * x2) <= 40 ;

subto c2 : x1 + x2 <= 5 ;

