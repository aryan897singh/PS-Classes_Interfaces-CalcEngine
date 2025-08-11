package com.pluralsight.calcengine;

public class MathEquation  {
    /*
    //These are called fields of a class - define the state of a class. NOTE - we don't have psvm() yet here
    //We can make these fields private by using private keyword before data type (encapsulation!)

    //Learning object.method() uses () at the end
    //BUT object.field DOES NOT USE METHOD AT THE END

     */
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;


    void setLeftVal(double leftVal){
        this.leftVal = leftVal;
    }

    void setRightValVal(double rightVal){
        this.rightVal = rightVal;
    }

    void setOpCode(char opCode){
        this.opCode = opCode;
    }

    double getResult(){
        return this.result;
    }

    //Static fields set, only Static Methods can be used to access these fields
    private static int numberOfCalcs;
    private static double sumOfResults;
    private static double avgOfResults;

    public static int getNumberOfCalcs(){return numberOfCalcs;}
    public static double getSumOfResults(){return sumOfResults;}
    public static double getAvgOfResults(){return sumOfResults/numberOfCalcs;}

    public static void setNumberOfCalcs(){numberOfCalcs += 1;}
    public static void setSumOfResults(double sum){sumOfResults += sum;}

    public MathEquation(char opCode){
        this.opCode = opCode;
    } //The issue is, once we've defined this constructor, the default constructor that java provides is deleted
    //And so if we want to use a constructor with no inputs, we are going to have to explicitly state that

    public MathEquation(){}

    public MathEquation(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public MathEquation(char opCode, double leftval, double rightVal) {
        this(opCode); //CHAINING OF CONSTRUCTORS, SINCE ONLY OPCODE IS ALREADY MADE - Object(no. of parameters)
        this.leftVal = leftval;
        this.rightVal = rightVal;
    }

    public void execute(){
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        setSumOfResults(result);
    }

    //OVERLOADING:
    //NOW EXECUTE CAN BE CALLED, AND WHEN TWO VALUES ARE PUT IN, THE LEFT AND RIGHT VALS GET REWRITTEN, AND PREFORMS
    //AN OPERATION WITH A FIXED OPCODE
    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();

    }

    //NOW HERE, I OVERLOADED WITH THE ABILITY TO MODIFY ALL THREE VALUES IF NEEDED, WOAHHHHHHHHH !!!!
    public void execute(char opCode, double leftVal, double rightVal){
        this.opCode = opCode;
        this.execute(leftVal, rightVal);
    }

    public void execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        this.result = (int) result; //Basically converts the result into an int

    }

}
