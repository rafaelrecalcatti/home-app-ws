package br.com.home_app.domain;

import lombok.*;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "light")
class Light {

    //@Id
    private String id;

    //@Indexed(unique = true)
    private String portLight;

    //@Indexed(unique = true)
    private String portSensor;

    //@Indexed(unique = true)
    private String number;

    private Integer status;

    private Long dateTimeOn;

    private Long dateTimeOff;

    private Long usageTime;

}
