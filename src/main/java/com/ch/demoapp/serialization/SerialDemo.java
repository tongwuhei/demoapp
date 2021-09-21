package com.ch.demoapp.serialization;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chj
 * @date 2021/5/31 20:08
 */
@Data
public class SerialDemo implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    private Integer age;

    private String name;

    /**
     * 被transient关键字修饰的字段不会被序列化
     */
    private transient String remark;

}
