package br.com.upbusiness.light_switch.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "light")
public class Light {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long number;

    private Integer status;

    private Long usageTime;

}
