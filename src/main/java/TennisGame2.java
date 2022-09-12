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

    public TennisGame2(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if(isEqualScore(P1point, P2point) && P1point < 3){
            score = getScoreFromPoint(P1point);
            score += ALL;
        }
        if(isEqualScore(P1point, P2point) && P1point >= 3)
            score = DEUCE;

        if(onlyLastScoreIsZero(P1point, P2point)){
            P1res = getScoreFromPoint(P1point);
            P2res = LOVE;
            score = P1res + SCORE_SEPARATOR + P2res;
        }
        if(onlyLastScoreIsZero(P2point, P1point)){
            P2res = getScoreFromPoint(P2point);
            P1res = LOVE;
            score = P1res + SCORE_SEPARATOR + P2res;
        }

        if(P1point > P2point && P1point < 4){
            P1res = getScoreFromPoint(P1point);
            P2res = getScoreFromPoint(P2point);
            score = P1res + SCORE_SEPARATOR + P2res;
        }
        if(P2point > P1point && P2point < 4){
            P1res = getScoreFromPoint(P1point);
            P2res = getScoreFromPoint(P2point);
            score = P1res + SCORE_SEPARATOR + P2res;
        }

        if(P1point > P2point && P2point >= 3){
            score = "Advantage player1";
        }

        if(P2point > P1point && P1point >= 3){
            score = "Advantage player2";
        }

        if(P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2){
            score = "Win for player1";
        }
        if(P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2){
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreFromPoint(int point){
        if(point == 0)
            return LOVE;
        if(point == 1)
            return FIFTEEN;
        if(point == 2)
            return THIRTY;
        if(point == 3)
            return FORTY;

        return null;
    }

    private boolean onlyLastScoreIsZero(int p1point, int p2point){
        return p1point > 0 && p2point == 0;
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