package ru.gb.learn.complexcalc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;

@RequiredArgsConstructor
@Getter
public class Complex {

    private static final DecimalFormat df = new DecimalFormat("#.##");
    private final float Rez;
    private final float Imz;

    public Complex add(Complex c) {
        return new Complex(this.Rez + c.Rez, this.Imz + c.Imz);
    }

    public Complex subtract(Complex c) {
        return new Complex(this.Rez - c.Rez, this.Imz - c.Imz);
    }

    public Complex multiply(Complex c) {
        return new Complex(this.Rez * c.Rez - this.Imz * c.Imz,
                this.Imz * c.Rez + this.Rez * c.Imz);
    }

    public Complex divide(Complex c) {
        if (c.Rez == 0 && c.Imz == 0) throw new ArithmeticException("Division by zero");
        float base = c.Rez * c.Rez + c.Imz * c.Imz;
        return new Complex((this.Rez * c.Rez + this.Imz * c.Imz) / base,
                (this.Imz * c.Rez - this.Rez * c.Imz) / base);
    }

    @Override
    public String toString() {
        return String.format("%s + %si", df.format(Rez), df.format(Imz));
    }
}
