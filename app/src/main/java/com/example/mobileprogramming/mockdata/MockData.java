package com.example.mobileprogramming.mockdata;

import com.example.mobileprogramming.model.Device;
import com.example.mobileprogramming.model.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public List<User> users = new ArrayList<>();
    public List<Device> devices = new ArrayList<>();

    public MockData() {
        this.users = new ArrayList<>(List.of(new User("097427234", "111111", "Nguyễn An", "05/06/1990", "a1@gmail.com", "Hải Phòng"),
                new User("097427234", "111111", "Nguyễn Hoa", "05/06/1990", "a2@gmail.com", "Hải Dương"),
                new User("097427234", "111111", "Nguyễn Hà", "05/06/1990", "a3@gmail.com", "Bắc Ninh"),
                new User("097427234", "111111", "Nguyễn Ngọc", "05/06/1990", "a4@gmail.com", "Hà Nam"),
                new User("097427234", "111111", "Nguyễn Thu", "05/06/1990", "a5@gmail.com", "Hà Nội"),
                new User("097427234", "111111", "Nguyễn Lan", "05/06/1990", "a6@gmail.com", "Quảng Ninh")));
    }
}
