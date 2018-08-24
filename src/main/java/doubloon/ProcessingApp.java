package doubloon;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.lang.System;
import java.lang.Runtime;

public class ProcessingApp {

   public static void main(String[] args){
     if (args.length!=3) {
        System.out.println("Usage servers groupId topic");
	System.out.println("java -jar ./build/libs/java-0.1.0.jar 10.23.2.73:9092 testJava2 syslog");
     }
     else {
	new ProcessingApp(args[0],args[1],args[2]);
     }
   }

   ProcessingApp(String servers,String groupId,String topic) {

	long count=0;

        System.out.println("Connecting to server : "+servers);
        Reader reader = new Reader(servers,groupId,topic);

        final long startTime = System.currentTimeMillis();

	Runtime.getRuntime().addShutdownHook(new Thread() {

		public void run() {
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Execution time : "+(stopTime-startTime)+ "ms");

		}
	    });



	while (true) {
   		ConsumerRecords<String, String> consumerRecords = reader.consume();

                System.out.println("We got record count " + consumerRecords.count());
                count+= consumerRecords.count();
                System.out.println("Total " + count);

		for (ConsumerRecord<String,String> record : consumerRecords){
//			System.out.println(record.value());
		}

	}

   }

}

