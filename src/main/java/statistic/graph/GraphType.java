package statistic.graph;

public enum GraphType {
    Color("color"),
    Name("name");

    private final String value;

    GraphType(String value) {
        this.value = value;
    }

    public static GraphType fromString(String text) {
        for (GraphType b : GraphType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new RuntimeException("There isn't enum of value: " + text);
    }

    @Override
    public String toString() {
        return value;
    }
}
