package com.register.OrthodoxProject.TableInfo;

import javax.persistence.*;

@Entity
@Table(name = "cafes")
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "place", nullable = false, length = 45)
    private String place;

    @Column(name = "score", nullable = false)
    private Double score;

    @Column(name = "table_cout", nullable = false)
    private Integer tableCout;

    @Column(name = "max_table", nullable = false)
    private Integer maxTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getTableCout() {
        return tableCout;
    }

    public void setTableCout(Integer tableCout) {
        this.tableCout = tableCout;
    }

    public Integer getMaxTable() {
        return maxTable;
    }

    public void setMaxTable(Integer maxTable) {
        this.maxTable = maxTable;
    }

}