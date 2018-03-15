package bracket.madness.data;

public interface BracketSQL {
	String TABLE_REGIONS = "regions";
	String COLUMN_1v16 = "'1v16'";
	String COLUMN_8v9 = "'8v9'";
	String COLUMN_5v12 = "'5v12'";
	String COLUMN_4v13 = "'4v13'";
	String COLUMN_6v11 = "'6v11'";
	String COLUMN_3v14 = "'3v14'";
	String COLUMN_7v10 = "'7v10'";
	String COLUMN_2v15 = "'2v15'";
	String COLUMN_SWEET1 = "'sweet1'";
	String COLUMN_SWEET2 = "'sweet2'";
	String COLUMN_SWEET3 = "'sweet3'";
	String COLUMN_SWEET4 = "'sweet4'";
	String COLUMN_ELITE1 = "'elite1'";
	String COLUMN_ELITE2 = "'elite2'";
	String COLUMN_CHAMP = "'champ'";
	String COLUMN_REGION_KEY = "'region_key'";
	
	String TABLE_BRACKETS = "brackets";
	String COLUMN_BRACKET_NAME = "'bracket_name'";
	String COLUMN_WINNER = "'winner'";
	String COLUMN_LOSER = "'loser'";
	String COLUMN_REGION1_KEY = "'region1_key'";
	String COLUMN_REGION2_KEY = "'region2_key'";
	String COLUMN_REGION3_KEY = "'region3_key'";
	String COLUMN_REGION4_KEY = "'region4_key'";
	String COLUMN_BRACKET_ID = "'bracket_id'";
	String COLUMN_PREV_SCORE = "prev_score";
	
	String COLUMN_REGION1_KEY_NO_QUOTES = "region1_key";
	String COLUMN_REGION2_KEY_NO_QUOTES = "region2_key";
	String COLUMN_REGION3_KEY_NO_QUOTES = "region3_key";
	String COLUMN_REGION4_KEY_NO_QUOTES = "region4_key";
	String COLUMN_REGION_KEY_NO_QUOTES = "region_key";
	String COLUMN_BRACKET_NAME_NO_QUOTES = "bracket_name";
	String COLUMN_BRACKET_ID_NO_QUOTES = "bracket_id";
	
	String TABLE_SCORES = "scores";
	String COLUMN_SCORE_KEY = "score_key";
	String COLUMN_WIN = "win";
	String COLUMN_TOP_THREE = "top_three";
	String COLUMN_LAST = "last";
	String COLUMN_POSITION = "position";
	String COLUMN_POINTS = "points";
	String COLUMN_MONEY_LINE = "money_line";
	String COLUMN_ODDS = "odds";
	String COLUMN_WIN_CHANGE = "win_change";
	String COLUMN_TOP_THREE_CHANGE = "top_three_change";
	String COLUMN_LAST_CHANGE = "last_change";
	
	String TABLE_MISC = "misc";
	String COLUMN_TYPE = "type";
	String COLUMN_VALUE = "value";
	
	String COMMA = ",";
	String AND = " AND ";
	String OR = " OR ";
	String EQUALS = "=";
	
	StringBuilder LAST_INSERTED_ROW_KEY = new StringBuilder()
		.append("SELECT last_insert_rowid()");
	
	StringBuilder INSERT_REGION = new StringBuilder()
		.append("INSERT INTO ").append(TABLE_REGIONS).append(" (")
		.append(COLUMN_1v16).append(COMMA)
		.append(COLUMN_8v9).append(COMMA)
		.append(COLUMN_5v12).append(COMMA)
		.append(COLUMN_4v13).append(COMMA)
		.append(COLUMN_6v11).append(COMMA)
		.append(COLUMN_3v14).append(COMMA)
		.append(COLUMN_7v10).append(COMMA)
		.append(COLUMN_2v15).append(COMMA)
		.append(COLUMN_SWEET1).append(COMMA)
		.append(COLUMN_SWEET2).append(COMMA)
		.append(COLUMN_SWEET3).append(COMMA)
		.append(COLUMN_SWEET4).append(COMMA)
		.append(COLUMN_ELITE1).append(COMMA)
		.append(COLUMN_ELITE2).append(COMMA)
		.append(COLUMN_CHAMP).append(")")
		.append(" VALUES ").append("(")
		.append("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)");
	
	StringBuilder UPDATE_REGION = new StringBuilder()
		.append("UPDATE ").append(TABLE_REGIONS).append(" SET ")
		.append(COLUMN_1v16).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_8v9).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_5v12).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_4v13).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_6v11).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_3v14).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_7v10).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_2v15).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_SWEET1).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_SWEET2).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_SWEET3).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_SWEET4).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_ELITE1).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_ELITE2).append(EQUALS).append("%s").append(COMMA)
		.append(COLUMN_CHAMP).append(EQUALS).append("%s")
		.append(" WHERE ").append(COLUMN_REGION_KEY_NO_QUOTES).append(EQUALS).append("%s");
	
	StringBuilder DELETE_REGIONS = new StringBuilder()
		.append("DELETE FROM ").append(TABLE_REGIONS)
		.append(" WHERE ").append(COLUMN_REGION_KEY_NO_QUOTES).append(" IN ").append("(")
		.append("%s, %s, %s, %s)");
	
	StringBuilder INSERT_BRACKET = new StringBuilder()
		.append("INSERT INTO ").append(TABLE_BRACKETS).append(" (")
		.append(COLUMN_BRACKET_NAME).append(COMMA)
		.append(COLUMN_WINNER).append(COMMA)
		.append(COLUMN_LOSER).append(COMMA)
		.append(COLUMN_REGION1_KEY).append(COMMA)
		.append(COLUMN_REGION2_KEY).append(COMMA)
		.append(COLUMN_REGION3_KEY).append(COMMA)
		.append(COLUMN_REGION4_KEY).append(")")
		.append(" VALUES ").append("(")
		.append("'%s','%s','%s',%s,%s,%s,%s)");
	
	StringBuilder UPDATE_BRACKET = new StringBuilder()
		.append("UPDATE ").append(TABLE_BRACKETS).append(" SET ")
		.append(COLUMN_BRACKET_NAME).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_WINNER).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_LOSER).append(EQUALS).append("'%s'")
		.append(" WHERE ").append(COLUMN_BRACKET_ID_NO_QUOTES).append(EQUALS).append("%s");
	
	StringBuilder DELETE_BRACKET = new StringBuilder()
		.append("DELETE FROM ").append(TABLE_BRACKETS)
		.append(" WHERE ").append(COLUMN_BRACKET_ID_NO_QUOTES).append(" IN ").append("(%s)");
	
	StringBuilder DELETE_BRACKET_SCORE = new StringBuilder()
		.append("DELETE FROM ").append(TABLE_SCORES)
		.append(" WHERE ").append(COLUMN_SCORE_KEY).append(" IN ").append("(%s)");
	
	StringBuilder GET_BRACKETS = new StringBuilder()
		.append("SELECT * FROM ").append(TABLE_BRACKETS).append(COMMA).append(TABLE_REGIONS)
		.append(" WHERE (").append(COLUMN_REGION1_KEY_NO_QUOTES).append(EQUALS).append(COLUMN_REGION_KEY_NO_QUOTES).append(OR)
		.append(COLUMN_REGION2_KEY_NO_QUOTES).append(EQUALS).append(COLUMN_REGION_KEY_NO_QUOTES).append(OR)
		.append(COLUMN_REGION3_KEY_NO_QUOTES).append(EQUALS).append(COLUMN_REGION_KEY_NO_QUOTES).append(OR)
		.append(COLUMN_REGION4_KEY_NO_QUOTES).append(EQUALS).append(COLUMN_REGION_KEY_NO_QUOTES).append(") ");

	StringBuilder BY_NAME = new StringBuilder()
		.append(AND).append(COLUMN_BRACKET_NAME_NO_QUOTES).append(EQUALS).append("'%s'");
	
	StringBuilder GET_PREVIOUS_SCORES = new StringBuilder()
		.append("SELECT * FROM ").append(TABLE_SCORES)
		.append(" WHERE ").append(COLUMN_SCORE_KEY).append(" IN ").append("(%s)");
	
	StringBuilder UPDATE_SCORE = new StringBuilder()
		.append("UPDATE ").append(TABLE_SCORES).append(" SET ")
		.append(COLUMN_WIN).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_TOP_THREE).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_LAST).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_POSITION).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_POINTS).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_MONEY_LINE).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_ODDS).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_WIN_CHANGE).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_TOP_THREE_CHANGE).append(EQUALS).append("'%s'").append(COMMA)
		.append(COLUMN_LAST_CHANGE).append(EQUALS).append("'%s'")
		.append(" WHERE ").append(COLUMN_SCORE_KEY).append(EQUALS).append("%s");
	
	StringBuilder INSERT_SCORE = new StringBuilder()
		.append("INSERT INTO ").append(TABLE_SCORES).append(" (")
		.append(COLUMN_WIN).append(COMMA)
		.append(COLUMN_TOP_THREE).append(COMMA)
		.append(COLUMN_LAST).append(COMMA)
		.append(COLUMN_POSITION).append(COMMA)
		.append(COLUMN_POINTS).append(COMMA)
		.append(COLUMN_MONEY_LINE).append(COMMA)
		.append(COLUMN_ODDS).append(COMMA)
		.append(COLUMN_WIN_CHANGE).append(COMMA)
		.append(COLUMN_TOP_THREE_CHANGE).append(COMMA)
		.append(COLUMN_LAST_CHANGE).append(")")
		.append(" VALUES ").append("(")
		.append("'%s','%s','%s','%s','%s','%s','%s','0','0','0')");
	
	StringBuilder UPDATE_BRACKET_SCORE_KEY = new StringBuilder()
		.append("UPDATE ").append(TABLE_BRACKETS).append(" SET ")
		.append(COLUMN_PREV_SCORE).append(EQUALS).append("%s")
		.append(" WHERE ").append(COLUMN_BRACKET_ID_NO_QUOTES).append(EQUALS).append("%s");
	
	StringBuilder GET_NOTE = new StringBuilder()
		.append("SELECT * FROM ").append(TABLE_MISC)
		.append(" WHERE ").append(COLUMN_TYPE).append(EQUALS).append("'NOTE'");
	
	StringBuilder INSERT_NOTE = new StringBuilder()
		.append("INSERT INTO ").append(TABLE_MISC).append(" (")
		.append(COLUMN_TYPE).append(COMMA)
		.append(COLUMN_VALUE).append(")")
		.append(" VALUES ").append("(")
		.append("'%s','%s')");
	
	StringBuilder UPDATE_NOTE = new StringBuilder()
		.append("UPDATE ").append(TABLE_MISC).append(" SET ")
		.append(COLUMN_VALUE).append(EQUALS).append("'%s'")
		.append(" WHERE ").append(COLUMN_TYPE).append(EQUALS).append("'NOTE'");
}
