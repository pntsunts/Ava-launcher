
public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    Aircraft(String name, Coordinates coordinates){
        this.id = nextid();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextid() {
        return (idCounter++);
    }
}