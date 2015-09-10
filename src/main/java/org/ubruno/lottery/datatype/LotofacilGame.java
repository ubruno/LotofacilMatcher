package org.ubruno.lottery.datatype;

import java.util.ArrayList;
import java.util.List;

public class LotofacilGame {

	private int[] numbers = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	
	private int betSize = 0;

	private List<Integer> matches = new ArrayList<Integer>();

	private int hits = 0;

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getMatches() {
		return matches;
	}

	public void setMatches(List<Integer> matches) {
		this.matches = matches;
	}

	private boolean hasMatch(int number) {

		for (Integer k : getMatches()) {
			if (number == k.intValue())
				return true;
		}
		return false;
	}

	public String processAndPrint() {
		StringBuffer result = new StringBuffer();
		result.append("<p>");

		int cont = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] != 0) {
				if (hasMatch(numbers[i])) {
					cont++;
					result.append("<b>" + numbers[i] + "</b>, ");
				} else {
					result.append(numbers[i] + ", ");
				}
			}
		}

		String veredicto = " acertos :(";
		hits = cont;
		switch (hits) {

		case 11:
			veredicto = " acertos! :)";
			break;

		case 12:
			veredicto = " acertos! :)";
			break;

		case 13:
			veredicto = " acertos! ;)";
			break;

		case 14:
			veredicto = " acertos! ;D";
			break;

		case 15:
			veredicto = " acertos! \\o/";
			break;

		default:
			break;
		}
		result.append("||| <b>" + (hits) + veredicto + "</b>");
		result.append(" </p>\n");
		return result.toString();
	}

	public int getHits() {
		return hits;
	}

	public int getBetSize() {
		return betSize;
	}

	public void setBetSize(int betSize) {
		this.betSize = betSize;
	}
}
