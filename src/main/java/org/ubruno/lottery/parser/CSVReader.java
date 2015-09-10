package org.ubruno.lottery.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ubruno.lottery.datatype.LotofacilGame;

public class CSVReader {
	
	private String path;
	
	public CSVReader(String path) {
		this.path = path;
	}

	public List<LotofacilGame> getGames() throws IOException{
		
		List<LotofacilGame> games = new ArrayList<LotofacilGame>();
		
		List<String> stringGames = parseCSVFile(); 
		
		for (String stringGame : stringGames) {
			
			String[] numbers = stringGame.split(",");
			int i = 0;
			
			LotofacilGame game = new LotofacilGame();
			game.setBetSize(numbers.length);
			for (String number : numbers) {
				
				game.getNumbers()[i] = Integer.parseInt(number);
				i++;
			}
			games.add(game);
		}
		return games;
		
	}
	
	private List<String> parseCSVFile() throws IOException{
		
		List<String> games = new ArrayList<String>(0);
		
		File file = new File(path);
		
		FileReader fileReader = new FileReader(file);
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		while(reader.ready()){
			String match = reader.readLine();
			games.add(match);
		}
		
		reader.close();
		fileReader.close();
		
		return games;
	}

}
