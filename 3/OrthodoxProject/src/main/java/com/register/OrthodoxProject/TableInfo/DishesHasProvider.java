package com.register.OrthodoxProject.TableInfo;

import javax.persistence.*;

@Entity
@Table(name = "dishes_has_providers")
public class DishesHasProvider {
    @EmbeddedId
    private DishesHasProviderId id;

    @MapsId("dishid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dishid", nullable = false)
    private Dish dishid;

    @MapsId("providerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "providerid", nullable = false)
    private Provider providerid;

    public DishesHasProviderId getId() {
        return id;
    }

    public void setId(DishesHasProviderId id) {
        this.id = id;
    }

    public Dish getDishid() {
        return dishid;
    }

    public void setDishid(Dish dishid) {
        this.dishid = dishid;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

}