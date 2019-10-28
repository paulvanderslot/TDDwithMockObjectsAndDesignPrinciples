package tddmicroexercises.tirepressuremonitoringsystem;

public class PressureThreshold {

    private final double lowBoundary;
    private final double highBoundary;

    PressureThreshold(double lowBoundary, double highBoundary) {
        this.lowBoundary = lowBoundary;
        this.highBoundary = highBoundary;
    }

    boolean isOutOfBounds(double pressure) {
        return pressure < lowBoundary || highBoundary < pressure;
    }
}
