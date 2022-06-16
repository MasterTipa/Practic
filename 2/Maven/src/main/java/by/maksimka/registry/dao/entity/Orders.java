package by.maksimka.registry.dao.entity;

public class Orders {
    private long id;
    private long cafe_id;
    private long client_id;
    private double bill;
    private int table_number;

    public void setCafe_id(long cafe_id) {
        this.cafe_id = cafe_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }
}
