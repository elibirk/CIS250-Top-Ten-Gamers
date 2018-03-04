import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GameSort {
	public static void main(String[]args) throws IOException, FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		Scores top10 = new Scores();
		GameEntry userScore;
		GameEntry oldScore;
		int userChoice = 1;
		String username;
		int score;
		long startTime;
		long endTime;
		long time;
		
		while (userChoice != 0){
			System.out.println ("Please enter your user name.");
			username = keyboard.next();
			System.out.println("Now please enter your score.");
			score = keyboard.nextInt();
			//create gameEntry, sort to determine how to add to Scores
			userScore = new GameEntry(username, score);
			if(score > top10.getEntry(9).getScore()){
				top10.setEntry(9, userScore);
				int i = 8;
				startTime = System.nanoTime();
				while (i >= 0 && top10.getEntry(i).getScore() < top10.getEntry(i+1).getScore()){
					oldScore = top10.getEntry(i);
					top10.setEntry(i, top10.getEntry(i+1));
					top10.setEntry(i+1, oldScore);	
					i--;
				}//end while
				endTime = System.nanoTime();
				time = endTime - startTime;
				System.out.println("Added new entry to top 10, sort took " + time + " nanoseconds.");
				System.out.println("New top ten board:\n" + top10.toString());
			}//end if
			else{System.out.println("You do not qualify for the top 10, sorry!");}
			System.out.println("If you have more score to add, type 1. If you do not, type 0.");
			userChoice = keyboard.nextInt();
		}//end while
		
	}//main end
}//GameSort End
