package br.com.upbusiness.light_switch.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LightDto {

    private String id;
    private String number;
    private Integer status;
    private Long usageTime;
}
