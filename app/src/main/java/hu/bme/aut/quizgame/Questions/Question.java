package hu.bme.aut.quizgame.Questions;

public class Question {
    private int level;
    private String q;
    private String A_answer;
    private String B_answer;
    private String C_answer;
    private String D_answer;
    private String solution;

    public Question(int level, String q, String A_answer, String B_answer,
                  String C_answer, String D_answer, String solution) {
        this.level = level;
        this.q = q;
        this.A_answer = A_answer;
        this.B_answer = B_answer;
        this.C_answer = C_answer;
        this.D_answer = D_answer;
        this.solution= solution;
    }

    public int getLevel() {
        return level;
    }

    public String getQ() {
        return q;
    }

    public String getA_answer() {
        return A_answer;
    }

    public String getB_answer() {
        return B_answer;
    }

    public String getC_answer() {
        return C_answer;
    }

    public String getD_answer() {
        return D_answer;
    }

    public String getSolution() { return solution; }


    public void setLevel(int level){
        this.level=level;
    }

    public void setQ(String q){
        this.q=q;
    }

    public void setA_answer(String A_answer){
        this.A_answer=A_answer;
    }

    public void setB_answer(String B_answer){
        this.B_answer=B_answer;
    }

    public void setC_answer(String C_answer){
        this.C_answer=C_answer;
    }

    public void setD_answer(String D_answer){
        this.D_answer=D_answer;
    }

    public void setSolution(String solution){
        this.solution=solution;
    }

}
