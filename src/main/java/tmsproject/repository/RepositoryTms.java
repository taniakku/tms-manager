package tmsproject.repository;

import tmsproject.domain.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class RepositoryTms {

    private List<Issue> issues = new ArrayList<>();

    public void save(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> findAll() {
        return issues;
    }

    public List<Issue> filterAll(Predicate<Issue> filter) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (filter.test(issue)) {
                result.add(issue);
            }

        }
        return result;
    }

    public List<Issue> findById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return (List<Issue>) issue;
            }
        }
        return null;
    }


}