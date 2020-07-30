package com.cars.domian;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/7/30 16:02
 * @Version 1.0
 **/
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String content;
}
