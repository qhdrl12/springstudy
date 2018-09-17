package com.ryan.extspringcloudstream;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableBinding(KafkaStreamsProcessor.class)
public class ExtspringcloudstreamApplication {

    @StreamListener("mtrip")
//    @SendTo("mtrip-out")
    public KStream<?, String> process(KStream<?, String> input) {
        return input;

//        return input
//                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
//                .groupBy((key, value) -> value)
//                .windowedBy(TimeWindows.of(5000))
//                .count(Materialized.as("WordCounts-multi"))
//                .toStream()
//                .map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
    }

    public static void main(String[] args) {
        SpringApplication.run(ExtspringcloudstreamApplication.class, args);
    }

    static class WordCount {
        private String word;
        private long count;
        private Date start;
        private Date end;

        public WordCount(String word, long count, Date start, Date end) {
            this.word = word;
            this.count = count;
            this.start = start;
            this.end = end;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }
    }
}
