package by.maksimka.registry.dao.entity;

public class Cafes {
    private long id;
    private String name;
    private String place;
    private double score;
    private int table_count;
    private int max_table;

    public void setId(long id) {
        this.id = id;
    }

    public void setMax_table(int max_table) {
        this.max_table = max_table;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTable_count(int table_count) {
        this.table_count = table_count;
    }
}
