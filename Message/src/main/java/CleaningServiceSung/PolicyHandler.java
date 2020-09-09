package CleaningServiceSung;

import CleaningServiceSung.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    private MessageRepository messageRepository;

//    @StreamListener(KafkaProcessor.INPUT)
//    public void onStringEventListener(@Payload String eventString){
//
//    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayConfirmed_MessageAlert(@Payload PayConfirmed payConfirmed){

        if(payConfirmed.isMe()){
            Message message = new Message();

            message.setRequestId(payConfirmed.getRequestId());
            message.setStatus(payConfirmed.getStatus());

            messageRepository.save(message);

            System.out.println("##### listener MessageAlert : " + payConfirmed.toJson());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCleaningConfirmed_MessageAlert(@Payload CleaningConfirmed cleaningConfirmed){

        if(cleaningConfirmed.isMe()){
            Message message = new Message();

            message.setRequestId(cleaningConfirmed.getRequestId());
            message.setStatus(cleaningConfirmed.getStatus());

            messageRepository.save(message);

            System.out.println("##### listener MessageAlert : " + cleaningConfirmed.toJson());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelConfirmed_MessageAlert(@Payload PayCancelConfirmed payCancelConfirmed){

        if(payCancelConfirmed.isMe()){
            Message message = new Message();

            message.setRequestId(payCancelConfirmed.getRequestId());
            message.setStatus(payCancelConfirmed.getStatus());

            messageRepository.save(message);

            System.out.println("##### listener MessageAlert : " + payCancelConfirmed.toJson());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewCompleted_MessageAlert(@Payload ReviewCompleted reviewCompleted){

        if(reviewCompleted.isMe()){
            Message message = new Message();

            message.setRequestId(reviewCompleted.getRequestId());
            message.setStatus(reviewCompleted.getReviewDate());

            messageRepository.save(message);

            System.out.println("##### listener MessageAlert : " + reviewCompleted.toJson());
        }
    }

}
