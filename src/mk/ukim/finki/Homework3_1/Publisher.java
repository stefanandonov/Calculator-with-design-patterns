package mk.ukim.finki.Homework3_1;

public class Publisher {
    String companyName;
    String companyCity;
    String companyCountry;

    public Publisher(String companyName, String companyCity, String companyCountry) {
        this.companyName = companyName;
        this.companyCity = companyCity;
        this.companyCountry = companyCountry;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publisher{");
        sb.append("companyName='").append(companyName).append('\'');
        sb.append(", companyCity='").append(companyCity).append('\'');
        sb.append(", companyCountry='").append(companyCountry).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
