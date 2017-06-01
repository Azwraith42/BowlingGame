package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.BowlingGame;


public class BowlingGameTest {
	
	public BowlingGame bg = new BowlingGame();
	
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
		bg.roll(5);
		bg.roll(5);
		bg.roll(1);
		
		//when
		final int score = bg.getScore();
		
		//then
		assertEquals(12, score);
	}
	
}
