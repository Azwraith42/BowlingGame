package main.java;

public class BowlingGame {

	private int score;
	
	public BowlingGame(){
		this.score = 0;
	}

	public void roll(int pins){
		score += pins;
	}
	
	public int getScore() {
		
		return score;
	}
	
	
	
}
