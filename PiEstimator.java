public class PiEstimator {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Exactly one argument required");
            }
            System.out.println(estimate(Integer.parseInt(args[0])));  
            // TODO: Parse the command line argument and call your estimate function
            
        } catch (NumberFormatException e) {
            System.err.println("Argument must be an integer");
            // TODO: Take care of a possible non-integer argument.
            //
        } catch (IllegalArgumentException e) {
            
            // TODO: Take care of the exception you threw above.
            System.err.println(e.getMessage());
        }
    }

    public static double estimate(int darts) {
        if (darts < 1) {
            throw new IllegalArgumentException("At least one dart required");
        }
        var inside = 0;
        for (var i = 0; i < darts; i++){
            if (Math.hypot(Math.random(), Math.random()) < 1){
                inside = inside+1;
            }
        
        }
        return ((double)inside/darts)*4;
        
        
    }

    //
    // Don't be afraid to put in some private "helper" methods. You don't have to, of
    // course, but they could be useful and keep your code modular.
    //
}
