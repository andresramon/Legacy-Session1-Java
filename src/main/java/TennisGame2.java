import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame{
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String ALL = "-All";
    private static final String DEUCE = "Deuce";
    private static final String SCORE_SEPARATOR = "-";
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private Map<Integer, String> scoreMap = new HashMap<Integer, String>(){{
        put(0, LOVE);
        put(1, FIFTEEN);
        put(2, THIRTY);
        put(3, FORTY);
    }};

    public TennisGame2(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if(P1point >= 4 && isTwoPointDifference(P1point, P2point)){
            return "Win for player1";
        }

        if(P2point >= 4 && isTwoPointDifference(P2point, P1point)){
            return "Win for player2";
        }

        if(P1point > P2point && P2point >= 3){
            return "Advantage player1";
        }

        if(P2point > P1point && P1point >= 3){
            return "Advantage player2";
        }

        if(isEqualScore(P1point, P2point) && P1point >= 3){
            return DEUCE;
        }

        if(isEqualScore(P1point, P2point) && P1point < 3){
            score = getScoreFromPoint(P1point);
            score += ALL;
            return score;
        }

        P1res = getScoreFromPoint(P1point);
        P2res = getScoreFromPoint(P2point);
        return getScoreDescription();

    }

    private boolean isTwoPointDifference(int p1point, int p2point){
        return (p1point - p2point) >= 2;
    }

    private String getScoreDescription(){
        return P1res + SCORE_SEPARATOR + P2res;
    }

    private String getScoreFromPoint(int point){
        return scoreMap.get(point);
    }

    private boolean isEqualScore(int p1point, int p2point){
        return p1point == p2point;
    }

    public void SetP1Score(int number){

        for(int i = 0; i < number; i++){
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for(int i = 0; i < number; i++){
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player){
        if(player == "player1")
            P1Score();
        else
            P2Score();
    }
}