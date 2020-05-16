package examples.domain;

import org.seasar.doma.DomainConverters;

@DomainConverters({AgeConverter.class, AttributeConverter.class})
public class DomainConverterProvider {}
