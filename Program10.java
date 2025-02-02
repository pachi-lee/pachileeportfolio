import java.util.Scanner;

public class Program10 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// declaring variables
		int menu;
		int eSize = 0;
		final int size = 30;
		String[] wordList = new String[size];
		String word = "";
		boolean valid = false;

		System.out.println("Welcome to WordList!\n" + "--------------------");

		do {

			menu = getMenuChoice(stdIn);

			if (menu == 1) { // need user validation

				// word is added and valid if it contains letters and hasn't been added to array
				// yet
				do {
					System.out.print("Enter a word to add to the wordList: ");

					word = stdIn.next();
					

					// checks if word is a letter
					for (char c : word.toCharArray()) {
						if (Character.isLetter(c) && word.length() > 1)
							valid = true;
					}

				} while ((!valid) && eSize < wordList.length);

				if (addWord(wordList, eSize, word)) { // only add word if it wasn't repeated
					eSize++;
					System.out.println( word + " has been added ");
					System.out.println();


				} else {

					System.out.print("Word is already on list");
					System.out.println();

				}

			} else if (menu == 2) {
				do {
					System.out.print("Enter a word to remove from the wordList: ");
					word = stdIn.next();
				
					for (char c : word.toCharArray()) {
						if (Character.isLetter(c))
							valid = true;
					}

				} while ((!valid) && word.length() > 1 );
				if (removeWord(wordList, eSize, word)) { // match key
					eSize--;
					System.out.println( word + " has been removed ");
				}else {
					System.out.println("Word is not found in List");
				}

			} else if (menu == 3) {
				printWords(wordList, eSize);
			}
		} while (menu != 4);
		stdIn.close();
	}

	public static int getMenuChoice(Scanner stdIn) {
		int n;
		do {
			System.out.print("\n1. Add Word\n" + "2. Remove Word\n" + "3. Print Words\n" + "4. Quit"
					+ "\n Choose an option(1-4): ");
			n = stdIn.nextInt();
			System.out.println();

			if (n == 4) {
				System.out.print(" ");
			}
		} while (!(n >= 1 || n <= 4) || Character.isLetter(n));
		return n;
	}

	public static int findWord(String[] words, int numWords, String word) {
		// search if the word matches any words in the array
		for (int i = 0; i < numWords; i++)
			//if string variable need equal
			if (words[i].equals(word)) {
				return i;
			}

		return -1;
	}

	// adds the word parameter to the words array only if words does not already
	// contain it.
	// It returns true if word was added to words; false otherwise.
	public static boolean addWord(String[] words, int numWords, String word) {

		int find;

		find = findWord(words, numWords, word);
//find the word in the array 
		if (find != -1 || numWords >= 30) {
			return false;
			
		}
		words[numWords] = word;
		return true;
		
	}

	public static boolean removeWord(String[] words, int numWords, String word) {
		int locate;

		locate = findWord(words, numWords, word);
		if (locate == -1) {
			return false;
		}
		for (int i = locate; i < numWords - 1; i++) {
			words[i] = words[i + 1] ;
		}
		words[numWords - 1] = null; //deletes the last element
		return true;
		

	}

	public static void printWords(String[] words, int numWords) {
		// prints up to the filled array
if (numWords < 0) {
	System.out.println("The list is empty.");
	return;
}
		System.out.print("[");
		for (int i = 0; i < numWords; i++)
			System.out.print(words[i] + ", ");

		System.out.print("]");
		System.out.println();

	}

}
