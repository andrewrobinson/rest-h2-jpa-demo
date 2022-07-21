package com.andrewrobinson.resth2jpademo.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Subscription {

    private @Id
    @GeneratedValue Long id;

    private String zser;

    @Basic
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    Subscription(){}

    Subscription(String zser, SubscriptionType subscriptionType) {

        this.zser = zser;
        this.subscriptionType = subscriptionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZser() {
        return zser;
    }

    public void setZser(String zser) {
        this.zser = zser;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Zser))
            return false;
        Subscription subscription = (Subscription) o;
        return Objects.equals(this.id, subscription.id) && Objects.equals(this.zser, subscription.zser)
                && Objects.equals(this.subscriptionType, subscription.subscriptionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.zser, this.subscriptionType);
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + this.id + ", zser='" + this.zser + '\'' + ", subscriptionType='" + this.subscriptionType + '\'' + '}';
    }

}
