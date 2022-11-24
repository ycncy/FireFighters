package View;

public class GridParameters {

    private final int width, height, colCount, rowCount;

    public GridParameters(int width, int height, int colCount, int rowCount) {
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
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
