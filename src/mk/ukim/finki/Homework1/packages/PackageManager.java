package mk.ukim.finki.Homework1.packages;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PackageManager {

    Map<PackageName, ServicePackage> packagePrototypeMap;

    public PackageManager() {
        packagePrototypeMap = new HashMap<>();
    }

    public void addPrototype (ServicePackage servicePackage) {
        this.packagePrototypeMap.put(servicePackage.getPackageName(), servicePackage);
    }

    public void removePrototype (ServicePackage servicePackage) {
        this.packagePrototypeMap.remove(servicePackage.getPackageName());
    }

    public void removePrototypeByName (PackageName packageName) {
        this.packagePrototypeMap.remove(packageName);
    }

    public ServicePackage findAndClone (PackageName packageName) {
        return packagePrototypeMap.get(packageName).clone();
    }

    public void listAllServicePackages() {
        packagePrototypeMap.values().forEach(ServicePackage::listServices);
    }


}
