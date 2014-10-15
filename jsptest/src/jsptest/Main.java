package jsptest;


import java.io.Reader;

import jsptest.dao.Employee;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;



public class Main {

    public static void main(String args[]) throws Exception {
        String resource = "sqlMapsConfig.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

        // 検索処理
        Employee query = new Employee();
        query.setId("00001");

        Employee emp = (Employee) sqlMap.queryForObject("employee.abatorgenerated_selectByPrimaryKey", query);
        System.out.println(emp.getId() + ":" + emp.getName());
    }

}
