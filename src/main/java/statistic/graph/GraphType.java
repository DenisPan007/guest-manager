package statistic.graph;

public enum GraphType {
    COLOR("цвет", "Любимый цвет"),
    SCHOOL_SUBJECT("предмет", "Школьный предмет"),
    NAME("фильм/сериал", "Фильм или Сериал"),
    MUSIC("музыка", "Музыкальный жанр"),
    ANIMAL("животное", "Любимое животное"),
    DISH("блюдо", "Любимое блюдо"),
    DRINK("напиток", "Любимый напиток"),
    HOBBY("хобби", "Любимое занятие"),
    ISLAND("остров", "Один предмет на остров"),
    JOB("профессия", "Профессия мечты"),
    PETS("животные", "Сколько животных"),
    SUPER_ABILITY("способность", "Суперспособность"),
    RANDOM_NUMBER("число", "Случайное число"),
    AGE("возраст", "Возраст");

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
