/*Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.

Examples : The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
“The quick brown fox jumps over the dog” is not a Pangram [Doesn’t contains all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]
*/
import java.util.*;

class Solution{

	static boolean solve(String s){
		String str = s.toLowerCase();
		int index[] = new int[26];

		for(int i = 0; i<str.length(); i++)
			index[str.charAt(i)-97]++;

		for(int i = 0; i<26; i++)
			if(index[i] == 0)
				return false;
		return true;	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		sc.close();

		System.out.println(solve(str)?"String is Panagram" : "String is not a panagram");
	}
}