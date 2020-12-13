package com.lonely.wolf.note.mybatis.mapper;

import com.lonely.wolf.note.mybatis.model.LwUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public interface UserMapper {

    List<LwUser> listAllUser();

    List<LwUser> listUserByUserName(String userName, ResultHandler resultHandler);

    List<LwUser> listUserByTable(@Param("tableName") String tableName);

    List<LwUser> list(LwUser lwUser);

    List<LwUser> listUserAndJob();

    List<LwUser> selectUserAndJob();


}