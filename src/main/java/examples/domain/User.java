package examples.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
  @JsonProperty("user_code")
  private String userCode;

  @JsonProperty("user_name")
  private String userName;
}
