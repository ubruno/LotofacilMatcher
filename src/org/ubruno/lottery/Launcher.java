package org.ubruno.lottery;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.ubruno.lottery.datatype.LotofacilGame;
import org.ubruno.lottery.matcher.Matcher;
import org.ubruno.lottery.parser.CSVReader;

public class Launcher {
	
	public static void main(String[] args) {
		
		String path = args[0];
		
		List<Integer> expectedResult = new ArrayList<Integer>(0);
		
		for (int i = 1; i < args.length; i++) {
			expectedResult.add(Integer.parseInt(args[i]));
		}
		
		if(expectedResult.size() != 15){
			System.out.println("You must input 15 numbers!");
			System.exit(0);
		}
		
		try {
			List<LotofacilGame> games = new CSVReader(path).getGames();
			
			String toPrint = new Matcher(expectedResult, games).getMatch();
			
			makeHTMLAndOpen(toPrint);
			
		} catch (IOException e) {
			System.out.println("Wrong csv file!");
			e.printStackTrace();
		}
		
		
		
	}

	private static void makeHTMLAndOpen(String toPrint) throws IOException {

		File file = new File("result.html");
		
		PrintWriter writer = new PrintWriter(file);
		
		writer.println(toPrint);
		
		writer.flush();
		writer.close();
		
		Desktop.getDesktop().open(file);
	}
	

}
