package com.bridgelabz;

public class RideRepository {
    public RideRepository() {
    }
    public InvoiceGenerator genrateInvoice(int userNo, Ride[] rides) {
        CabInvoice cabInvoice = new CabInvoice();
        int totalRides=rides.length;
        double aggFare =cabInvoice.calculateFare(rides);
        double avgFare =(aggFare/totalRides);
        return new InvoiceGenerator(totalRides,aggFare,avgFare,userNo);
    }
    public InvoiceGenerator genrateInvoice(int userNo, Ride[] rides, UserType userType) {
        CabInvoice cabInvoice = new CabInvoice();
        if(userType.NORMAL.equals(userType)) {
            int totalRides = rides.length;
            double aggFare = cabInvoice.calculateFare(rides);
            double avgFare = (aggFare / totalRides);
            return new InvoiceGenerator(totalRides, aggFare, avgFare, userNo);
        }
        else if(userType.PREMIUM.equals(userType)){
            int totalRides = rides.length;
            double aggFare = cabInvoice.calculateFarePremium(rides);
            double avgFare = (aggFare / totalRides);
            return new InvoiceGenerator(totalRides, aggFare, avgFare, userNo);
        }
        return null;
    }

}
