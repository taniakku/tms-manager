package tmsproject.manager;

import tmsproject.repository.RepositoryTms;

import tmsproject.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private RepositoryTms repository;

    public Manager(RepositoryTms repository) {
        this.repository = repository;
    }

    public Manager() {
    }

    public void add(Issue issue) {
        this.repository.save(issue);

    }

    //открытые
    public List<Issue> showOpened(boolean opened) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.isOpened() == true) {
                result.add(issue);
            }
        }
        return result;
    }

    //закрытые
    public List<Issue> showClosed(boolean opened) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.isOpened() == false) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAuthor(String text) {
        return repository.filterAll(e -> e.getAuthor().equalsIgnoreCase(text));
    }

    public List<Issue> filterByAssignee(String text) {
        return repository.filterAll(e -> e.getAssignee().equalsIgnoreCase(text));
    }

    public List<Issue> filterByLabel(String text) {
        return repository.filterAll(e -> e.getLabel().equalsIgnoreCase(text));
    }


    public void open(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id && !issue.isOpened()) {
                issue.setOpened(true);
            }

        }
    }

    public void close(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id && issue.isOpened()) {
                issue.setOpened(false);
            }

        }

    }
}







