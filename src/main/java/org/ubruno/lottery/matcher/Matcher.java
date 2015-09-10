package org.ubruno.lottery.matcher;

import java.util.List;

import org.ubruno.lottery.datatype.LotofacilGame;

public class Matcher {
	
	
	private List<Integer> expectedResult;
	private List<LotofacilGame> games;
	
	private int[] report = new int[15];
	
	public Matcher(List<Integer> expectedResult, List<LotofacilGame> games ) {
		this.expectedResult = expectedResult;
		this.games = games;
		
		for (int i = 0; i < report.length; i++) {
			report[i] = 0;
		}
	}
	
	public String getMatch(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<title> Lottery Matcher Tabajara </title> ");
		buffer.append("</head>");
		buffer.append("<body>");

		int i = 1;
		for (LotofacilGame game : games) {
			buffer.append("<br />"+i+"&#186; - Jogo de "+ game.getBetSize()+ " n&#250;meros");
			i++;
			
			game.setMatches(expectedResult);
			
			buffer.append(game.processAndPrint());
			
			report[(game.getHits()-1)]++;
			
		}		
		buffer.append("<hr />");
		buffer.append("<p> Resume </p>");
		
		
		buffer.append("<p>Expected Numbers</p><p>");
		for (Integer in : expectedResult) {
			buffer.append("<b> "+in+"</b>");
		}
		buffer.append("</p>");
		
		for(int ic = 14; ic >= 8; ic--){
			buffer.append("<p>"+(ic+1)+" hits: "+ report[ic] +"</p>\n");
		}


		buffer.append("<hr>");
		buffer.append("(bruno)");
		
		buffer.append("</body>");
		
		buffer.append("</html>");
		
		return buffer.toString();
	}

}
