package brailleq;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random; 
import java.util.ArrayList;
	
public class braille {
	
	
	
	public static void main(String[] args) {
		
		learn bl = new learn();
		Map<String, String> hm = bl.language();
		System.out.println("Hello! Welcome to Braille Learner. Please select from the following options:\n");
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a 1 to view Braille letter list\nEnter 2 to be quizzed on Braille Word: ");
		int n = reader.nextInt();
		
		if (n == 1) {
		
			System.out.println("Braille dots are represented as ones\n");	
		for (Map.Entry<String, String> entry : hm.entrySet()) {
			System.out.print(entry.getKey() + "\r");
			System.out.print(entry.getValue() + "\n");
		}
		} 
		
		if (n == 2) {
			System.out.println("Braille dots are represented as ones\n");	
			String rand = bl.getRandom(bl.wordList); 
			String solution = bl.getRandom(bl.letters); 
			String randomwords = bl.getRandomDict(hm, rand);
			String wordsolution = bl.wordSolution(hm, rand); 
			System.out.print("What would be the translation for the word " + rand + " in Braille?"  + "\r");
			for (String s: bl.letters) {           
		        //Do your stuff here
		        System.out.println(s); 
		        if (s != solution) {
		        System.out.println(randomwords); 
		        }
		        else {
		        	System.out.println(wordsolution); 
		        	
		        }
		        
		    }
			
			Scanner answer = new Scanner(System.in); 
			System.out.print("Enter answer as A/B/C: ");
			String x = answer.nextLine();
			reader.close();
			if (x == solution) {
				System.out.println("\n");
				System.out.println("You got it correct!");
				System.out.println("Solution is: " + solution); 
			}
			else {
				System.out.println("\n");
				System.out.println("Sorry wrong answer!"); 
				System.out.println("Correct answer is: " + solution); 
				
			}
			
		}
		
	}
}

		
class learn{
		
	public Map<String, String> language() {
		Map<String, String> language = new HashMap<String, String>();
		language.put("a", "10\n00\n00\n");
		language.put("b", "10\n10\n00\n");
		language.put("c", "11\n00\n00\n");
		language.put("d", "11\n01\n00\n");
		language.put("e", "10\n01\n00\n");
		language.put("f", "11\n10\n00\n");
		language.put("g", "11\n11\n00\n");
		language.put("h", "10\n11\n00\n");
		language.put("i", "01\n10\n00\n");
		language.put("j", "01\n11\n00\n");
		language.put("k", "10\n00\n10\n");
		language.put("l", "10\n10\n10\n");
		language.put("m", "11\n00\n10\n");
		language.put("n", "11\n01\n10\n");
		language.put("o", "10\n01\n10\n");
		language.put("p", "11\n10\n10\n");
		language.put("q", "11\n11\n10\n");
		language.put("r", "10\n11\n10\n");
		language.put("s", "01\n10\n10\n");
		language.put("t", "01\n11\n10\n");
		language.put("u", "10\n00\n11\n");
		language.put("v", "10\n10\n11\n");
		language.put("w", "01\n11\n01\n");
		language.put("x", "11\n00\n11\n");
		language.put("y", "11\n01\n11\n");
		language.put("z", "10\n01\n11\n");
	
		return language; 
		
	}
	
	public String[] wordList = {"cat", "dog", "hello", "car", "piano", "sweet", "bye", "cow", "zebra"};
	public String[] letters = {"A", "B", "C"};
	
	public String getRandom(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
	public String getRandomDict(Map<String, String> brailleDict, String word) {
		String letters = "";  
		for (int i = 0; i < word.length(); i++) { 
		Random generator = new Random();
		Object[] values = brailleDict.values().toArray();
		String randomValue = (String) values[generator.nextInt(values.length)];
	
		letters += randomValue; 
		letters += "\n";
		}
		return letters;
	}
	
	public String wordSolution(Map<String, String> brailleDict, String word) {
		String letters = "";  
		String[] wordList = word.split("(?!^)");
	
		for (String s: wordList) { 
		
			
			letters += brailleDict.get(s); 
			letters += "\n";
		
		}
		return letters;
	}
	

}
