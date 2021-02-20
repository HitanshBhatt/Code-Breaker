import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class GUI extends JFrame implements ActionListener{
	
	FlowLayout layout1 = new FlowLayout();
	GridLayout layout2;
	JPanel mainPanel;
	JFrame mainFrame;
	JLabel program, level;
	JButton easy, medium, hard;
	
	public void MainFrame()
	{
		layout2 = new GridLayout();
		mainFrame = new JFrame();
		mainFrame.setLayout(layout1);
		mainFrame.setSize(800, 800);
		mainFrame.setResizable(true);
		mainFrame.setTitle("CodeBreaker");
		
		mainPanel= new JPanel();
		
		//program = new JLabel("CodeBreaker");
		level = new JLabel("Choose your level:");
		easy = new JButton("Easy");
		medium = new JButton("Medium");
		hard = new JButton("Hard");
		
		//mainPanel.add(program);
		mainPanel.add(level);
		mainPanel.add(easy);
		mainPanel.add(medium);
		mainPanel.add(hard);
		
		
		mainFrame.add(mainPanel);
		//easy.addActionListener((ActionListener) this);
		//medium.addActionListener((ActionListener) this);
		//hard.addActionListener((ActionListener) this);
		mainFrame.setVisible(true);
		
		actionPerformed(null);
	}
	
	public void actionPerformed(ActionEvent event) {
		String name;
		if (event.getActionCommand().equals("Easy")) 
			System.out.println("button pressed");
			//introduction.setText("Welcome " + username.getText() + ", hope you have a wonderful day!");
			//codeBreakerGUI(name);
			//startUp1.setVisible(false);
			//startUp2.setVisible(false);
		}
		
	
	public static void main(String[] args) throws IOException
	{
		GUI breaker = new GUI();
		System.out.println("Hitansh");
		breaker.MainFrame();
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int turn = 1;
		int numOfGuesses=1;
		int[] userGuess = new int[4];
		int[] generateRandom = new int[4];
		String level;
		String choice;
		//System.out.println ("Welcome to Mastermind!!");
		do
		{
			int randomCode [] = generateRandomCode(generateRandom);
			System.out.println("Choose your level: ");
			System.out.println();
			System.out.println("1. Easy"+"\t"+"\t"+"2. Medium"+"\t"+"3. Hard");
			level = br.readLine();
			if (level.equalsIgnoreCase("Easy") || level.equals("1"))
			{
				System.out.println("Number of guesses available: 10");
				do 
				{
					for (int i =0; i<10;i++)
					{
						int guess[] = userInput(userGuess, randomCode, turn);
						mainAlgorithm(guess, randomCode, turn);
						numOfGuesses++;
						if(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3])
						{
							break;
						}
						else
							continue;
					}
				} while (!(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3]) && numOfGuesses <9);

				outputFinal(userGuess, randomCode, numOfGuesses);
			}

			else if ((level.equalsIgnoreCase("Medium")) || level.equals("2"))
			{
				System.out.println("Number of guesses available: 8");
				do
				{
					for (int i =0; i<8;i++)
					{
						int guess[] = userInput(userGuess, randomCode, turn);
						mainAlgorithm(guess, randomCode, turn);
						numOfGuesses++;
						if(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3])
						{
							break;
						}
						else
							continue;
					}
				} while (!(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3]) && numOfGuesses <7);

				outputFinal(userGuess, randomCode, numOfGuesses);
			}

			else if ((level.equalsIgnoreCase("Hard")) || level.equals("3"))
			{
				System.out.println("Number of guesses available: 6");
				do
				{
					for (int i =0; i<6;i++)
					{
						int guess[] = userInput(userGuess, randomCode, turn);
						mainAlgorithm(guess, randomCode, turn);
						numOfGuesses++;
						if(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3])
						{
							break;
						}
						else
							continue;
					}
				} while (!(randomCode[0] == userGuess[0] && randomCode[1] == userGuess[1] && randomCode[2] == userGuess[2] && randomCode[3] == userGuess[3]) && numOfGuesses <5);

				outputFinal(userGuess, randomCode, numOfGuesses);
				System.out.println();
				
				File myFile = new java.io.File("E:\\Hitansh\\Software\\eclipse-workspace\\Mastermind\\src\\ReadFile.txt");
				PrintWriter output = new PrintWriter(myFile);
				output.println("Number of guesses:");
				output.println((numOfGuesses-1));
				output.close();
			}
			
			System.out.println("If you wish to return to the main menu type 'exit' or if you would like to continue, just press 'enter'");
			choice = br.readLine();
			if (choice.equalsIgnoreCase("exit"))
				Menu.main(null);
			else
			{
				numOfGuesses=1;
				continue;
			}
			System.out.println();
			
		}while (!choice.equalsIgnoreCase("exit"));
	}

	public static int[] generateRandomCode(int[] generateRandom)
	{
		for (int i = 0; i < generateRandom.length; i++)
			generateRandom[i] = new Random ().nextInt (6) + 1; //generate random code 

		System.out.println ("Random code is: " + generateRandom[0] + generateRandom[1] + generateRandom[2] + generateRandom[3]); //print random code for reference
		return generateRandom;
	}

	public static int[] userInput(int [] userGuess, int [] randomCode, int turn) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		for (int i = 0; i < 4; i++) 
		{
			do 
			{
				System.out.println ("Guess number " + (i + 1) + ": ");
				userGuess[i] = Integer.parseInt (br.readLine ());			//accept user guess
			} while (!(userGuess[i] >= 1 && userGuess[i] <= 6));
		}
		System.out.println ("Your guess was: " + userGuess[0] + userGuess[1] + userGuess[2] + userGuess[3] + "\n"); //print out user guess for their reference
		return userGuess;
	}

	public static int mainAlgorithm(int[] guess, int[] randomCode, int turn)
	{
		boolean[] white = new boolean[4];
		boolean[] black = new boolean[4];
		Arrays.fill (white, false);
		Arrays.fill (black, false);
		for (int i = 0; i < white.length; i++) {
			black[i] = guess[i] == randomCode[i];
			if (!black[i]) {
				int j = 0;
				for (int k = 0; k < 3; k++, j++) {
					if (j == i)
						j++;
					white[i] = white[i] || (guess[i] == randomCode[j]);
				}
			}
		}
		int whitePegs = 0, blackPegs = 0;
		for (int i = 0; i < white.length; i++) {
			if (white[i])
				whitePegs++;						//check for white pegs and increment counter if any are found
			if (black[i])
				blackPegs++;						//check for black pegs and increment counter if any are found
		}
		System.out.println ("You have " + whitePegs + " white peg" + (whitePegs == 1 ? "" : "s") + " and " + blackPegs + " black peg"+ (blackPegs == 1 ? "" : "s")); //output # of black and/or white pegs
		turn ++;
		return turn;
	}

	public static void outputFinal(int[] guess, int[] randomCode, int numOfGuesses)
	{
		if (randomCode[0] == guess[0] && randomCode[1] == guess[1] && randomCode[2] == guess[2] && randomCode[3] == guess[3]) 
			System.out.println ("\nCongratulations, you are the champion! It took you "+(numOfGuesses-1)+" guesses to crack the code");
		else
			System.out.println("Sorry you lost! The correct code was: "+randomCode[0] + randomCode[1] + randomCode[2] + randomCode[3]);
	}
}

