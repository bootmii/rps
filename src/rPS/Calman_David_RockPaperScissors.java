package rPS;

import java.util.*;

public class Calman_David_RockPaperScissors {
	public static Scanner stdin = new Scanner(System.in);
	public static Random r = new Random();

	public static enum RPS { // enum of possible attacks
		rock, paper, scissors, quit;
	}

	public static RPS scan() {
		RPS ret = null;
		while (ret == null) { // until a value is assigned:
			System.out.print("Choose rock, paper, scissors, or quit: ");
			String choice = stdin.next(); // store next token
			if (choice.equals(RPS.rock.name())) { // if "rock"
				ret = RPS.rock;
			} else if (choice.equals(RPS.paper.name())) { // if "paper"
				ret = RPS.paper;
			} else if (choice.equals(RPS.scissors.name())) { // if "scissors"
				ret = RPS.scissors;
			} else { // invalid, quit game
				ret = RPS.quit;
			}

		}
		return ret; // returns value
	}

	public static RPS randAttack() { // returns random attack
		int s = r.nextInt(3); // must be 0, 1, or 2
		RPS attack = null; // only way to declare outside switch
		switch (s) { // switch statement
		case 0: // if 0, pick rock
			attack = RPS.rock;
			break;
		case 1: // if 1, pick paper
			attack = RPS.paper;
			break;
		case 2: // if 2, pick scissors
			attack = RPS.scissors;
			break;
		}
		return attack;
	}

	public static void main(String[] args) {
		int cpuWins = 0, yourWins = 0, ties = 0; // declare
		while (true) { // must break out manually
			RPS cpuAttack = randAttack(); // CPU picks a random attack
			RPS yourAttack = scan();
			if (yourAttack.equals(RPS.quit))
				break; // BREAKS OUT
			if (cpuAttack.equals(yourAttack)) {
				ties++; // tally a tie
				System.out.println("It's a tie!"); }
			if (cpuAttack.equals(RPS.rock) && yourAttack.equals(RPS.paper)) {
				yourWins++; // tally a user win
				System.out.println("You win: paper covers rock"); }
			if (cpuAttack.equals(RPS.rock) && yourAttack.equals(RPS.scissors)) {
				cpuWins++; // tally a CPU win
				System.out.println("CPU wins: rock smashes scissors");
			}
			if (cpuAttack.equals(RPS.paper) && yourAttack.equals(RPS.rock)) {
				cpuWins++; // I think the code and messages speak for themselves
				System.out.println("CPU wins: paper covers rock");
			}
			if (cpuAttack.equals(RPS.paper) && yourAttack.equals(RPS.scissors)) {
				yourWins++;
				System.out.println("You win: scissors cut paper");
			}
			if (cpuAttack.equals(RPS.scissors) && yourAttack.equals(RPS.rock)) {
				yourWins++;
				System.out.println("You win: rock smashes scissors");
			}
			if (cpuAttack.equals(RPS.scissors) && yourAttack.equals(RPS.paper)) {
				cpuWins++;
				System.out.println("CPU wins: scissors cut paper");
			}
		}
		System.out.println("Your wins: "+yourWins); // print out stats
		System.out.println("CPU wins: "+cpuWins);
		System.out.println("Ties: "+ties);
	}
}