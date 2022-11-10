package Util;

import Grid.*;
import java.util.ArrayList;
import java.util.List;

public record Position(int row, int col) {

    public List<Position> next(Position position, Grid grid) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < grid.getRowCount() - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < grid.getColCount() - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }
}
