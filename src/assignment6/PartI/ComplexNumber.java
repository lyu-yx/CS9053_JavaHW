package assignment6.PartI;

public class ComplexNumber extends Number implements Cloneable{
    private double imaginary;
    private double real;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    @Override
    public int intValue() {
        return (int)real;
    }

    @Override
    public long longValue() {
        return (long)real;
    }

    @Override
    public float floatValue() {
        return (float)real;
    }

    @Override
    public double doubleValue() {
        return (double)real;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }
    public void setReal(double real) {
        this.real = real;
    }

    public ComplexNumber add(ComplexNumber addComplexNumber) {
        ComplexNumber addResult = new ComplexNumber(real + addComplexNumber.getReal(),
                                                    imaginary + addComplexNumber.getImaginary());
        return addResult;
    }

    public ComplexNumber subtract(ComplexNumber subtractComplexNumber) {
        ComplexNumber subtractResult = new ComplexNumber(real - subtractComplexNumber.getReal(),
                                                         imaginary - subtractComplexNumber.getImaginary());
        return subtractResult;
    }

    public ComplexNumber multiply(ComplexNumber multiplyComplexNumber) {
        ComplexNumber multiplyResult = new ComplexNumber
            (real * multiplyComplexNumber.getReal() - imaginary * multiplyComplexNumber.getImaginary(),
             imaginary * multiplyComplexNumber.getReal() + real * multiplyComplexNumber.getImaginary());
        return multiplyResult;
    }



    public ComplexNumber divide(ComplexNumber divideComplexNumber) {
        double dominator = Math.pow(divideComplexNumber.getImaginary(), 2)
                         + Math.pow(divideComplexNumber.getReal(), 2);
        double realPart = (real * divideComplexNumber.getReal() + imaginary * divideComplexNumber.getImaginary())/dominator;
        double imaginaryPart = (imaginary * divideComplexNumber.getReal() - real * divideComplexNumber.getImaginary())/dominator;
        ComplexNumber divideResult = new ComplexNumber(realPart, imaginaryPart);
        return divideResult;
    }

    public double abs() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    @Override
    public String toString() {
         if (imaginary == 0) {
            return String.valueOf(real);
        } else {
            return real + " " + "+" + " " + imaginary + "i";
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new ComplexNumber(real, imaginary);
    }



        public static void main(String[] args) {
                Double testNan1 = new Double(5/0);
                Double testNan = new Double(5) / new Double(0);
                System.out.println(testNan);
                System.out.println(5.0/0);
                return;
        }

}
