package rPS;

import java.util.Scanner;

public class RockPaperScissors {
	public static Scanner stdin = new Scanner(System.in);

	public static enum RPS {
		rock, paper, scissors, quit;
	}

	public static RPS scan() {
		RPS ret = null;
		while (ret == null) {
			System.out.print("Choose rock, paper, scissors, or quit: ");
			String choice = stdin.next();
			if (choice.equals(RPS.rock.name())) {
				ret = RPS.rock;
			} else if (choice.equals(RPS.paper.name())) {
				ret = RPS.paper;
			} else if (choice.equals(RPS.scissors.name())) {
				ret = RPS.scissors;
			} else { // invalid, quit game
				ret = RPS.quit;
			}

		}
		return ret;
	}
	public static void main(String[] args) {
		
	}
}
