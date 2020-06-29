package mk.ukim.finki.Homework1;

import mk.ukim.finki.Homework1.packages.ServicePackage;

public class PropertiesTester {

    public static void testPropertiesOfClones (ServicePackage original, ServicePackage clone) {

        if (original==clone) {
            System.out.println("SAME OBJECTS!");
        }
        else {
            System.out.println("DIFFERENT OBJECTS");
        }

        if (original.equals(clone)) {
            System.out.println("SAME CONTENT");
        }
        else
            System.out.println("DIFFERENT CONTENT");
    }
}
