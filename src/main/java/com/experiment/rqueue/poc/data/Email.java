package com.experiment.rqueue.poc.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author asopia
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String email;
    private String subject;
    private String content;
}
