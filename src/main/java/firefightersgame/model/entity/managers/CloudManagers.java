package firefightersgame.model.entity.managers;

import generalstructure.model.Position;
import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.*;
import generalstructure.model.obstacle.ObstacleManager;

import java.util.*;

public class CloudManagers implements EntityManager {

    private final int amount;
    private int step = 0;

    private final Extinguisher extinguisher;

    private List<Cloud> clouds = new ArrayList<>();

    public CloudManagers (int amount, Extinguisher extinguisher) {
        this.amount = amount;
        this.extinguisher = extinguisher;
    }

    //Créé un nuage et 4 autres nuages autours pour faire un nuage de 5 cases
    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) {
            Cloud cloud = new Cloud(Position.randomPosition(rowCount, colCount));
            clouds.add(cloud);
            for (Position position : cloud.getPosition().next(rowCount, colCount)) {
                clouds.add(new Cloud(position));
            }
        }
    }

    @Override
    public void update(int rowCount, int colCount) {
        if (step % 2 == 0) {
            List<Cloud> cloudsNewPositions = new ArrayList<>();
            for (Cloud cloud : clouds) {
                extinguisher.extinguishFire(extinguisher.containsFire(cloud.getPosition()));
                for (Position position : cloud.getPosition().next(rowCount, colCount)) {
                    extinguisher.extinguishFire(extinguisher.containsFire(position));
                }
            }
            for (int index = 0; index < amount; index++) {
                Cloud cloud = new Cloud(Position.randomPosition(rowCount, colCount));
                cloudsNewPositions.add(cloud);
                for (Position position : cloud.getPosition().next(rowCount, colCount)) {
                    cloudsNewPositions.add(new Cloud(position));
                }
            }
            clouds = cloudsNewPositions;
        }
        step++;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(clouds);
    }
}
