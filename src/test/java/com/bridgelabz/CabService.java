package com.bridgelabz;


public enum  CabService {

    NORMAL(10.0,1.0,5.0),
    PREMIUM(15.0,2.0,20.0);

    private final double costPerKilometer;
    private final double costPerMinute;
    private final double minFarePerRide;

    CabService(double costPerKilometer, double costPerMinute, double minFarePerRide) {
        this.costPerKilometer = costPerKilometer;
        this.costPerMinute = costPerMinute;
        this.minFarePerRide = minFarePerRide;
    }

    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance * costPerKilometer + ride.time * costPerMinute;
        return Math.max(rideCost,minFarePerRide);
    }
}