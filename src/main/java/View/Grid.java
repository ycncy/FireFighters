package View;

import Model.*;
import Model.Entity.*;
import Model.Entity.Entities.*;
import Model.Entity.Manager.*;
import Model.Obstacle.Manager.*;
import Model.Obstacle.Obstacle;
import Model.Visitor.ObstacleVisitor.*;
import View.PaintingVistor.*;
import Util.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Grid extends Canvas {

    private final int width, height, colCount, rowCount;

    private Model model;
    private final Visitor paintingVisitor;
    private ObstacleVisitor mountainVisitor;
    private ObstacleVisitor roadVisitor;

    public Grid (int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;

        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);

        paintingVisitor = new PaintingVisitor(this);

        model = new Model(rowCount, colCount);

        //CRÉATION DES OBSTACLES
        MountainManager mountainManager = new MountainManager(2);
        RoadManager roadManager = new RoadManager(2);

        model.addAllObstacleManagers(mountainManager, roadManager);

        model.initializeObstacles();

        mountainVisitor = new MountainVisitor(mountainManager);
        roadVisitor = new RoadVisitor(roadManager);

        //CRÉATION DES ENTITÉS
        FireManager fireManager = new FireManager(2, mountainVisitor, roadVisitor);
        FireFighterManager fireFighterManager = new FireFighterManager(3, fireManager, mountainVisitor, roadVisitor);
        //CloudManager cloudManager = new CloudManager(5, fireManager, mountainVisitor, roadVisitor);
        //MotorizedFireFighterManager motorizedFireFighterManager = new MotorizedFireFighterManager(2, fireManager, mountainVisitor, roadVisitor);

        model.addAllEntityManagers(fireManager, fireFighterManager);
        model.initializeEntities();

        repaint();
    }

    public void restart(MouseEvent mouseEvent) {

        model = new Model(rowCount, colCount);

        //CRÉATION DES OBSTACLES
        MountainManager mountainManager = new MountainManager(2);
        RoadManager roadManager = new RoadManager(2);

        model.addAllObstacleManagers(mountainManager, roadManager);

        model.initializeObstacles();

        mountainVisitor = new MountainVisitor(mountainManager);
        roadVisitor = new RoadVisitor(roadManager);

        //CRÉATION DES ENTITÉS
        FireManager fireManager = new FireManager(3, mountainVisitor, roadVisitor);
        FireFighterManager fireFighterManager = new FireFighterManager(3, fireManager, mountainVisitor, roadVisitor);
        //CloudManager cloudManager = new CloudManager(2, fireManager, mountainVisitor, roadVisitor);
        //MotorizedFireFighterManager motorizedFireFighterManager = new MotorizedFireFighterManager(2, fireManager, mountainVisitor, roadVisitor);

        model.addAllEntityManagers(fireManager, fireFighterManager);
        model.initializeEntities();

        repaint();
    }

    private void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        repaint();
    }

    public void repaint() {
        for (int col = 0; col < colCount; col++) for (int row = 0; row < rowCount; row++) paintingVisitor.visitEmptyBox(new EmptyBox(new Position(row, col)));

        for (ObstacleManager obstacleManager : model.getObstacleManagers()) for (Obstacle obstacle : obstacleManager.getObstacles()) obstacle.accept (paintingVisitor);
        for (EntityManager entityManager : model.getEntityManagers()) for (Entity entity : entityManager.getEntities()) entity.accept (paintingVisitor);

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

    public Model getModel() {
        return model;
    }
}