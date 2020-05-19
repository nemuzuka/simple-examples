package examples.domain;

import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class UserConverter extends AbstractDomainConverter<User> {
  @Override
  Class<User> getClassType() {
    return User.class;
  }
}
