package org.itstep.myWebApp.model;

abstract public class Entity {

    protected Integer id;

    protected String name;

    protected Entity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
