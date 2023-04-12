package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoice cabInvoice;
    @BeforeEach
    void init(){
        cabInvoice=new CabInvoice();
    }
    @Test
    void givenDistanceAndTimeSholudReturnTotalFare(){
        double fare = cabInvoice.calculateFare(10,20);
        Assertions.assertEquals(120,fare);

    }
    @Test
    void givenDistanceAndTimeShouldReturnMinFare(){
        double minFare = cabInvoice.calculateFare(0.2,1);
        Assertions.assertEquals(5,minFare);
    }

    @Test
    void givenMultipleRidesShouldReturnAggregate(){
        Ride ride = new Ride(10,20);
        Ride ride1 = new Ride(0.2,1);
        Ride ride2 = new Ride(26,37);
        Ride[] rides = {ride,ride1,ride2};
        double aggregateFare = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(422,aggregateFare);

    }
    @Test
    void givenMultipleRidesShouldReturnInvoice(){
        Ride ride = new Ride(10,20);
        Ride ride1 = new Ride(0.2,1);
        Ride ride2 = new Ride(26,37);
        Ride[] rides = {ride,ride1,ride2};
        InvoiceGenerator expectedInvoice = new InvoiceGenerator(3,422,422.0/3);
        InvoiceGenerator invoice = cabInvoice.generateInvoice(rides);
    }
    @Test
    void givenUserIdShouldReturnInvoice(){
            Ride ride = new Ride(20,5);
            Ride ride1 = new Ride(0.2,1);
            Ride ride2 = new Ride(0.5,2);
            Ride ride3 = new Ride(10,5);
            Ride[] rides ={ride,ride1,ride2,ride3};
            RideRepository rideRepository = new RideRepository();
            InvoiceGenerator expectedInvoice = new InvoiceGenerator(4,322.0,322.0/4,1122);
            InvoiceGenerator invoice=rideRepository.genrateInvoice(1122,rides);
            Assertions.assertEquals(expectedInvoice,invoice);
        }
}
