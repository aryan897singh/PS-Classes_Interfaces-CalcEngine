package com.pluralsight.calcengine;
import java.util.Scanner;

import static com.pluralsight.calcengine.MathEquation.*; //Basically we imported ALL static methods
//IF WE WANT ONLY SPECIFIC METHOD: import static package.class.staticMethodName; (Only staticMethodName can be used here then)

//LATEST LEARNING : VARIABLE PARAMETER LENGTH ex. public void addPassengers(Passenger... list)  - here list is a var array of
//reference type Passengers, and note: Only the last parameter of a method can be variable length

public class Main {
    //NEW LEARNING - MAIN METHOD IS A STATIC METHOD AND CAN ONLY CALL OTHER MAIN METHODS
    public static void main(String[] args) {
        /*preformMoreCalculations();         */
/*
        int no = getNumberOfCalcs(); //DON'T FORGET - CALLING STATIC METHODS: class.staticMethod();
                                                  //Now since we imported all static methods of MathEquation class, we can
                                                  //simply write the method name as done here
        System.out.println(no);

        double summ = getSumOfResults();
        System.out.println("sum = " + summ);

        double avg = getAvgOfResults();
        System.out.println("Average = "+ avg );

        Divider divider = new Divider();
        doCalculation(divider, 100, 5);

        Adder adder = new Adder();
        doCalculation(adder, 5, 10);

 */
        //INTERACTIVE MODE:
        CalculateBase object = executeInteractively();
        object.calculate();
        System.out.println("INTERACTIVE RESULT = " + object.getResult());

    }

    //This creates a new object based on the type of calculation we want to do, then in main method, just one method for all
    public static CalculateBase calculateBase(MathOperation operation, double leftVal, double rightVal){
        switch (operation){
            case ADD:
                return new Adder(leftVal, rightVal); //WHEN CREATING NEW OBJECT FROM SELF MADE CLASS ALWAYS USE 'NEW'!!!

            case SUBTRACT:
                return new Subtractor(leftVal, rightVal);

            case MULTIPLY:
                return new Multiplier(leftVal, rightVal);

            case DIVIDE:
                return new Divider(leftVal, rightVal);
            default:
                return null;
        }

    }

    public static CalculateBase executeInteractively(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an operation: \n1. Add (+) \n2. Subtract (-) \n3. Multiply (*) \n4. Divide (/))");
        String op = input.nextLine();
        System.out.println("Enter First number");
        double num1 = input.nextInt();
        System.out.println("Enter Second number ");
        double num2 = input.nextInt();

        MathOperation opCode = null;
        if (op.charAt(0) == '+' || op.charAt(0) == 'a' || op.charAt(0) == '1'){ opCode = MathOperation.ADD;}
        else if (op.charAt(0) == '-' || op.charAt(0) == 's' || op.charAt(0) == '2' ) {
             opCode = MathOperation.SUBTRACT; }
        else if (op.charAt(0) == '*' || op.charAt(0) == 'm' || op.charAt(0) == '3' || op.charAt(0) == 'p') {
             opCode = MathOperation.MULTIPLY; }
        else if (op.charAt(0) == '/' || op.charAt(0) == 'd' || op.charAt(0) == '4' || op.charAt(0) == 'q'){
             opCode = MathOperation.DIVIDE; }
        return calculateBase(opCode, num1, num2);

    }

    /*static void performCalculations() {
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

        //So now we created a new object and passed in the opCode, so it called the rqrd constructor which set opcode field
        //Then we called execute method on the object where we passed 2 values, which set left val and right val fields and calculated
        MathEquation equationOverLoad = new MathEquation('d');
            double leftDouble = 9;
            double rightDouble = 4;
            equationOverLoad.execute(leftDouble, rightDouble);
        System.out.println("Overloaded result with doubles = " + equationOverLoad.getResult());

        MathEquation integerDivisionEquation = new MathEquation('d');
        int leftVal = 9;
        int rightVal = 4;
        integerDivisionEquation.execute(leftVal, rightVal);
        System.out.println("Overloaded result with integers = " + integerDivisionEquation.getResult());




    }

     */

    static void preformMoreCalculations(){
        CalculateBase[] calculations = {
                new Divider(100.0, 5.0),
                new Adder(25.0, 92.0),
                new Subtractor(225.0, 17.0),
                new Multiplier(11.0, 3.0)};

        System.out.println("\n ARRAY CALCULATIONS");
        for(int i = 0; i < calculations.length ; i++){
            calculations[i].calculate();
            System.out.println(calculations[i].getResult());
        }
    }

    //creates MathEquation object based on values provided
    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal); //This new MathEquation() is calling upon a MathEquation constructor
        MathEquation.setNumberOfCalcs();
        return equation;
        //MathEquation.setNumberOfCalcs(); NOTE!!!! The return statement immediately exits method, hence this is unreachable
    }

    public static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }








}



















