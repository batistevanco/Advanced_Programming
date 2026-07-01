package be.vives.ti.map;

public record Student(String rNumber, String name, String className) {

    @Override
    public int hashCode() {
        return name.length();
    }

}