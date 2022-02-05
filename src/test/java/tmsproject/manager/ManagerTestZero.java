package tmsproject.manager;

import org.junit.jupiter.api.Test;
import tmsproject.domain.Issue;
import tmsproject.repository.RepositoryTms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTestZero {
    private RepositoryTms repository = new RepositoryTms();

    private Manager manager = new Manager(repository);


    private Issue eighth = new Issue(8, "author0", "assignee1", "label3", true);

    @Test
    public void shouldAddNew() {

        manager.add(eighth);

        List<Issue> expected = List.of(eighth);
        List<Issue> actual = repository.findAll();

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFilterAuthorByNone() {

        List<Issue> expected = List.of();
        List<Issue> actual = manager.filterByAuthor(null);

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFilterAssigneeByNone() {

        List<Issue> expected = List.of();
        List<Issue> actual = manager.filterByAssignee(null);

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFilterLabelByNone() {

        List<Issue> expected = List.of();
        List<Issue> actual = manager.filterByAssignee(null);

        assertEquals(expected, actual);


    }

}
