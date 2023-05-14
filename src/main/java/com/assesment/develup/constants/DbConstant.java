package com.assesment.develup.constants;

public class DbConstant {
    public static final String COUNT_QUERY="select outOfStock,inStock,categoryCount from\n" +
            "(select count(*) as outOfStock from assessment where remain_qty<100)\n" +
            "as oos,(select count(*) as inStock from assessment where remain_qty>0)\n" +
            "as ise,(select count(*) as categoryCount from (select distinct(group_name) from assessment) as ast) as df;";
}
