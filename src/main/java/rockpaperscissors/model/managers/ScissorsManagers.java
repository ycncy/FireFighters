package rockpaperscissors.model.managers;

import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.Position;
import rockpaperscissors.model.entities.Scissors;
import java.util.*;

public class ScissorsManagers implements EntityManager {

    private PaperManagers paperManager;

    private final int amount;

    private Set<Scissors> scissors = new HashSet<>();

    public ScissorsManagers(int amount, PaperManagers paperManager) {
        this.amount = amount;
        this.paperManager = paperManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) scissors.add(new Scissors(Position.randomPosition(rowCount, colCount)));
    }

    @Override
    public void update(int rowCount, int colCount) {
        Set<Scissors> updatedScissors = new HashSet<>();
        for (Scissors scissorsElement : scissors) {
            updatedScissors.add(scissorsElement);
            List<Position> possibleNewPositions = new ArrayList<>(scissorsElement.getPosition().next(rowCount, colCount));
            for (Position position : possibleNewPositions) {
                updatedScissors.add(new Scissors(position));
                if (paperManager.contains(position) != null) {
                    paperManager.killEntity(position);
                }
            }
        }
        scissors = updatedScissors;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(scissors);
    }

    public Scissors contains(Position position) {
        for (Scissors scissor : scissors) if (scissor.getPosition().equals(position)) return scissor;
        return null;
    }

    public void killEntity(Position position) {
        scissors.remove(contains(position));
    }
}
