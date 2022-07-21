package com.andrewrobinson.resth2jpademo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subscription {

    private @Id
    @GeneratedValue Long id;

    private String natwestUser;

    @Basic
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    public Subscription() {
    }

    Subscription(String natwestUser, SubscriptionType subscriptionType) {

        this.natwestUser = natwestUser;
        this.subscriptionType = subscriptionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatwestUser() {
        return natwestUser;
    }

    public void setNatwestUser(String zser) {
        this.natwestUser = zser;
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
        if (!(o instanceof NatwestUser))
            return false;
        Subscription subscription = (Subscription) o;
        return Objects.equals(this.id, subscription.id) && Objects.equals(this.natwestUser, subscription.natwestUser)
                && Objects.equals(this.subscriptionType, subscription.subscriptionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.natwestUser, this.subscriptionType);
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + this.id + ", user='" + this.natwestUser + '\'' + ", subscriptionType='" + this.subscriptionType + '\'' + '}';
    }

}
