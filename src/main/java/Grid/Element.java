package Grid;

public interface Element {
    void accept(PaintingVisitor visitor);
}
