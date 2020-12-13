package com.lonely.wolf.note.mybatis.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public class LwUser implements Serializable {
    private String userId; //用户id
    private String userName; //用户名称

    private List<LwUserJob> userJobList;//用户工作信息

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<LwUserJob> getUserJobList() {
        return userJobList;
    }

    public void setUserJobList(List<LwUserJob> userJobList) {
        this.userJobList = userJobList;
    }
}
