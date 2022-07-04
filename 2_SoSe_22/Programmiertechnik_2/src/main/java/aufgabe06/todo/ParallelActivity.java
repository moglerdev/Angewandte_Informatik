package aufgabe06.todo;

public class ParallelActivity extends CompoundActivity {

    @Override
    public double getTime() {
        double longestTimeNeeded = 0.0;
        for (Activity activity : activityList) {
            if(activity.getTime() > longestTimeNeeded) {
                longestTimeNeeded = activity.getTime();
            }
        }
        return longestTimeNeeded;
    }
}
