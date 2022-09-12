import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame{

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private Map<Integer, String> equalScoreMap = new HashMap<Integer, String>(){{
        put(0, "Love-All");
        put(1, "Fifteen-All");
        put(2, "Thirty-All");
    }};

    private Map<Integer, String> scoreMap = new HashMap<Integer, String>(){{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    public TennisGame1(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName){
        if(playerName.equalsIgnoreCase(PlayerEnum.Player1.name())){
            m_score1 += 1;
        }else {
            m_score2 += 1;
        }
    }

    public String getScore(){

        if(isEqualScore()){
            return getEqualScore();
        } 
        	
        if(isBothScoresOverOrEqualsFour()){
            return getScoreForAdvantageOrWinnerPlayer();
        }
        
        return getNotEqualOrAdvantageScore();
    }

	private boolean isBothScoresOverOrEqualsFour() {
		return m_score1 >= 4 || m_score2 >= 4;
	}

	private String getEqualScore() {
		return equalScoreMap.getOrDefault(m_score1, "Deuce");
	}

    private String getNotEqualOrAdvantageScore(){

       return scoreMap.get(m_score1) + "-" + scoreMap.get(m_score2);

    }

    private String getScoreForAdvantageOrWinnerPlayer(){

        int minusResult = m_score1 - m_score2;

        if(minusResult == 1){
            return "Advantage player1";
        }
        if(minusResult == -1){
            return "Advantage player2";
        }
        if(minusResult >= 2){
            return "Win for player1";
        }

        return "Win for player2";
    }

    private boolean isEqualScore(){
        return m_score1 == m_score2;
    }
}
