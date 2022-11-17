package View;

import Model.*;
import Util.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Grid extends Canvas {

    private final int width, height, colCount, rowCount;
    private Model model;
    private Visitor paintingVisitor;

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        paintingVisitor = new PaintingVisitor(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new Model(this);
        model.initialisation(3, 8);
    }

    public void restart(MouseEvent mouseEvent) {
        model = new Model(this);
        model.initialisation(3, 8);
        getGraphicsContext2D().clearRect(0, 0, width, height);
        repaint();
    }

    private void mousePressed(MouseEvent mouseEvent) {
        System.out.println(model.fireManager.fires.size());
        model.activation();
        repaint();
            /*double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            model.click((int)x*rowCount/height,(int)y*colCount/width);*/
    }

    public void repaint() {
        for (Position position : model.fireManager.fires) paintingVisitor.visitFire(new Fire(position));
        for (Position position : model.firefighters) paintingVisitor.visitFireFighter(new FireFighter(position));
        for (int col = 0; col < colCount; col++)
            getGraphicsContext2D().strokeLine(0, col * width / colCount, height, col * width / colCount);
        for (int row = 0; row < rowCount; row++)
            getGraphicsContext2D().strokeLine(row * height / rowCount, 0, row * height / rowCount, width);
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