package generalstructure.view;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.*;
import generalstructure.model.Model;
import generalstructure.model.obstacle.*;

import generalstructure.model.Position;

import generalstructure.view.paintingvisitor.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public abstract class Grid extends Canvas {

    protected final int width, height, colCount, rowCount;

    protected Model model;
    protected PaintingVisitor paintingPaintingVisitor;

    public Grid (int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;

        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        paintingPaintingVisitor = new ConcretePaintingVisitor(this);

        model = new Model(rowCount, colCount);
    }

    public abstract void initialisation ();

    public void update () {
        model.activation();
        repaint();
    }

    public void restart (MouseEvent mouseEvent) {
        initialisation();
        repaint();
    }

    private void mousePressed(MouseEvent mouseEvent) {
        update();
    }

    public void repaint() {
        for (int col = 0; col < colCount; col++) for (int row = 0; row < rowCount; row++) paintingPaintingVisitor.visitEmptyBox(new EmptyBox(new Position(row, col)));

        if (model.getObstacleManagers() != null) for (ObstacleManager obstacleManagers : model.getObstacleManagers()) for (Obstacle obstacle : obstacleManagers.getObstacles()) obstacle.accept (paintingPaintingVisitor);
        if (model.getEntityManagers() != null) for (EntityManager entityManager : model.getEntityManagers()) for (Entity entity : entityManager.getEntities()) entity.accept (paintingPaintingVisitor);

        for (int col = 0; col < colCount; col++) getGraphicsContext2D().strokeLine(0, col * width / colCount, height, col * width / colCount);
        for (int row = 0; row < rowCount; row++) getGraphicsContext2D().strokeLine(row * height / rowCount, 0, row * height / rowCount, width);
    }

    public int getGridWidth() {
        return width;
    }

    public int getGridHeight() {
        return height;
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }
}