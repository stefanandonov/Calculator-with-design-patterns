package mk.ukim.finki.Homework1.packages;

import mk.ukim.finki.Homework1.services.DataService;
import mk.ukim.finki.Homework1.services.RoamingService;
import mk.ukim.finki.Homework1.services.SmsService;
import mk.ukim.finki.Homework1.services.VoiceService;

public class PackageFactory {

    public static ServicePackage createDefaultServicePackage (PackageName packageName) {

        ServicePackage servicePackage = new ServicePackage(packageName);
        switch (packageName) {
            case POST_PAID:
                servicePackage.addService(new VoiceService(500.0,500.0,30,3.9,0.0,0));
                servicePackage.addService(new SmsService(0.0,50,4.9));
                servicePackage.addService(new DataService(300.0,5,100*1024,4.0));
                servicePackage.addService(new RoamingService());
                break;
            case PRE_PAID:
                servicePackage.addService(new VoiceService(0.0,0.0,60,6.9,6.9,60));
                servicePackage.addService(new SmsService(0.0,0,5.0));
                break;
            case PRE_PAID_DATA_PLUS:
                servicePackage.addService(new VoiceService(0.0,0.0,60,6.9,6.9,60));
                servicePackage.addService(new SmsService(0.0,0,5.0));
                servicePackage.addService(new DataService(150.0,5,50*1024,3.0));
                break;
        }

        return servicePackage;
    }
}
