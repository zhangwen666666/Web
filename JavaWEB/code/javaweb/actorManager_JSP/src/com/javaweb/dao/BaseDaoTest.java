package com.javaweb.dao;

import com.javaweb.bean.Actor;

import java.util.List;

public class BaseDaoTest {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        String sql = "select * from t_actor where actorId=?";
        List<Actor> actorList = baseDao.executeQuery(Actor.class, sql, 20);
        for (Actor actor : actorList) {
            System.out.println(actor);
        }
    }
}
