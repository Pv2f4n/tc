package expressions;

import java.util.HashSet;
import java.util.Set;

/**
 * An expression tree node representing a fixed real number.
 */
public final class Constant implements Expression {

    /**
     * The value of this expression.
     */
    private final double value;

    /**
     * Create a node representing the value `value`.
     */
    public Constant(double value) {
        this.value = value;
    }

    /**
     * Returns the value of this Constant.
     */
    public double value() {
        return value;
    }

    /**
     * Return this node's value.
     */
    @Override
    public double eval(VarTable vars) {
        assert vars != null;

        return value;
    }

    /**
     * No operations are required to evaluate a Constant's value.
     */
    @Override
    public int opCount() {
        return 0;
    }

    /**
     * Return the decimal representation of this node's value (with sufficient precision to
     * reproduce its binary value).
     */
    @Override
    public String infixString() {
        return String.valueOf(value);
    }

    /**
     * Return the decimal representation of this node's value (with sufficient precision to
     * reproduce its binary value).
     */
    @Override
    public String postfixString() {
        return String.valueOf(value);
    }

    /**
     * Return whether `other` is a Constant of the same class with the same value.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        Constant c = (Constant) other;
        return c.value == value;
    }

    /**
     * A Constant has no dependencies.
     */
    @Override
    public Set<String> dependencies() {
        // Return the empty set
        return new HashSet<>();
    }

    /**
     * Return self (a Constant is already fully optimized).
     */
    @Override
    public Expression optimize(VarTable vars) {
        assert vars != null;

        return this;
    }

    /**
     * Returns the derivative of this constant with respect to `varName`, which will be the zero
     * constant.
     */
    @Override
    public Expression differentiate(String varName) {
        return new Constant(0.0);
    }

    /**
     * Returns the simplified version of this Constant, which is itself.
     */
    @Override
    public Expression simplify() {
        return this;
    }

}
