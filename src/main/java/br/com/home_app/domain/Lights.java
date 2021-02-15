package br.com.home_app.domain;

import lombok.*;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lights")
public class Lights {

    @Id
    private String id;

    @Indexed(unique = true)
    private String serie;

    private String token;

    @Indexed(unique = true)
    private List<Light> lights;

}
