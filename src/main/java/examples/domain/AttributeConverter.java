package examples.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class AttributeConverter implements DomainConverter<Attribute, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String fromDomainToValue(Attribute attribute) {
        try {
            return MAPPER.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Attribute fromValueToDomain(String value) {
        try {
            return value == null ? null : MAPPER.readValue(value, Attribute.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
