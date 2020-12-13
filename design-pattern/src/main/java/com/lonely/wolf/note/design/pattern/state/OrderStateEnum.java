package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public enum OrderStateEnum {
    WAIT_PAID,//待支付
    WAIT_DELIVER,//待发货
    RECEIVE_GOODS;//已收货
}
