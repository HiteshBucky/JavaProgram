import java.util.*;


/*
	Here logic is very simple fix one char from left one by one and permute the rest of the word
	till end of the string

	By Hitesh
	
*/
class test{
	public static void main(String[] args) {
		String word = "history";
		get_all_permutation(word, 0, word.length()-1);
	}

	static void get_all_permutation(String str, int left, int right) { 
		if (left == right) 
			System.out.println(str); 
		else
		{ 
			for (int i = left; i <= right; i++) 
			{ 
				str = swap(str,left,i); 
				get_all_permutation(str, left+1, right); 
				str = swap(str,left,i); 
			} 
		} 
	}

	static String swap(String word, int i, int j) { 
		char temp; 
		char[] charArray = word.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
}





