package models;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private double budget;
    private Department department;

    public Manager(String name, String ni, double salary, double budget, Department department){
        super(name, ni, salary);
        this.budget = budget;
        this.department = department;

    }

    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
