package Model;

import Model.Manager.*;
import java.util.*;

public class Model {

    private final int colCount, rowCount;

    public List<Manager> managers = new ArrayList<>();

    public Model(int rowCount, int colCount, Manager... managers) {
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.managers.addAll(List.of(managers));
    }

    public void initialisation() {
        for (Manager manager : managers) manager.initialize(rowCount, colCount);
    }

    public void activation() {
        for (Manager manager : managers) manager.update(rowCount, colCount);
    }
}
