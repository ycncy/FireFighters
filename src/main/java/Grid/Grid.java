package Grid;

import Model.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Grid extends Canvas {

    private double width;
    private double height;
    private double colCount;
    private double rowCount;
    private Model model;
    private Visitor paintingVisitor = new PaintingVisitor();

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new Model(this);
        model.initialisation(3, 8);
    }

    public void restart(MouseEvent mouseEvent) {
        model = new Model(this);
        model.initialisation(3, 6);
        getGraphicsContext2D().clearRect(0, 0, width, height);
        repaint();
    }

    private void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        repaint();
    }

    public void activation () {
        for (Element element : model.getElements()) {
            element.accept(paintingVisitor);
        }
    }

    public void repaint() {
        for (int col = 0; col < colCount; col++)
            getGraphicsContext2D().strokeLine(0, col * width / colCount, height, col * width / colCount);
        for (int row = 0; row < rowCount; row++)
            getGraphicsContext2D().strokeLine(row * height / rowCount, 0, row * height / rowCount, width);
        for (Element element : elements) {
            element.accept(paintingVisitor);
        }
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    //**********************GETTERS**************************//

    public double getGridWidth() {
        return width;
    }

    public double getGridHeight() {
        return height;
    }

    public double getColCount() {
        return colCount;
    }

    public double getRowCount() {
        return rowCount;
    }

    public Model getModel() {
        return model;
    }
}