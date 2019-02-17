public class Track {

   private String name;

   private int length;

    private int value;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track(String name, int length, int value) {
        this.name = name;
        this.length = length;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getValue() {
        return value;
    }

}
