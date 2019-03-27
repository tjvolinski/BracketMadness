package com.tjstats.bracket.madness.dao;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tjstats.bracket.madness.Application;
import com.tjstats.bracket.madness.domain2.Bracket;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:db.test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class BracketDAOIT {

	@Autowired
	private BracketDAO bracketDAO;
	
	private static Bracket bracket;
	
	@BeforeClass
	public static void setUp() {
		bracket = buildTestBracket();
	}
	
	@Test
	public void test1_InsertBracket() {
		bracketDAO.insertBracket(bracket);
		Bracket bracket = bracketDAO.getBracket("TJ");
		assertTrue(bracket.getPlayerName().equals("TJ"));
	}
	
	@Test
	public void test2_UpdateBracket() {
		bracket.setChamp("4");
		bracket.setRunnerUpRegion("C");
		bracketDAO.updateBracket(bracket);
		bracket = bracketDAO.getBracket("TJ");
		assertTrue(bracket.getChamp().equals("4") && bracket.getRunnerUpRegion().equals("C"));
	}
	
	@Test
	public void test3_DeleteBracket() {
		bracketDAO.deleteBracket("TJ");
		Bracket bracket = bracketDAO.getBracket("TJ");
		assertTrue(bracket == null);
	}
	
	private static Bracket buildTestBracket() {
		Bracket bracket = new Bracket();
		bracket.setPlayerName("TJ");
		bracket.setChamp("1");
		bracket.setChampRegion("A");
		bracket.setRunnerUp("2");
		bracket.setRunnerUpRegion("D");
		return bracket;
	}
}
