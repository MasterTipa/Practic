package com.register.OrthodoxProject.TableInfo;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Order getOrder(){return order;}

    public void setOrder(Order order) {
        this.order = order;
    }
    //TODO [JPA Buddy] generate columns from DB
}