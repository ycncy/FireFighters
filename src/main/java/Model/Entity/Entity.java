package Model.Entity;

import Model.Visitor.Visitor;
import Util.Position;

public abstract class Entity {

    protected Position position;

    public Entity(Position position) {
        this.position = position;
    }

    public abstract void accept(Visitor visitor);

    public Position getPosition () {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return position != null ? position.equals(entity.position) : entity.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
