package memo;

public class Player {

    private String name;
    private int counter;


    protected Player(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getCounter() {
        return counter;
    }

    protected void setCounter(int counter) {
        this.counter = counter;
    }

}
