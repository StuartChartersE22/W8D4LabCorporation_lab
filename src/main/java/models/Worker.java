package models;

import db.Manageable;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class Worker extends Employee implements Manageable {

    private Manager manager;

    public Worker(){}

    public Worker(String name, String ni, double salary, Manager manager) {
        super(name, ni, salary);
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
