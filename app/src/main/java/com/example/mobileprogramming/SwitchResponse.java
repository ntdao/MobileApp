package com.example.mobileprogramming;

public class SwitchResponse {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public SwitchResponse(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}
