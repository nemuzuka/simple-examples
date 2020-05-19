package examples.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.seasar.doma.jdbc.domain.DomainConverter;

public abstract class AbstractDomainConverter<T> implements DomainConverter<T, String> {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  abstract Class<T> getClassType();

  @Override
  public String fromDomainToValue(T t) {
    try {
      return MAPPER.writeValueAsString(t);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public T fromValueToDomain(String value) {
    try {
      return value == null ? null : MAPPER.readValue(value, getClassType());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
