package com.mj.findfriend.net.entity;

import com.google.gson.Gson;

/**
 * Created by huaqiang
 * on 2016-05-16.
 */
public abstract class Entity {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

