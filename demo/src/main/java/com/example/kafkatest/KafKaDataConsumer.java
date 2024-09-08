package com.example.kafkatest;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;

public class KafKaDataConsumer {

    private KafkaConsumer<String, String> consumer;

    public KafKaDataConsumer(String brokers, String topic) {

        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "ziqizhang");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");

        consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList(topic));
    }

    public void startConsuming(WebSocketSession session){
        List list = new ArrayList();

        Executors.newSingleThreadExecutor().submit(()->{
            while(true){
                consumer.poll(100).forEach(record -> {
                    System.out.println(record.value());
                    list.add(record.value());
                    System.out.println("打印结果11111111111"+list.toString());
                });
            }
        });

    }

    public static void main(String[] args) {
        KafKaDataConsumer kafKaDataConsumer = new KafKaDataConsumer("localhost:9092","quickstart-events");

        kafKaDataConsumer.startConsuming(null);


    }

}
