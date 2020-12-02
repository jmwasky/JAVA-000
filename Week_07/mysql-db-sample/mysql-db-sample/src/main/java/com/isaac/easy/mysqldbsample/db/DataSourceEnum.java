package com.isaac.easy.mysqldbsample.db;

/**
 * @author think
 * @date 2020/12/1
 */
public enum DataSourceEnum {
    Master("master"),
    Slave("slave");

    private String name;

    private DataSourceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
