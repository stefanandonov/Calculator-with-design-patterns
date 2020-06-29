package mk.ukim.finki.Homework1.services;

public abstract class BasicService {

    String serviceName;
    double servicePrice;

    public BasicService(String serviceName, double servicePrice) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public double getServicePrice() {
        return servicePrice;
    }


    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
