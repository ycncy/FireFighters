package Model.Obstacle;

import View.PaintingVistor.Visitor;
import Util.*;
import java.util.*;

public abstract class Obstacle {

    protected Position position;

    public Obstacle (Position position) {
        this.position = position;
    }

    public abstract void accept (Visitor visitor);

    public Position getPosition () {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obstacle obstacle = (Obstacle) o;

        return Objects.equals(position, obstacle.position);
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
