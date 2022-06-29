package com.register.OrthodoxProject.TableInfo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DishesHasProviderId implements Serializable {
    private static final long serialVersionUID = -6573732666616859564L;
    @Column(name = "dish_id", nullable = false)
    private Long dishId;

    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishesHasProviderId entity = (DishesHasProviderId) o;
        return Objects.equals(this.providerId, entity.providerId) &&
                Objects.equals(this.dishId, entity.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, dishId);
    }

}