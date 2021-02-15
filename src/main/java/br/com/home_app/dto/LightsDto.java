package br.com.home_app.dto;

import lombok.*;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LightsDto {

    private String id;
    private String serie;
    private String token;
    private List<LightDto> lights;

}
