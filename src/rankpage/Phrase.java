package rankpage;

import java.util.Arrays;

public class Phrase {

    private String[]fraze;

    public Phrase(String[] fraze) {
        this.fraze = fraze;
    }

    public String[] getFraze() {
        return fraze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phrase phrase1)) return false;
        return Arrays.equals(getFraze(), phrase1.getFraze());
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
