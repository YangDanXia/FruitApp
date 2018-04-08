package cn.demo.http.model;

import java.util.List;

public class Result {
    private int code;
    private String msg;
    private List<Goods> goods;
    private List<User> user;


    Result(int code, String msg, List<Goods> user) {
        this.code = code;
        this.msg = msg;
        this.goods = user;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }


}
