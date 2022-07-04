package aufgabe06.todo;

public interface Activity {
    /**
     * Gibt die
     * @return
     */
    public double getTime();

    public void add(Activity activity);

    public void remove(Activity activity);

    public int getAmount();
}
