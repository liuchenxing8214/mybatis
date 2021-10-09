package com.itheima.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 *
 */
@Data
public class User{

    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone="GMT+8")
    private Date userBirthday;

    private List<Account> accounts;



}


