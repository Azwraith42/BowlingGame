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
	
	private boolean isSpare(final int roll){
		if(rolls[roll] + rolls[roll+1] == 10){
			return true;
		}	
		return false;
	}
	
	private boolean isStrike(final int roll){
		if(rolls[roll] == 10){
			return true;
		}
		return false;
	}
	
	public int getScore() {
		
		int rollIndex = 0;
		for(int frame = 0; frame < 10; frame++, rollIndex += 2){
			if(isStrike(rollIndex)){
				score += 10 + strikeBonus(rollIndex);
				rollIndex--;
			}
			else if(isSpare(rollIndex)){
				score += 10 + spareBonus(rollIndex);
			}else{
				score += rolls[rollIndex] + rolls[rollIndex+1];
			}
		}
		
		return score;
	}

	private int strikeBonus(int rollIndex) {
		return rolls[rollIndex+1] + spareBonus(rollIndex);
	}

	private int spareBonus(int rollIndex) {
		return rolls[rollIndex+2];
	}
	
}
