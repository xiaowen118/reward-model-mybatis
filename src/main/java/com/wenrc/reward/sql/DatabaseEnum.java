package com.wenrc.reward.sql;

/**
 * 
 * @author wen_rc@sina.com 2017年5月16日
 *
 */
public enum DatabaseEnum {
    MYSQL("mysql"), ORACLE("oracle"), SQLSERVER("sqlserver");
 
    private String databaseName;
 
    private DatabaseEnum(String databaseName) {
        this.databaseName = databaseName;
    }
 
    public String getDatabaseName() {
        return databaseName;
    }
 
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
