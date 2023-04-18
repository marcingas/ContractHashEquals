package rankpage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Fraze {

    private String[]fraze;

    public Fraze(String[] fraze) {
        this.fraze = fraze;
    }

    public String[] getFraze() {
        return fraze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraze fraze1)) return false;
        return Arrays.equals(getFraze(), fraze1.getFraze());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getFraze());
    }

    @Override
    public String toString() {
        return  Arrays.toString(fraze);

    }
}
