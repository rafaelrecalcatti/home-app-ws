package br.com.upbusiness.light_switch.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LightDto {

    private String id;
    private Long number;
    private Integer status;
    private Long usageTime;
}
