

public class Quadratic {

    public Quadratic() {

    }

    public static void main(String[] args) {
        System.out.println("Quadratic Tests");
//        int a = Integer.parseInt(MyUtil.getInput("Please enter the x^2 coefficient", 0));
//        int b = Integer.parseInt(MyUtil.getInput("Please enter the x coefficient", 0));
//        int c = Integer.parseInt(MyUtil.getInput("Please enter the constant", 1));
//        System.out.println(getQuadFormat(quadFormula(a, b, c)));
        tests();
    }

    public static void tests() {
        System.out.println("Test: Should Handle 2 root");
        System.out.println(getQuadFormat(quadFormula(5,0,-10)));
        System.out.println("Test: Should Handle 2 root");
        System.out.println(getQuadFormat(quadFormula(1,-5,-2)));
        System.out.println("Test: Should Handle positive 1 root");
        System.out.println(getQuadFormat(quadFormula(1,0,0)));
        System.out.println("Test: Should Handle negative 1 root");
        System.out.println(getQuadFormat(quadFormula(-1,0,0)));
        System.out.println("Test: Should Handle imaginary roots");
        System.out.println(getQuadFormat(quadFormula(-4,-5,-33)));

    }



    public static double[] quadFormula(double a, double b, double c){
        double det = getDiscriminant(a, b, c);
        double ndet;
        if (det < 0) {
            //imaginary root
            ndet = Math.sqrt(-det);
        } else {
            // one or more roots
            ndet = Math.sqrt(det);
        }
        double rRoot = (-1*b + ndet)/(2* a);
        double lRoot = (-1*b - ndet)/(2* a);
        return new double[] {det, rRoot, lRoot};
    }

    public static double getDiscriminant(double a, double b, double c){
        return (b * b) - (4 * a * c);
    }
    public static String getQuadFormat(double[] rootList){
        String rootDecorator ="";
        if(rootList[0] < 0) {
            // The roots are imaginary
            rootDecorator = "i";
        }
        String formattedQuad = "The roots are "+rootList[1] + rootDecorator + " and " +rootList[2] + rootDecorator;
        return (formattedQuad);
    }
}
