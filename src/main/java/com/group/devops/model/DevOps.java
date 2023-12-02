package com.group.devops.model;

import javax.persistence.*;

@Entity
public class DevOps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed = false;

    public DevOps() {}

    // Constructors, getters, and setters...

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public DevOps(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Crud: {" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", completed='" + this.completed + '\'' +
                '}';
    }
}

