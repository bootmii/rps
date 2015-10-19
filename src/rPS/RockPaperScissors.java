package rPS;

import java.util.*;

public class RockPaperScissors {
	public static Scanner stdin = new Scanner(System.in);
	public static Random r = new Random();

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

	public static RPS randAttack() {
		int s = r.nextInt(3);
		RPS attack = null;
		switch (s) {
		case 0:
			attack = RPS.rock;
			break;
		case 1:
			attack = RPS.paper;
			break;
		case 2:
			attack = RPS.scissors;
			break;
		}
		return attack;
	}

	public static void main(String[] args) {
		int cpuWins = 0, yourWins = 0, ties = 0;
		while (true) {
			RPS cpuAttack = randAttack();
			RPS yourAttack = scan();
			if (yourAttack.equals(RPS.quit))
				break;
			if (cpuAttack.equals(yourAttack)) {
				ties++;
				System.out.println("It's a tie!"); }
			if (cpuAttack.equals(RPS.rock) && yourAttack.equals(RPS.paper)) {
				yourWins++;
				System.out.println("You win: paper covers rock"); }
			if (cpuAttack.equals(RPS.rock) && yourAttack.equals(RPS.scissors)) {
				cpuWins++;
				System.out.println("CPU wins: rock smashes scissors");
			}
			if (cpuAttack.equals(RPS.paper) && yourAttack.equals(RPS.rock)) {
				cpuWins++;
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
		System.out.println("Your wins: "+yourWins);
		System.out.println("CPU wins: "+cpuWins);
		System.out.println("Ties: "+ties);
	}
}