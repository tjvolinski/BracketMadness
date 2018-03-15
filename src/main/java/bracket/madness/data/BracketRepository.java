package bracket.madness.data;

import java.util.List;

import bracket.madness.domain.Bracket;
import bracket.madness.domain.Player;

public interface BracketRepository {
		public int addBracket(Bracket bracket);
		public int updateBracket(Bracket bracket);
		public Bracket getBracket(String bracketName);
		public List<Bracket> getAllPlayerBrackets();
		public int deleteBracket(Bracket bracket);
		public void populateAllPreviousScores(List<Bracket> brackets);
		public int updateScore(Player player);
		public int insertScore(Player player);
		public int updateBracketWithScoreKey(Player player);
		public String getNote();
		public void insertNote(String note);
		public void updateNote(String note);
}
