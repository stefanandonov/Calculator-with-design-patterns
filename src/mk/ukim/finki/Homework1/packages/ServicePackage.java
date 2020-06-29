package mk.ukim.finki.Homework1.packages;

import mk.ukim.finki.Homework1.services.BasicService;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ServicePackage implements Cloneable {
    PackageName packageName;
    List<BasicService> services;

    public ServicePackage(PackageName packageName) {
        this.packageName = packageName;
        this.services = new ArrayList<>();
    }

    public ServicePackage(ServicePackage servicePackage) {
        this.packageName = servicePackage.packageName;
        this.services = new ArrayList<>();
        this.services.addAll(servicePackage.services);
    }

    public void addService (BasicService basicService) {
        services.add(basicService);
    }

    public void removeService (String basicServiceName) {
        services.removeIf(basicService -> basicServiceName.equals(basicService.getServiceName()));
    }

    public PackageName getPackageName() {
        return packageName;
    }

    public void setPackageName(PackageName packageName) {
        this.packageName = packageName;
    }

    public List<BasicService> getServices() {
        return services;
    }

    public void setServices(List<BasicService> services) {
        this.services = services;
    }

    public double totalPrice () {
        return services.stream().mapToDouble(BasicService::getServicePrice).sum();
    }

    public void listServices() {
        System.out.println(String.format(
                "Service package: %s has the following services: %s\nTotal price: %.2f\n",
                packageName.toString(),
                services.stream().map(BasicService::toString).collect(Collectors.joining("\n")),
                totalPrice()
        ));
    }

    @Override
    protected ServicePackage clone() {
        return new ServicePackage(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePackage that = (ServicePackage) o;
        return packageName == that.packageName &&
                Arrays.deepEquals(services.toArray(), that.services.toArray());

    }

    @Override
    public int hashCode() {
        return Objects.hash(packageName, services);
    }
}
