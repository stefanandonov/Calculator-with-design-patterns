package mk.ukim.finki.Homework1.services;

public class VoiceService extends BasicService {

    double freeMinutes;
    int unit;
    double pricePerMinute;
    double pricePerCall;
    int freeSecInCall;
    private static String SERVICE_NAME = "voice_service";

    public VoiceService(double servicePrice, double freeMinutes, int unit, double pricePerMinute, double pricePerCall, int freeSecInCall) {
        super(SERVICE_NAME, servicePrice);
        this.freeMinutes = freeMinutes;
        this.unit = unit;
        this.pricePerMinute = pricePerMinute;
        this.pricePerCall = pricePerCall;
        this.freeSecInCall = freeSecInCall;
    }

    public double getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(double freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public double getPricePerCall() {
        return pricePerCall;
    }

    public void setPricePerCall(double pricePerCall) {
        this.pricePerCall = pricePerCall;
    }

    public int getFreeSecInCall() {
        return freeSecInCall;
    }

    public void setFreeSecInCall(int freeSecInCall) {
        this.freeSecInCall = freeSecInCall;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VoiceService{");
        sb.append("freeMinutes=").append(freeMinutes);
        sb.append(", unit=").append(unit);
        sb.append(", pricePerMinute=").append(pricePerMinute);
        sb.append(", pricePerCall=").append(pricePerCall);
        sb.append(", freeSecInCall=").append(freeSecInCall);
        sb.append(", servicePrice=").append(servicePrice);
        sb.append('}');
        return sb.toString();
    }
}
