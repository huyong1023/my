package org.huyong.my.spring.transaction.programming;

import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by yonghu on 2020/5/17.
 */
public class TestTransaction {


    private DataSourceTransactionManager transactionManager;
    //@Override
    public void test() {
        DefaultTransactionDefinition def=new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        for(int i=1030;i<1036;i++){
            //System.out.println(lowPriceGroupDao.test1(i));//更新一个值
            transactionManager.commit(transactionStatus);
        }
    }
}
