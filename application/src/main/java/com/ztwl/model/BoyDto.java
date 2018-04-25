package com.ztwl.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class BoyDto implements Serializable{
    private String boyName;

    private Integer age;
}
