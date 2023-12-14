package src;
/*
*  ExceptionTP2
*/
import java.lang.Exception ;

public class ExceptionTP2 extends Exception {

	private static String message [] = {
		"Horaire invalide", // code = 0
		"Date invalide"     // code = 1
	};
	
	public ExceptionTP2(int code) {
		super(message[code]) ;
	}
	
}
