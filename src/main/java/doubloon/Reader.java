package doubloon;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Reader implements Consumer {
private final KafkaConsumer<String, String> consumer;
private final String topic;

public Reader(String servers, String groupId, String topic) {
   this.consumer=new KafkaConsumer<String,String>(Consumer.createConfig(servers,groupId));
   this.topic=topic;
}


public ConsumerRecords<String, String> consume() {
this.consumer.subscribe(java.util.Arrays.asList(this.topic));
ConsumerRecords<String,String> records = consumer.poll(100);
return records;
}

}
