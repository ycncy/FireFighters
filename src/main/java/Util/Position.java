package Util;

import java.util.ArrayList;
import java.util.List;

public record Position(int row, int col ) {

    public List<Position> next(Position position, int rowCount, int colCount) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < rowCount - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < colCount - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }
}
