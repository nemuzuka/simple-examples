package examples.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.seasar.doma.jdbc.domain.DomainConverter;

/**
 * 永続化先を JSON 文字列にする場合の基底 Converter.
 *
 * <p>本 class を extends して `@ExternalDomain` を付与し、 `@DomainConverters` に追加してください。
 *
 * @param <T> 対象 Domain の型パラメータ
 */
public abstract class AbstractDomainJsonConverter<T> implements DomainConverter<T, String> {

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
