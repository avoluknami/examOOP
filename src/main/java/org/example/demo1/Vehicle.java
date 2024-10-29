package org.example.demo1;

public class Vehicle {
    private int engineCapacity; // in CC
    private int manufactureYear;
    private VehicleType vehicleType;

    public Vehicle(int engineCapacity, int manufactureYear, VehicleType vehicleType) {
        this.engineCapacity = engineCapacity;
        this.manufactureYear = manufactureYear;
        this.vehicleType = vehicleType;
    }

    // Getters and setters
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Method to calculate tax
    public double calculateTax() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int age = currentYear - manufactureYear;
        int yearMultiplier;

        if (age <= 5) yearMultiplier = 5;
        else if (age <= 10) yearMultiplier = 4;
        else if (age <= 15) yearMultiplier = 2;
        else yearMultiplier = 1;

        // Calculate tax based on vehicle type
        switch (vehicleType) {
            case CAR:
                return 18 * engineCapacity * yearMultiplier; // CAR tax calculation
            case BUS:
                return 15 * engineCapacity * yearMultiplier; // BUS tax calculation
            case TRUCK:
                return 16 * engineCapacity * yearMultiplier; // TRUCK tax calculation
            default:
                return 0;
        }
    }
}
