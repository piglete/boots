package com.bych.soket.vo;

/**
 * websocket返回数据实体类
 */
public class SocketVo {
    private String message;

    public SocketVo(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
