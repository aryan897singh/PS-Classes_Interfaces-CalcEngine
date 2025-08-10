package com.pluralsight.calcengine;

public class Adder extends CalculateBase {

    public Adder(){}

    public Adder(double leftVal, double rightVal){super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = this.getLeftVal() + this.getRightVal();
        this.setResult(value);
    }

}
