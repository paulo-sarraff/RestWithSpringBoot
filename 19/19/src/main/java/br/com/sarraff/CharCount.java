package br.com.sarraff;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

	static void countChars(String str) {
		char[] strArray = str.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }else {
                charCountMap.put(c, 1);
            }
        }
 
        //Printando valores
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

	public static void main(String[] args) {
		countChars("acdBCDabcccccDDDFFFFhhhtttpppzzz"); // {a=2, B=1, b=1, c=2, C=1, d=1, D=1}
	}
}