package br.com.sarraff;

import java.util.Scanner;

public class Palindromo {
	public static void main (String[] args) {

        String o, r = "";
        Scanner in = new Scanner(System.in);

        System.out.print("Palavra a verificar > ");

        o = in.nextLine();

        if(ehpalindromo(o.toLowerCase())) {
        	System.out.println("A palavra "+o+" é um palíndromo!");
        	
        }else {
        	System.out.println("A palavra "+o+" não é um palíndromo!");
        }
    }
	
	static boolean ehpalindromo(String o) {
		int l = o.length();
        int i = 0;
        int j = l - 1;
        
        while (i < j) {
            if (o.charAt(i) != o.charAt(j)) {
            	return false;
            }
            
            i++;
            j--;
        }
        return true;
	}
}
