package com.pluralsight.calcengine;

public abstract class CalculateBase {
    private double leftVal;
    private double rightVal;
    private double result;

    //default constructors
    public CalculateBase(){};

    public CalculateBase(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void setLeftVal(double a){this.leftVal = a;}
    public void setRightVal(double b){this.rightVal = b;}
    public void setResult(double c){this.result = c;}

    public double getLeftVal(){return this.leftVal;}
    public double getRightVal(){return this.rightVal;}
    public double getResult(){return this.result;}

    public abstract void  calculate();
    //ABSTRACT METHOD - NO BODY, ALWAYS EXPECTED TO BE OVERRIDEN


}
