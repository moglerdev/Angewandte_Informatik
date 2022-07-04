package aufgabe06.todo;

public class BasicActivity implements Activity {

    private double time;
    private String description;

    public BasicActivity(String description, double time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public double getTime(){
        return time;
    }

    @Override
    public void add(Activity a){
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Activity a){
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAmount(){
        return 1;
    }
}
