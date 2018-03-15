package bracket.madness.utils;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class StatisticUtil {
	
	private static DecimalFormat format = new DecimalFormat("##.00");
	private static DecimalFormat formatWhole = new DecimalFormat("##");
	private static final double ROUNDED_ODDS_UPPER_BOUND = 0.90;
	private static final double ROUNDED_ODDS_LOWER_BOUND = 0.10;
	private static final int ROUNDED_ODDS_ATTEMPT_COUNT = 9;
	
	public static String getPercentage(int timesOccured, int numberOfBrackets) {
		return format.format(timesOccured/Double.valueOf(numberOfBrackets)*100);
	}
	
	public static String getRoundedOdds(int timesOccured, int numberOfBrackets) {
		if (timesOccured == 0){
			return "NONE";
		}
		if (timesOccured == numberOfBrackets){
			return "WINNER";
		}
		return calculateRoundedOdds((1/(timesOccured/Double.valueOf(numberOfBrackets)))-1);
	}
	
	public static String getAverage(Long totalAmount, int numberOfBrackets){
		return format.format(totalAmount/Double.valueOf(numberOfBrackets));
	}
	
	public static String getMoneyLine(int timesOccured, int numberOfBrackets){
		Double odds = (timesOccured/Double.valueOf(numberOfBrackets));
		Double moneyLineMinus = (-(odds*100))/(1-odds);
		Double moneyLinePlus = ((1-odds)*100)/odds;
		if (odds >= .5){
			return formatWhole.format(moneyLineMinus);
		} else {
			return "+"+formatWhole.format(moneyLinePlus);
		}
	}
	
	private static String calculateRoundedOdds(Double odds) {
		int count = 1;
		Double newOdds = odds;
		while(newOdds < 1){
			newOdds = odds*count;
			count++;
		}
		Long wholeNumber = newOdds.longValue();
		Double origDecimalPart = new Double(format.format(newOdds - wholeNumber)).doubleValue();
		Double currDecimalPart = new Double(format.format(newOdds - wholeNumber)).doubleValue();
		while (currDecimalPart < ROUNDED_ODDS_UPPER_BOUND &&  currDecimalPart > ROUNDED_ODDS_LOWER_BOUND
				&& count < ROUNDED_ODDS_ATTEMPT_COUNT){
			count++;
			currDecimalPart = origDecimalPart*count;
			if ((currDecimalPart > 1+ROUNDED_ODDS_LOWER_BOUND || currDecimalPart < ROUNDED_ODDS_UPPER_BOUND) 
					&& count < ROUNDED_ODDS_ATTEMPT_COUNT){
				currDecimalPart = origDecimalPart;
			}
		}
		
		Long leftSideOdds = Long.valueOf( Math.round(odds*count));
		if (wholeNumber ==  0){
			leftSideOdds = Long.valueOf(Math.round(currDecimalPart));
		}
		Long rightSideOdds = Long.valueOf(count);
		int gcd = gcd(leftSideOdds, rightSideOdds);
		if (gcd == 0){
			return Long.valueOf(leftSideOdds).toString()+":"+Long.valueOf(rightSideOdds).toString();
		} 
		return Long.valueOf(leftSideOdds/gcd).toString()+":"+Long.valueOf(rightSideOdds/gcd).toString();
	}
	
	private static int gcd(Long a, Long b) {
	    return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
	}

}
