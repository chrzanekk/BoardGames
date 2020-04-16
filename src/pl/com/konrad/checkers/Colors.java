package pl.com.konrad.checkers;

public enum Colors {
    WHITE("white"),
    BLACK("black");
    private final String description;

    Colors(String description) {
        this.description = description;
    }

     String Description() {
        return description;
    }
}
