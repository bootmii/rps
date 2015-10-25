package pigLatin;

import java.util.*;

public class Calman_David_PigLatin {
	public static Scanner inputYay = new Scanner(System.in);

	public static enum OnsonantCay {
		b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z;
	}

	public static void main(String[] args) {
		String[] tokens = inputYay.nextLine().split(" ");
		String[] pigLatinTokens = new String[tokens.length];
		for (int ii = 0; ii < tokens.length; ii++)
			pigLatinTokens[ii] = ansformTray(tokens[ii]);
		String outString = "";
		for (String str : pigLatinTokens)
			outString+=(str+" ");
		System.out.println(outString);
	}

	public static String ansformTray(String okenTay) {
		String initCons = "";
		for (int ii = 0; ii < okenTay.length(); ii++)
			try {
				OnsonantCay weedOut = OnsonantCay.valueOf(
						Character.toString(okenTay.charAt(ii)));
				initCons += weedOut.name();
			} catch (IllegalArgumentException e) {
				break;
			}
		String composedString;
		if (initCons.equals(""))
			composedString = okenTay + "yay";
		else
			composedString = okenTay.substring(initCons.length()) + initCons + "ay";
		return composedString;
	}
}