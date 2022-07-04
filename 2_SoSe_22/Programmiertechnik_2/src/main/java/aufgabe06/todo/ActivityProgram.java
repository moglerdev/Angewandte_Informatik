package aufgabe06.todo;

public final class ActivityProgram {

    private ActivityProgram() { }

    public static void main(String[] args) {
        Activity tk1 = new ParallelActivity();
        tk1.add(new BasicActivity("Linke Seitenwand montieren", 5.0));
        tk1.add(new BasicActivity("Rechte Seitenwand montieren", 5.0));

        Activity tk2 = new ParallelActivity();
        tk2.add(new BasicActivity("Linke Türe montieren", 7.0));
        tk2.add(new BasicActivity("Rechte Türe mit Griff montieren", 9.0));


        Activity schrankMontage = new SerialActivity();
        schrankMontage.add(new BasicActivity("Füße an Boden montieren", 6.0));
        schrankMontage.add(tk1);
        schrankMontage.add(new BasicActivity("Decke montieren", 8.0));
        schrankMontage.add(tk2);

        System.out.println(schrankMontage.getTime() + " min"); // 28.0 min
        System.out.println(schrankMontage.getAmount()); // 6

    }
}
