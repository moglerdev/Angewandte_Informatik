package aufgabe06.todo;

public class SerialActivity extends CompoundActivity {

    @Override
    public double getTime(){
        double tmp = 0;

        for(Activity act : activityList) {
            tmp += act.getTime();
        }
        return tmp;
    }
}
