package main.java;


public class BowlingGame {

	private int score;
	private int[] rolls = new int[21];
	private int currentRoll = 0;
	
	public BowlingGame(){
		this.score = 0;
	}

	public void roll(int pins){
		rolls[currentRoll++] = pins;
	}
	
	public int getScore() {
		
		for(int i=0; i<21; i++){
			score += rolls[i];
		}
		
		if(rolls[0] + rolls[1] == 10){
			score += rolls[2];
		}
		
		return score;
	}
	
}
