package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.BowlingGame;


public class BowlingGameTest {
	
	public BowlingGame bg = new BowlingGame();
	
	private void rollSpare() {
		bg.roll(5);
		bg.roll(5);
	}
	
	private void rollMany(int n, int pins) {
		for(int i=0;i<n;i++){
			bg.roll(pins);
		}
	}
	
	@Test
	public void allMissesIsZero(){
		//given
		bg.roll(0);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(0, score);
	}
	
	@Test
	public void rollingOneGivesOne(){
		//given
		bg.roll(1);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(1, score);
	}
	
	@Test
	public void rollingOneThenOneScoresTwo(){
		//given
		for(int i=0; i<2; i++){
			bg.roll(1);
		}
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(2, score);
	}
	
	@Test
	public void rollingSpareThenOneScoresTwelve(){
		//given
		rollSpare();
		
		bg.roll(1);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(12, score);
	}
	
	@Test
	public void rollingTwoSparesThenOne() {
		rollSpare();
		rollSpare();
		
		bg.roll(1);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(15+11+1, score);
	}
	
	@Test
	public void AStrikeThenOneThenTwoIsFourteen(){
		//given
		bg.roll(10);
		
		bg.roll(1);
		bg.roll(2);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(16, score);
	}
	
	@Test
	public void allStrikesIsThreeHundred(){
		//given
		rollMany(12, 10);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(300, score);
		
	}
	
	@Test
	public void twentyOneFivesIsOneHundredFifty(){
		//given
		rollMany(21, 5);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(150, score);
		
	}
}
