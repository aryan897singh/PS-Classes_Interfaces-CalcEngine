package com.pluralsight.calcengine;

public class Subtractor extends  CalculateBase{

    public Subtractor(){}
    public Subtractor(double leftVal, double rightVal){super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = this.getLeftVal() - this.getRightVal();
        this.setResult(value);
    }
}
