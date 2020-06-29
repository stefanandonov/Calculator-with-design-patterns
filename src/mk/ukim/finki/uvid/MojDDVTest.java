package mk.ukim.finki.uvid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class AmountNotAllowedException extends Exception{
    public AmountNotAllowedException(int sum) {
        System.out.println("Receipt with amount "+ sum + " is not allowed to be scanned");
    }

    public void getMessage(String message, int sum) {
        System.out.println(message);
    }
}

class MojDDV{
    private ArrayList<Smetka> smetki;

    public MojDDV() {
        this.smetki = new ArrayList<>();
    }

    public void readRecords(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String smetka;

        while((smetka = br.readLine()) != null){
            Smetka totalBill = new Smetka();
            List<Item> itemsList = new ArrayList<>();
            String[] strings = smetka.split("\\s+");
            int id  = Integer.parseInt(strings[0]);

            for(int i=1; i<strings.length; i=i+2){
                Integer sum = Integer.parseInt(strings[i]);
                String type = strings[i+1];

                Item item = new Item(sum,type);
                itemsList.add(item);
            }

            Smetka s = null;

            try {
                s = new Smetka(id, itemsList);
            } catch (AmountNotAllowedException e) {
                System.out.println(e.getMessage());
            }
            if (s!=null)
                smetki.add(totalBill);

        }
    }

    public void printTaxReturns(PrintStream outputStream){
        for (Smetka smetka : smetki) {
            String s = smetka.toString();
            outputStream.print(s);
            outputStream.flush();
        }
        outputStream.close();
    }
}


class Smetka{
    Integer id;
    List<Item> ednaSmetka;

    public Smetka(){
        ednaSmetka = new ArrayList<>();
    }

    public Smetka(Integer id, List<Item> ednaSmetka) throws AmountNotAllowedException {
        this.id = id;

        double sum = ednaSmetka.stream().mapToDouble(smekta -> smekta.price).sum();

        if (sum>=30000)
            throw new AmountNotAllowedException((int) sum);
        this.ednaSmetka = ednaSmetka;
    }

    public void addItem(Item item) {
        double sum = ednaSmetka.stream().mapToDouble(smekta -> smekta.price).sum();

        ednaSmetka.add(item);
    }

    public void totalSumOfBill() throws AmountNotAllowedException {
        int sum = 0;
        for(int i=0; i<ednaSmetka.size(); i++){
            sum = sum + ednaSmetka.get(i).price;
        }

        try{
            if(sum > 30000) throw new AmountNotAllowedException(sum);
        }catch(AmountNotAllowedException ignored){}
    }

    public int getSum(List<Item> ednaSmetka){
        int sum = 0;
        for (Item item : ednaSmetka) {
            sum = sum + item.price;
        }
        return sum;
    }

    public double getTotalDDV(List<Item> ednaSmetka){
        double ddv = 0;
        for (Item item : ednaSmetka) {
            ddv = ddv + item.getDDV();
        }
        return ddv;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        return String.format("%d %d %.2f\n", this.id, getSum(ednaSmetka), getTotalDDV(ednaSmetka));
    }
}



class Item{
    Integer price;
    String type;

    public Item(Integer id, String type) {
        this.price = id;
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public double getDDV(){
        double ddv = (price * 15)/100.0;
        if(type.equals("A")){
            return (ddv * 18) / 100.0;
        } if(type.equals("B")){
            return (ddv * 5) / 100.0;
        } else{
            return 0;
        }
    }
}


public class MojDDVTest {

    public static void main(String[] args) throws IOException, AmountNotAllowedException {

        MojDDV mojDDV = new MojDDV();

        System.out.println("===READING RECORDS FROM INPUT STREAM===");
        mojDDV.readRecords(System.in);

        System.out.println("===PRINTING TAX RETURNS RECORDS TO OUTPUT STREAM ===");
        mojDDV.printTaxReturns(System.out);

    }
}