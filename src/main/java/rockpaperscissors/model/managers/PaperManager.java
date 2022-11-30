package rockpaperscissors.model.managers;

import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.model.Position;
import rockpaperscissors.model.entities.Paper;

import java.util.*;

public class PaperManager extends EntityManager {

    private RockManager rockManager;

    private Set<Paper> papers = new HashSet<>();

    public PaperManager(int amount, RockManager rockManager, ObstacleVisitor... obstacleVisitors) {
        super(amount, obstacleVisitors);
        this.rockManager = rockManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) papers.add(new Paper(randomPosition(rowCount, colCount)));
    }

    @Override
    public void update(int rowCount, int colCount) {
        Set<Paper> updatedPapers = new HashSet<>();
        for (Paper paper : papers) {
            updatedPapers.add(paper);
            List<Position> possibleNewPositions = new ArrayList<>(paper.getPosition().next(rowCount, colCount));
            for (Position position : possibleNewPositions) {
                updatedPapers.add(new Paper(position));
                if (rockManager.contains(position) != null) {
                    rockManager.killEntity(position);
                }
            }
        }
        papers = updatedPapers;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(papers);
    }

    public Paper contains(Position position) {
        for (Paper paper : papers) if (paper.getPosition().equals(position)) return paper;
        return null;
    }

    public void killEntity(Position position) {
        papers.remove(contains(position));
    }
}
