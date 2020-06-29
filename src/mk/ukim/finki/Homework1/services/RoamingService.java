package mk.ukim.finki.Homework1.services;

public class RoamingService extends BasicService {
    private static double ROAMING_SERVICE_PRICE = 200;
    private static String SERVICE_NAME = "roaming_service";
    public RoamingService() {
        super(SERVICE_NAME, ROAMING_SERVICE_PRICE);
    }

//    Map<String,Double> extraServicePricePerCountry;
//
//    public RoamingService(double servicePrice) {
//        super(servicePrice);
//        extraServicePricePerCountry = new HashMap<>();
//        extraServicePricePerCountry.put("CRO", 2.05);
//        extraServicePricePerCountry.put("ALB", 2.01);
//        extraServicePricePerCountry.put("SRB", 2.11);
//
//    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoamingService{");
        sb.append("servicePrice=").append(servicePrice);
        sb.append('}');
        return sb.toString();
    }
}
