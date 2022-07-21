package com.andrewrobinson.resth2jpademo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public
class Zser {

    private @Id @GeneratedValue Long id;
    private String username;
    private String password;

    Zser() {}

    Zser(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Zser))
            return false;
        Zser employee = (Zser) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.username, employee.username)
                && Objects.equals(this.password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.password);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", username='" + this.username + '\'' + ", password='" + this.password + '\'' + '}';
    }
}