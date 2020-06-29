package mk.ukim.finki.Homework1;

import mk.ukim.finki.Homework1.packages.PackageFactory;
import mk.ukim.finki.Homework1.packages.PackageManager;
import mk.ukim.finki.Homework1.packages.PackageName;
import mk.ukim.finki.Homework1.packages.ServicePackage;
import mk.ukim.finki.Homework1.services.DataService;
import mk.ukim.finki.Homework1.services.VoiceService;

public class ServicesTester {

    public static void main(String[] args) {

        //creation of the default service packages (the same ones stated in the homework requirements)
        ServicePackage sp1 = PackageFactory.createDefaultServicePackage(PackageName.POST_PAID);
        ServicePackage sp2 = PackageFactory.createDefaultServicePackage(PackageName.PRE_PAID);
        ServicePackage sp3 = PackageFactory.createDefaultServicePackage(PackageName.PRE_PAID_DATA_PLUS);

        //creation of the package prototype manages and saving the prototypes in the manages
        PackageManager packageManager = new PackageManager();
        packageManager.addPrototype(sp1);
        packageManager.addPrototype(sp2);
        packageManager.addPrototype(sp3);

        //printing the current situation with all the packages in the prototype manager
        packageManager.listAllServicePackages();

        //creation of the copies (clones) of the service packages
        ServicePackage csp1 = packageManager.findAndClone(PackageName.POST_PAID);
        ServicePackage csp2 = packageManager.findAndClone(PackageName.PRE_PAID);
        ServicePackage csp3 = packageManager.findAndClone(PackageName.PRE_PAID_DATA_PLUS);

        //Checking if the copies are different objects but still having equal content!
        PropertiesTester.testPropertiesOfClones(sp1, csp1);
        PropertiesTester.testPropertiesOfClones(sp2, csp2);
        PropertiesTester.testPropertiesOfClones(sp3, csp3);

        //Creation of new package that is a similar to POST_PAID but has less free data service
        // than the regular and is more expensive

        csp1.removeService("data_service");
        csp1.addService(new DataService(350.0,2,100*1024,5.0));
        csp1.setPackageName(PackageName.POST_PAID_DATA_MINUS);

        //saving this package as a new prototype in the prototype manager
        packageManager.addPrototype(csp1);

        //printing the current situation with all the packages in the prototype manager
        packageManager.listAllServicePackages();





    }
}
