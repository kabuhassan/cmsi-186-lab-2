import java.util.HashSet;
public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
        if (people < 2) {
            throw new IllegalArgumentException("At least two people required");

        }
        if (trials < 1) {
            throw new IllegalArgumentException("At least one trial required");
        }
        if (days < 1) {
            throw new IllegalArgumentException("At least one day required");
        }
        var shared = 0;
        for (var i = 0; i < trials; i++) {
            if (randomTrialHasSharedBirthday(people, days)) {
                shared += 1;
            }
        } 
        //
        // TODO: Do the main work here. I've just returned 0.0 as a place holder
        // so the code compiles. It isn't right though. Remove the return here and
        // implement the whole method on your own.
        //
        return (double)shared / trials;
    }

    //
    static boolean randomTrialHasSharedBirthday(int people, int days) {
        var birthdays = new HashSet<Integer>();
        for (var i = 0; i < people; i++){
            var birthday = (int)(Math.random()*days);
            if(!birthdays.add(birthday)){
                return true;
            }
        } 
        return false;
    }
}
