-- sql ファイルがないと doma2 がエラーを返すので仕方ない...
insert into customers (
    customer_id,
    customer_code,
    customer_name,
    attribute
) values (
    /* customer.customerId */'id_001',
    /* customer.customerCode */'code_001',
    /* customer.customerName */'name_002',
    /* customer.attribute */'{"hoge"::30}'
)
