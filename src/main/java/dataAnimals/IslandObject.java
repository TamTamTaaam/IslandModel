package dataAnimals;

public abstract class IslandObject {
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IslandObject other = (IslandObject) o;
        return true;
    }


    public int hashCode() {
        int result = 1;
        return result;
    }
}
