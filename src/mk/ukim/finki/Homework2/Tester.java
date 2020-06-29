//package mk.ukim.finki.Homework2;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Tester {
//    public static void main(String[] args) {
//        Register A = new Register(10);
//        Register B = new Register(5);
//        List<Observer> allObservers = new ArrayList<>();
//
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNextLine()) {
//            /*
//             * Usage:
//             * <register_name> <value> (set the value of the register A) ex. A 15, B 28.56 etc
//             * + <register_name> <operation> <operation_value> (add a new observer to the register_name with operation and operation_value ex. + A - 2.0
//             * - <observer_number> (remove a specific observer from the observers list) ex. - 2
//             * P <register_name>(print all observers attached to the register named <register_name>)
//             * X (exit) */
//
//            String line = sc.nextLine();
//            String parts[] = line.split("\\s+");
//
//
//            if (parts.length == 1) {
//                if (parts[0].equalsIgnoreCase("X"))
//                    break;
//                else if (parts[0].equals("P")) {
//                    printObservers(A,B);
//                }
//            } else if (parts.length == 2) {
//                if (Character.isAlphabetic(parts[0].charAt(0))) {
//                    double newValue = Double.parseDouble(parts[1]);
//                    switch (parts[0]) {
//                        case "A":
//                            A.setValue(newValue);
//                            break;
//                        case "B":
//                            B.setValue(newValue);
//                            break;
//                        default:
//                            break;
//                    }
//                } else {
//                    int observerToRemoveIdx = Integer.parseInt(parts[1]);
//                    A.detach(observerToRemoveIdx);
//                    B.detach(observerToRemoveIdx);
//                }
//            } else if (parts.length == 4) {
//                switch (parts[1]) {
//                    case "A":
//                        allObservers.add(new Observer(A, parts[2].charAt(0), Double.parseDouble(parts[3])));
//                        break;
//                    case "B":
//                        allObservers.add(new Observer(B, parts[2].charAt(0),Double.parseDouble(parts[3]) ));
//                        break;
//                }
//            }
//
//        }
//
//        //Testing if one observer is resistant to observing more than one subject.
//        allObservers.stream().forEach(B::attach);
//        B.setValue(122);
//        printObservers(A, B);
//
//
//    }
//
//
//
//    private static void printObservers(Register A, Register B) {
//        System.out.println("Observers to A:");
//        System.out.println(A);
//
//        System.out.println("Observers to B:");
//        System.out.println(B);
//    }
//
//
//}
