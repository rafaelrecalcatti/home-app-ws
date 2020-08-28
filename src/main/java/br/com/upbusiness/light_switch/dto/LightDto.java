package br.com.upbusiness.light_switch.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LightDto {

    private String id;
    private String number;
    private Integer status;
    private LocalDateTime dateTimeOn;
    private LocalDateTime dateTimeOff;
    private Long usageTime;
}
