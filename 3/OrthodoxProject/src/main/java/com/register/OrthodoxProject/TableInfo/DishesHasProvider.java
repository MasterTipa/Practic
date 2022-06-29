package com.register.OrthodoxProject.TableInfo;

import javax.persistence.*;

@Entity
@Table(name = "dishes_has_providers")
public class DishesHasProvider {
    @EmbeddedId
    private DishesHasProviderId id;

    @MapsId("dishId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @MapsId("providerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    public DishesHasProviderId getId() {
        return id;
    }

    public void setId(DishesHasProviderId id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}