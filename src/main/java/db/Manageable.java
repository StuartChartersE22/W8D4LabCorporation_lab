package db;

import models.Manager;

public interface Manageable {

    Manager getManager();
    void setManager(Manager manager);
}
