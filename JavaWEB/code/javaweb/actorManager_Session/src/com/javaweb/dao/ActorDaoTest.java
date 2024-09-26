package com.javaweb.dao;

import com.javaweb.bean.Actor;

public class ActorDaoTest {
    public static void main(String[] args) {
        ActorDao actorDao = new ActorDao();
        // Actor actor1 = new Actor(50, "张家辉", "扫毒");
        // actorDao.insert(actor1);
        /*actorDao.updateById(50,"张家辉", "重生");
        List<Actor> actorList = actorDao.selectAll();
        for (Actor actor : actorList) {
            System.out.println(actor);
        }
        System.out.println("-------------------------");
        Actor actor = actorDao.selectById(10);
        System.out.println(actor);
        boolean deleted = actorDao.deleteById(50);
        System.out.println(deleted);*/
        actorDao.insert(new Actor(10,"张家辉", "重生"));
        actorDao.insert(new Actor(20,"周润发", "赌神"));
    }
}
