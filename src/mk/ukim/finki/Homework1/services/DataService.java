package mk.ukim.finki.Homework1.services;

public class DataService extends BasicService {

    int size; // kolku free data transfer se dobiva za pretplatata
    int unit;  // kolicina za tarifiranje
    double pricePerUnit; // cena po prenesena kolicina
    private static int DLSPEED = 1000 * 1024; // max. download speed
    private static int ULSPEED = 100 * 1024; // max upload speed
    private static String SERVICE_NAME = "data_service";

    public DataService(double servicePrice, int size, int unit, double pricePerUnit) {
        super(SERVICE_NAME, servicePrice);
        this.size = size;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public static int getDLSPEED() {
        return DLSPEED;
    }

    public static void setDLSPEED(int DLSPEED) {
        DataService.DLSPEED = DLSPEED;
    }

    public static int getULSPEED() {
        return ULSPEED;
    }

    public static void setULSPEED(int ULSPEED) {
        DataService.ULSPEED = ULSPEED;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataService{");
        sb.append("size=").append(size);
        sb.append(", unit=").append(unit);
        sb.append(", pricePerUnit=").append(pricePerUnit);
        sb.append(", dlspeed=").append(DLSPEED);
        sb.append(", ulspeed=").append(ULSPEED);
        sb.append(", servicePrice=").append(servicePrice);
        sb.append('}');
        return sb.toString();
    }


}
