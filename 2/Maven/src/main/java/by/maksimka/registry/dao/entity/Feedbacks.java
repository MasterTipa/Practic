package by.maksimka.registry.dao.entity;

public class Feedbacks {
    private long id;
    private long cafe_id;
    private String feedback;
    private double score;

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setCafe_id(long cafe_id) {
        this.cafe_id = cafe_id;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
