package com.register.OrthodoxProject.TableInfo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DishesHasProviderId implements Serializable {
    private static final long serialVersionUID = -3576192633123803352L;
    @Column(name = "dishid", nullable = false)
    private Long dishid;

    @Column(name = "providerid", nullable = false)
    private Long providerid;

    public Long getDishid() {
        return dishid;
    }

    public void setDishid(Long dishid) {
        this.dishid = dishid;
    }

    public Long getProviderid() {
        return providerid;
    }

    public void setProviderid(Long providerid) {
        this.providerid = providerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishesHasProviderId entity = (DishesHasProviderId) o;
        return Objects.equals(this.providerid, entity.providerid) &&
                Objects.equals(this.dishid, entity.dishid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerid, dishid);
    }

}