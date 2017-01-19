package DynamicProgramming;

import java.util.ArrayList;

// Practicing basic recursion before starting backtracking.
public class Test {

	public static void main(String[] args) {
		String t = removeVowels("hellho");
		System.out.println(t);
	}

	//number of times that the character ch appears in the string s
	static int numOccur(Character ch, String s) {
		int sum = 0;
		if (s == "")
			return sum;
		if (s.charAt(0) == ch)
			sum++;
		if (s.length() == 1)
			return sum;
		return sum + numOccur(ch, s.substring(1));
	}
	
	//
	static String removeVowels(String s) {
		ArrayList<Character> arrayList = new ArrayList<Character>();
		arrayList.add('a');
		arrayList.add('e');
		arrayList.add('i');
		arrayList.add('o');
		arrayList.add('u');
		
		if (s == null || s.length() == 0)
			return "";
		if (!arrayList.contains(s.charAt(0)))
			return s.charAt(0) + removeVowels(s.substring(1));
		if (s.length() > 0)
			return removeVowels(s.substring(1));
		else
			return "";
	}
}
