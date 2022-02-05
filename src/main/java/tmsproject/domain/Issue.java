package tmsproject.domain;
import tmsproject.repository.RepositoryTms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Issue {
    private int id;
    private String author;
    private String assignee;
    private String label;
    private boolean opened;

    public Issue() {

    }

    public Issue(int id, String author, String assignee, String label, boolean opened) {
        this.id = id;
        this.author = author;
        this.assignee = assignee;
        this.label = label;
        this.opened = opened;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }


}
