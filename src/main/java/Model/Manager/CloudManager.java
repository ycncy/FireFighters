package Model.Manager;

import Model.Entity.*;
import Util.Position;

import java.util.List;
import java.util.*;

public class CloudManager extends Manager {

    private final Extinguisher extinguisher;

    private List<Cloud> clouds = new ArrayList<>();

    public CloudManager(int amount, Extinguisher extinguisher) {
        super(amount);
        this.extinguisher = extinguisher;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) clouds.add(new Cloud(randomPosition(rowCount, colCount)));
    }

    @Override
    public void update(int rowCount, int colCount) {
        List<Cloud> cloudsNewPositions = new ArrayList<>();
        for (Cloud cloud : clouds) {
            extinguisher.extinguishFire(extinguisher.containsFire(cloud.getPosition()));
            for (Position position : cloud.getPosition().next(rowCount, colCount)) {
                extinguisher.extinguishFire(extinguisher.containsFire(position));
            }
            cloudsNewPositions.add(new Cloud(randomPosition(rowCount, colCount)));
        }
        clouds = cloudsNewPositions;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(clouds);
    }
}
