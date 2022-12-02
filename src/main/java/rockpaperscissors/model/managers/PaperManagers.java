package rockpaperscissors.model.managers;

import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.Position;
import rockpaperscissors.model.entities.Paper;
import java.util.*;

public class PaperManagers implements EntityManager {

    private RockManagers rockManager;

    private final int amount;

    private Set<Paper> papers = new HashSet<>();

    public PaperManagers(int amount, RockManagers rockManager) {
        this.amount = amount;
        this.rockManager = rockManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) papers.add(new Paper(Position.randomPosition(rowCount, colCount)));
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
