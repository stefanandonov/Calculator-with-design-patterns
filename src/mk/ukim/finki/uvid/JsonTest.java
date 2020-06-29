package mk.ukim.finki.uvid;

import java.util.LinkedHashMap;
import java.util.Map;

class FlatJson {
    Map<String,Object> fields;

    FlatJson (String [] properties, Object [] values) {
        fields = new LinkedHashMap<>();
        for (int i=0;i<properties.length;i++)
            fields.put(properties[i], values[i]);
    }

    static FlatJson of (String line) {
        String [] parts = line.split(", ");
        String [] properties = new String [parts.length];
        Object [] values = new Object [parts.length];
        for (int i=0;i<parts.length;i++) {
            String [] otherParts = parts[i].split(":");
            properties[i] = otherParts[0];
            Double number = null;
            try {
                number = Double.parseDouble(otherParts[1]);
                values[i] = number;
            }
            catch (Exception e) {
                values[i] = otherParts[1];
            }
        }
        return new FlatJson(properties, values);
    }



    @Override
    public String toString() {
        return fields.toString();
    }
}

public class JsonTest {

    public static void main(String[] args) {
        String line = "test:test1, test2:2, test3:3, stefan:andonov";

        System.out.println(FlatJson.of(line));

    }
}

