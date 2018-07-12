package models;

public class Administrator extends Employee{
    private Manager manager;


    public Administrator(String name, String ni, double salary, Manager manager){
        super(name, ni, salary);
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}