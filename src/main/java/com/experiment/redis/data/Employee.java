package com.experiment.redis.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author asopia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//No @Entity concept here -- Entity should implements Serializable
//@RedisHash("BULK_SUBSCRIBER_REG")
public class Employee implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;

    private String requestRefId;
    private String responseMessage;
    private String status;
}
