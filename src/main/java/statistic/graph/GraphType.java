package statistic.graph;

public enum GraphType {
    COLOR("цвет", "Любимый цвет"),
    SCHOOL_SUBJECT("предмет", "Школьный предмет"),
    NAME("фильм/сериал", "Фильм или Сериал");

    private final String value;
    private final String title;

    GraphType(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public static GraphType fromString(String text) {
        for (GraphType b : GraphType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new RuntimeException("There isn't enum of value: " + text);
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return value;
    }
}
