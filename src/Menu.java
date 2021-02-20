/*============================================================================================================================================================================================
Mastermind Game
Hitansh Bhatt, Dhruv Sharma
2nd November 2020
Java, Oxygen.3a (4.7.3a)
==============================================================================================================================================================================================
Problem Definition – Required to create a game that performs the following functions:
(i) Allow the user to guess the code set by AI 
(ii) Allows the user to set a code that will be guessed by the AI
And additionally:
(1) Provide three options of difficulties
(2) Read and write to/from files

Input –(i) Guesses based on the difficulty (If easy: 10 guesses, medium: 8 guesses, hard:6 guesses)
(ii) The code set by the user

Output – (i) The guesses made by the user 
(ii) User friendly prompts 
(iii) The code set by the computer 

(1) Use try/catch to check user input
Process – Use and apply the logic of the Mastermind game along with the use of java skills learnt in class in order to create an efficient and logical program
==============================================================================================================================================================================================
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Menu {

	/**main method
	 * This procedural method is called automatically and is used to organize the calling of other classes defined in the project
	 *
	 * List of local variables:
	 * (5) option - a variable to store type of gameplay chosen by the user <type String>
	 * (6) br - a BufferedReader object to read user input <type BufferedReader>
	 * (7) name - a variable used to store the name of the user/player <type String>
	 * @param args <type string>
	 * @throws IO Exception
	 * @return void
	 */
	public static void main(String[] args)throws IOException{
		String option;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Welcome to Mastermind!");
		System.out.println();
		System.out.println("Please enter your name");
		String name = br.readLine();
		System.out.println("Do you want to be the:");
		System.out.println("1. Codebreaker"+"\t"+"2. Codemaker ");
		option = myScanner.next();
		do {
			if (option.equalsIgnoreCase("Codebreaker") || option.equalsIgnoreCase("1"))		//calls Player vs AI
			{
				PlayerVsAI.Main(args, name);
			}
			else if (option.equalsIgnoreCase("Codemaker") || option.equalsIgnoreCase("2"))	//calls AI vs Player
			{
				AIvsPlayer.main(args);
			}
			else {
				System.out.println("Please enter a valid gamemode. ");
			}

		}
		while(option.equalsIgnoreCase("codemaker") || option.equalsIgnoreCase("codebreaker"));
	}	// end of main method
} //end of Menu class
