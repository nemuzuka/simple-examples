package examples.entity;

import examples.domain.Attribute;
import lombok.Data;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    /** 永続化時に JSON カラムにするプロパティ. */
    @Column(name = "attribute")
    private Attribute attribute;
}
