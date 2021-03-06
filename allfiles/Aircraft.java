
public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.id = nextid();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextid() {
        return idCounter++;
    }
}