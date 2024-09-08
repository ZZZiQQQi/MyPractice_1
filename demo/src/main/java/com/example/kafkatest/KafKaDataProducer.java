package com.example.kafkatest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafKaDataProducer {

    private final KafkaProducer<String,String> producer;

    private final String topic;

    public KafKaDataProducer(String brokers, String topic) {

        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        producer = new KafkaProducer<>(props);

        this.topic = topic;
    }

    public void send(String data) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, data);
        producer.send(record,(metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            }else{
                producer.flush();
                System.out.println("发送数据到主题" + topic + ": " + data);

            }
        });
    }

    public static void main(String[] args) {
        KafKaDataProducer producer = new KafKaDataProducer("localhost:9092", "quickstart-events");

        producer.send("hello kafka");
        producer.send("你好接受者");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
