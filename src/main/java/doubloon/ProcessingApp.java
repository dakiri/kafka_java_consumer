package doubloon;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ProcessingApp {

   public static void main(String[] args){
     new ProcessingApp();
   }

   ProcessingApp() {

        System.out.println("Hello, World");
	String servers ="10.23.2.73:9092";
	String groupId ="testJava2";
	String topic="syslog";

        System.out.println("Server : "+servers);

        Reader reader = new Reader(servers,groupId,topic);

	while (true) {
   		ConsumerRecords<String, String> consumerRecords = reader.consume();

                System.out.println("We got record count " + consumerRecords.count());
		for (ConsumerRecord<String,String> record : consumerRecords){
//			System.out.println("_"+record.value());
		}

	}

   }

}

