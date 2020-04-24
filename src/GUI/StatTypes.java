package GUI;

public enum StatTypes {
    HUNGER("Hunger", "green"),
    HYGIENE("Hygiene", "blue"),
    SLEEP("Sleep", "orange"),
    HAPPINESS("Happiness", "red");

    private String label;
    private String color;

    StatTypes(String label, String color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }
}
