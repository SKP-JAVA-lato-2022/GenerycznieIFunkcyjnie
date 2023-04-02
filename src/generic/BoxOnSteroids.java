package generic;

public class BoxOnSteroids<T> {

    private final T fruit;

    public BoxOnSteroids(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }
}
