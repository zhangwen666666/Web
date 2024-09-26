package com.javaweb.bean;

import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = -65789143657839L;

    private int actorId;
    private String actorName;
    private String actorWork;

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", actorName='" + actorName + '\'' +
                ", actorWork='" + actorWork + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId);
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorWork() {
        return actorWork;
    }

    public void setActorWork(String actorWork) {
        this.actorWork = actorWork;
    }

    public Actor(int actorId, String actorName, String actorWork) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.actorWork = actorWork;
    }

    public Actor() {
    }
}
