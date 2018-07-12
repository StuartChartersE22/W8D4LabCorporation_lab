package models;

import javax.persistence.*;

@Entity
@Table(name = "ceos")
public class CEO extends Employee {

    public CEO(){}

    public CEO(String name, String ni, double salary) {
        super(name, ni, salary);
    }

}
