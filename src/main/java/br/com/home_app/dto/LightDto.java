package br.com.home_app.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LightDto {

    private String id;
    private String portLight;
    private String portSensor;
    private String number;
    private Integer status;
    private Long dateTimeOn;
    private Long dateTimeOff;
    private Long usageTime;
}
