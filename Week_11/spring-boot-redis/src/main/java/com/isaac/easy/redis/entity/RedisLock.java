package com.isaac.easy.redis.entity;

/**
 * @author liangchao
 * @date 2021/1/4
 */

public class RedisLock {
    private String key;
    private String uniqueId;
    private Long timeOutSecond;

    public RedisLock( String key, String uniqueId, Long timeOutSecond ) {
        this.key = key;
        this.uniqueId = uniqueId;
        this.timeOutSecond = timeOutSecond;
    }

    public Long getTimeOutSecond() {
        return timeOutSecond;
    }

    public void setTimeOutSecond( Long timeOutSecond ) {
        this.timeOutSecond = timeOutSecond;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId( String uniqueId ) {
        this.uniqueId = uniqueId;
    }
}
