import java.util.Objects;

public class Ingredients {
    private boolean sugar;
    private String toppingColor;

    public Ingredients(boolean sugar, String toppingColor) {
        this.sugar = sugar;
        this.toppingColor = toppingColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredients that)) return false;
        return sugar == that.sugar && toppingColor.equals(that.toppingColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sugar, toppingColor) + 11;
    }

    @Override
    public String toString() {
        return "Ingredients:" +
                "sugar=" + sugar +
                ", toppingColor=" + toppingColor + '\'';
    }
}
