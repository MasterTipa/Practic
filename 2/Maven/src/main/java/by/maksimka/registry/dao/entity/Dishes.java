package by.maksimka.registry.dao.entity;

public class Dishes {
    private long id;
    private long basket_id;
    private String name;
    private double cost;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasket_id(long basket_id) {
        this.basket_id = basket_id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
