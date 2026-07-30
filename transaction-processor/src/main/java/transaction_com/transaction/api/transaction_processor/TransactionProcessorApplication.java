package transaction_com.transaction.api.transaction_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TransactionProcessorApplication {

    public static void main(String[] args) {

        System.out.println("🔥 MAIN ARRANCANDO");

        SpringApplication.run(TransactionProcessorApplication.class, args);

        System.out.println("🔥 SPRING LEVANTO");
    }
}