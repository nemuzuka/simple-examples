package examples.domain;

import org.seasar.doma.DomainConverters;

@DomainConverters({AgeConverter.class, AttributeConverter.class, UserConverter.class})
public class DomainConverterProvider {}
