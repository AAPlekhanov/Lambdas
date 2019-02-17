public class Artist {

    private String name;

    private boolean solo;

    public Artist(String name, boolean solo) {
        this.name = name;
        this.solo = solo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSolo() {
        return solo;
    }

    public void setSolo(boolean solo) {
        this.solo = solo;
    }
}
