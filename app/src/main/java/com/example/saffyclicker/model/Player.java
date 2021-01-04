package com.example.saffyclicker.model;

import android.app.Application;

public class Player {
    private String name;
    private int point;
    private int skill;
    private int multiply;

    public Player(String name, int point, int skill, int multiply) {
        this.name = name;
        this.point = point;
        this.skill = skill;
        this.multiply = multiply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getMultiply() {
        return multiply;
    }

    public void setMultiply(int multiply) {
        this.multiply = multiply;
    }
}
