package mk.ukim.finki.Homework1.services;

public class SmsService extends BasicService{

    int freeMsg;
    double pricePerMsg;
    private static String SERVICE_NAME = "sms_service";

    public SmsService(double servicePrice, int freeMsg, double pricePerMsg) {
        super(SERVICE_NAME, servicePrice);
        this.freeMsg = freeMsg;
        this.pricePerMsg = pricePerMsg;
    }

    public int getFreeMsg() {
        return freeMsg;
    }

    public void setFreeMsg(int freeMsg) {
        this.freeMsg = freeMsg;
    }

    public double getPricePerMsg() {
        return pricePerMsg;
    }

    public void setPricePerMsg(double pricePerMsg) {
        this.pricePerMsg = pricePerMsg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmsService{");
        sb.append("freeMsg=").append(freeMsg);
        sb.append(", pricePerMsg=").append(pricePerMsg);
        sb.append(", servicePrice=").append(servicePrice);
        sb.append('}');
        return sb.toString();
    }
}
