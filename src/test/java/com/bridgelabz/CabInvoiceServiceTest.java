package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {

    InvoiceGenerator invoiceGenerator = null;
    private RideRepository rideRepository;
    private  Ride[] rides = null;
    InvoiceSummary expectedInvoiceSummary;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        invoiceGenerator.setRideRepository(rideRepository);
        rides = new Ride[] {
                new Ride(2.0, 5, CabService.NORMAL),
                new Ride(0.1, 1, CabService.PREMIUM)};
        expectedInvoiceSummary = new InvoiceSummary(2,45.0);
    }


    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_shouldReturnMiniumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "asd";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

}
