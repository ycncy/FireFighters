package generalstructure.model;

import generalstructure.model.entity.EntityManager;
import generalstructure.model.obstacle.ObstacleManager;

import java.util.*;

public class Model {

    private final int colCount, rowCount;

    private final List<EntityManager> entityManagers = new ArrayList<>();
    private final List<ObstacleManager> obstacleManagers = new ArrayList<>();

    public Model(int rowCount, int colCount) {
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public void initializeEntities () {
        for (EntityManager entityManager : this.entityManagers) entityManager.initialize(rowCount, colCount);
    }

    public void initializeObstacles () {
        for (ObstacleManager obstacleManagers : this.obstacleManagers) obstacleManagers.initialize(rowCount, colCount);
    }

    public void activation() {
        for (EntityManager entityManager : this.entityManagers) entityManager.update(rowCount, colCount);
    }

    public void addAllEntityManagers (EntityManager... entityManagers) {
        this.entityManagers.addAll(List.of(entityManagers));
    }

    public void addAllObstacleManagers (ObstacleManager... obstacleManagers) {
        this.obstacleManagers.addAll(List.of(obstacleManagers));
    }

    public List<EntityManager> getEntityManagers () {
        return entityManagers;
    }

    public List<ObstacleManager> getObstacleManagers () {
        return obstacleManagers;
    }
}