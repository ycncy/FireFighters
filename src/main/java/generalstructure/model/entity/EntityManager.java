package generalstructure.model.entity;

import java.util.Set;

public interface EntityManager {

    void initialize (int rowCount, int colCount);
    void update (int rowCount, int colCount);
    Set<Entity> getEntities ();
}
