package examples.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Attribute {

    @JsonProperty("memo")
    private String memo;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("point")
    private Long point;
}
