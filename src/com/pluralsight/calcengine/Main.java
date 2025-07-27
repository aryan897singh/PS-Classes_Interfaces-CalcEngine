package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        performCalculations();
    }

    static void performCalculations() {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        MathEquation[] equations = new MathEquation[4]; //created 4 spaces for MathEquation type objects

        //creates MathEquation type objects and stores in above array
        for(int i = 0; i < leftVals.length ; i++){
            equations[i] = create(leftVals[i], rightVals[i], opCodes[i]);
        }

        //LEARNING - FOR EACH LOOP USES ':' AND FOR LOOP USES ';'
        for(MathEquation equation : equations){
            equation.execute();
            System.out.println("Result = " + equation.getResult());
        }

    }

    //creates MathEquation object based on values provided
    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal); //This new MathEquation() is calling upon a MathEquation constructor
        return equation;
    }

}



















