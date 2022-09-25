package statistic.graph;

public enum GraphType {
    Color("color"),
    Name("name");

    private final String value;

    GraphType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
