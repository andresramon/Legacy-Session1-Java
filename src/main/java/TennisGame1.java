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
        if(playerName == "player1"){
            m_score1 += 1;
        }else {
            m_score2 += 1;
        }
    }

    public String getScore(){
        String score = "";
        if(isEqualScore()){
            score = equalScoreMap.get(m_score1);

            if(score == null){
                score = "Deuce";
            }
        }else if(isScoreOverOrEqualsFour(m_score1) || isScoreOverOrEqualsFour(m_score2)){
            score = getScoreForAdvantageOrWinnerPlayer();
        }else {
            score = getNotEqualOrAdvantageScore();
        }
        return score;
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

    private boolean isScoreOverOrEqualsFour(int score){
        return score >= 4;
    }

    private boolean isEqualScore(){
        return m_score1 == m_score2;
    }
}
