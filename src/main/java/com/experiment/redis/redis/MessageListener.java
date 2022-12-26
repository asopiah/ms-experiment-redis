package com.experiment.redis.redis;

import com.experiment.redis.data.Email;
import com.experiment.redis.data.Invoice;
import com.github.sonus21.rqueue.annotation.RqueueListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author asopia
 */

@Component
@Slf4j
public class MessageListener {
    @RqueueListener(value = "${email.queue.name}")
    public void sendEmail(Email email) {

        log.info("Email {}", email);

    }


    @RqueueListener(value = "${invoice.queue.name}")

    public void generateInvoice(Invoice invoice) {

        log.info("Invoice {}", invoice);

    }
}
