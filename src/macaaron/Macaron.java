package macaaron;

import java.util.Objects;

public class Macaron {
    private String color;
    private Ingredients topping;

    public String getColor() {
        return color;
    }

    public Ingredients getTopping() {
        return topping;
    }

    public Macaron(String color, Ingredients topping) {
        this.color = color;
        this.topping = topping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Macaron macaron)) {
            return false;
        }
        return color.equals(macaron.color) && topping.equals(macaron.topping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, topping) + 25;
    }

    @Override
    public String toString() {
        return "macaaron.Macaron{" +
                "color='" + color + '\'' +
                topping;
    }
}
