package aufgabe06.todo;

import java.util.ArrayList;

public abstract class CompoundActivity implements Activity {
    protected ArrayList<Activity> activityList = new ArrayList<>();

    @Override
    public void add(Activity activity) {
        activityList.add(activity);
    }

    @Override
    public void remove(Activity activity) {
        activityList.remove(activity);
    }

    @Override
    public int getAmount() {
        int result = 0;
        for(Activity activity : activityList) {
            result += activity.getAmount();
        }
        return result;
    }
}
