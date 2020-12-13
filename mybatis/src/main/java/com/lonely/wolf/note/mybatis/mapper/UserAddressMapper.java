package com.lonely.wolf.note.mybatis.mapper;

import com.lonely.wolf.note.mybatis.model.UserAddress;

import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/6
 * @since jdk1.8
 */
public interface UserAddressMapper {

    int insert(UserAddress userAddress);

    int insert10(UserAddress userAddress);

    int insert2(UserAddress userAddress);

    List<UserAddress> selectUserAddress();

    int batchInsert(List<UserAddress> userAddresses);
}
