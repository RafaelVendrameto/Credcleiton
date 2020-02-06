package br.com.credcleiton.credcleiton.service;

public class listsrBancosExeptions extends Exception {

    private String msg;

    public listsrBancosExeptions(String msg, String cause) {
        super(msg, new Exception(cause));
        this.msg = msg;

    }

    public listsrBancosExeptions(String msg) {
    }

    public String getMsg() {
        return msg;
    }
}
