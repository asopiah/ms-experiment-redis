package com.experiment.redis.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author asopia
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private String id;
    private String type;
}
