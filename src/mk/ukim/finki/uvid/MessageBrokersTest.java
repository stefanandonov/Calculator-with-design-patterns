package mk.ukim.finki.uvid;

//package bla;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PartitionDoesNotExistException extends Exception{

}

class PartitionAssigner {
    public static Integer assignPartition (Message message, int partitionsCount) {
        return (Math.abs(message.key.hashCode())  % partitionsCount) + 1;
    }
}

class Message implements Comparable<Message>{

    LocalDateTime timeStamp;
    String context;
    Integer partition;
    String key;


    public Message(LocalDateTime timeStamp, String context, String key) {
        this.timeStamp = timeStamp;
        this.context = context;
        this.key = key;
    }

    public Message(LocalDateTime timeStamp, String context, Integer partition, String key) {
        this.timeStamp = timeStamp;
        this.context = context;
        this.partition = partition;
        this.key = key;
    }

    @Override
    public String toString() {
        return String.format("Message{timestamp=%s, message='%s'\n",
                timeStamp,
                context);
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public int compareTo(Message otherMessage) {
        return Comparator.comparing(Message::getTimeStamp).compare(this,otherMessage);
    }
}


class Topic{
    String topicName;
    Map<Integer, Set<Message>> messageMap;
    int partitionsCount;

    public Topic(String topicName, int partitionsCount){
        this.topicName = topicName;
        messageMap = new TreeMap<>();
        this.partitionsCount = partitionsCount;
        IntStream.range(1,partitionsCount+1).forEach(i -> messageMap.put(i,new TreeSet<>()));

    }

    public void addMessage(Message message) throws PartitionDoesNotExistException{

        Integer partition = null;

        if (message.partition!=null)
            partition= message.partition;
        else {
            partition = PartitionAssigner.assignPartition(message,partitionsCount);
        }

        if (messageMap.containsKey(partition)) {
            messageMap.get(partition).add(message);
        }
        else throw new PartitionDoesNotExistException();
    }

    void changeNumberOfPartitions (int newPartitionsNumber) throws UnsupportedOperationException{
        if(newPartitionsNumber < partitionsCount) throw new UnsupportedOperationException();
        partitionsCount = newPartitionsNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Topic: %10s Partitions: %5d\n",topicName,partitionsCount));
        messageMap.forEach((key, value) -> sb.append(String.format("%2d : Count of Messages: %5d\nMessages:\n%s",
                key,
                value.size(),
                value.stream().map(Message::toString)
                        .collect(Collectors.joining("\n")))));
        return sb.toString();
    }
}

class MessageBroker{

    Map<String,Topic> topics;
    static LocalDateTime startDate;
    static Integer limit;

    public MessageBroker(LocalDateTime minimumDate, Integer capacityPerTopic){
        startDate = minimumDate;
        limit = capacityPerTopic;
        topics = new TreeMap<>();
    }

    public void addTopic(String topic, int partitionsCount){
        if(topics.containsKey(topic)) return;
        topics.put(topic,new Topic(topic,partitionsCount));
    }

    public void addMessage (String topic, Message message) throws PartitionDoesNotExistException,UnsupportedOperationException {
        topics.get(topic).addMessage(message);
    }

    public void changeTopicSettings (String topic, int partitionsCount){
        topics.get(topic).changeNumberOfPartitions(partitionsCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Broker with %2d topics:\n",topics.keySet().size()));
        sb.append(topics.values().stream().map(Topic::toString).collect(Collectors.joining("\n")));
        return sb.toString();
    }
}

public class MessageBrokersTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String date = sc.nextLine();
        LocalDateTime localDateTime =LocalDateTime.parse(date);
        Integer partitionsLimit = Integer.parseInt(sc.nextLine());
        MessageBroker broker = new MessageBroker(localDateTime, partitionsLimit);
        int topicsCount = Integer.parseInt(sc.nextLine());

        //Adding topics
        for (int i=0;i<topicsCount;i++) {
            String line = sc.nextLine();
            String [] parts = line.split(";");
            String topicName = parts[0];
            int partitionsCount = Integer.parseInt(parts[1]);
            broker.addTopic(topicName, partitionsCount);
        }

        //Reading messages
        int messagesCount = Integer.parseInt(sc.nextLine());

        System.out.println("===ADDING MESSAGES TO TOPICS===");
        for (int i=0;i<messagesCount;i++) {
            String line = sc.nextLine();
            String [] parts = line.split(";");
            String topic = parts[0];
            LocalDateTime timestamp = LocalDateTime.parse(parts[1]);
            String message = parts[2];
            if (parts.length==4) {
                String key = parts[3];
                try {
                    broker.addMessage(topic, new Message(timestamp,message,key));
                } catch (UnsupportedOperationException | PartitionDoesNotExistException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                Integer partition = Integer.parseInt(parts[3]);
                String key = parts[4];
                try {
                    broker.addMessage(topic, new Message(timestamp,message,partition,key));
                } catch (UnsupportedOperationException | PartitionDoesNotExistException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("===BROKER STATE AFTER ADDITION OF MESSAGES===");
        System.out.println(broker);

        System.out.println("===CHANGE OF TOPICS CONFIGURATION===");
        //topics changes
        int changesCount = Integer.parseInt(sc.nextLine());
        for (int i=0;i<changesCount;i++){
            String line = sc.nextLine();
            String [] parts = line.split(";");
            String topicName = parts[0];
            Integer partitions = Integer.parseInt(parts[1]);
            try {
                broker.changeTopicSettings(topicName, partitions);
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("===ADDING NEW MESSAGES TO TOPICS===");
        messagesCount = Integer.parseInt(sc.nextLine());
        for (int i=0;i<messagesCount;i++) {
            String line = sc.nextLine();
            String [] parts = line.split(";");
            String topic = parts[0];
            LocalDateTime timestamp = LocalDateTime.parse(parts[1]);
            String message = parts[2];
            if (parts.length==4) {
                String key = parts[3];
                try {
                    broker.addMessage(topic, new Message(timestamp,message,key));
                } catch (UnsupportedOperationException | PartitionDoesNotExistException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                Integer partition = Integer.parseInt(parts[3]);
                String key = parts[4];
                try {
                    broker.addMessage(topic, new Message(timestamp,message,partition,key));
                } catch (UnsupportedOperationException | PartitionDoesNotExistException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("===BROKER STATE AFTER CONFIGURATION CHANGE===");
        System.out.println(broker);


    }
}
