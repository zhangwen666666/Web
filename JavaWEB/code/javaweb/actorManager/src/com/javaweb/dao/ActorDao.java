package com.javaweb.dao;

import com.javaweb.bean.Actor;

import java.util.List;

public class ActorDao extends BaseDao {
    /**
     * 插入演员
     *
     * @param actor 演员
     * @return 1表示新增了一条数据，返回0表示插入失败
     */
    public boolean insert(Actor actor) {
        String sql = "insert into t_actor(actorId, actorName, actorWork) values(?, ?, ?)";
        return executeUpdate(sql, actor.getActorId(), actor.getActorName(), actor.getActorWork()) == 1;
    }

    // 更新演员信息
    public boolean updateById(int actorId, String actorName, String actorWork) {
        String sql = "update t_actor set actorName=?, actorWork=? where actorId=?";
        return executeUpdate(sql, actorName, actorWork, actorId) == 1;
    }

    // 删除演员
    public boolean deleteById(int actorId) {
        String sql = "delete from t_actor where actorId=?";
        return executeUpdate(sql, actorId) == 1;
    }

    // 查询演员列表
    public List<Actor> selectAll() {
        String sql = "select * from t_actor";
        return executeQuery(Actor.class, sql);
    }

    // 根据id查询演员信息
    public Actor selectById(int actorId) {
        String sql = "select * from t_actor where actorId=?";
        List<Actor> list = executeQuery(Actor.class, sql, actorId);
        if (list != null && !list.isEmpty()) {
            return list.getFirst();
        }
        return null;
    }
}
