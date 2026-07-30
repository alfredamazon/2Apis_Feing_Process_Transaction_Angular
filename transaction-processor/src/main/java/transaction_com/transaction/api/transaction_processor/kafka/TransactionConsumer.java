package transaction_com.transaction.api.transaction_processor.kafka;

import javax.annotation.PostConstruct;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @PostConstruct
    public void init() {
        System.out.println("🔥🔥🔥 CONSUMER CARGADO");
    }

    @KafkaListener(
            topics = "transactions-topic",
            groupId = "processor-group"
    )
    public void consume(String message) {

        System.out.println("🔥 EVENTO RECIBIDO:");
        System.out.println(message);
    }
}