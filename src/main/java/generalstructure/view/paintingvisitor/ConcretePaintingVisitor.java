package generalstructure.view.paintingvisitor;

import firefightersgame.model.entity.entities.*;
import firefightersgame.model.obstacle.obstacles.Mountain;
import firefightersgame.model.obstacle.obstacles.Road;
import generalstructure.view.Grid;
import rockpaperscissors.model.entities.Paper;
import rockpaperscissors.model.entities.Rock;
import rockpaperscissors.model.entities.Scissors;
import javafx.scene.paint.Color;

public class ConcretePaintingVisitor implements PaintingVisitor {

    private final Grid grid;

    public ConcretePaintingVisitor(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void visitEmptyBox(EmptyBox emptyBox) {
        grid.getGraphicsContext2D().setFill(Color.BEIGE);
        grid.getGraphicsContext2D().fillRect(emptyBox.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                emptyBox.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitFireFighter(FireFighter fireFighter) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        grid.getGraphicsContext2D().drawImage(fireFighter.image, fireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                fireFighter.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitFire(Fire fire) {
        grid.getGraphicsContext2D().setFill(Color.RED);
        grid.getGraphicsContext2D().drawImage(fire.image, fire.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                fire.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitCloud(Cloud cloud) {
        grid.getGraphicsContext2D().setFill(Color.DARKGRAY);
        grid.getGraphicsContext2D().drawImage(cloud.image, cloud.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                cloud.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter) {
        grid.getGraphicsContext2D().setFill(Color.BLACK);
        grid.getGraphicsContext2D().drawImage(motorizedFireFighter.image, motorizedFireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                motorizedFireFighter.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitMountain(Mountain mountain) {
        grid.getGraphicsContext2D().setFill(Color.BROWN);
        grid.getGraphicsContext2D().drawImage(mountain.image, mountain.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                mountain.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitRoad(Road road) {
        grid.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        grid.getGraphicsContext2D().drawImage(road.image, road.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                road.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void visitRock(Rock rock) {
        grid.getGraphicsContext2D().setFill(Color.RED);
        grid.getGraphicsContext2D().fillRect(rock.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                rock.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitPaper(Paper paper) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        grid.getGraphicsContext2D().fillRect(paper.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                paper.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitScissors(Scissors scissors) {
        grid.getGraphicsContext2D().setFill(Color.GREEN);
        grid.getGraphicsContext2D().fillRect(scissors.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                scissors.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }
}
