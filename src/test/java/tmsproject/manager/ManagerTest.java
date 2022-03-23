package tmsproject.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tmsproject.domain.Issue;
import tmsproject.repository.RepositoryTms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private RepositoryTms repository = new RepositoryTms();

    private Manager manager = new Manager(repository);

    private Issue first = new Issue(1, "author1", "assignee1", "label1", true);
    private Issue second = new Issue(2, "author2", "assignee2", "label3", true);
    private Issue third = new Issue(3, "author3", "assignee3", "label2", false);
    private Issue fourth = new Issue(4, "author2", "assignee2", "label3", true);
    private Issue fifth = new Issue(5, "author1", "assignee1", "label1", false);
    private Issue sixth = new Issue(6, "author3", "assignee2", "label3", true);
    private Issue seventh = new Issue(7, "author1", "assignee1", "label3", false);


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(sixth);
        repository.save(fifth);
        repository.save(seventh);
    }


    @Test
    public void shouldFindOpened() {

        List<Issue> expected = List.of(first, second, fourth, sixth);
        List<Issue> actual = manager.showOpened(true);

        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindClosed() {

        List<Issue> expected = List.of(third, fifth, seventh);
        List<Issue> actual = manager.showClosed(false);

        assertEquals(expected, actual);

    }

    @Test
    public void shouldFilterByAuthor() {

        List<Issue> expected = List.of(first, fifth, seventh);
        List<Issue> actual = manager.filterByAuthor("author1");

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFilterByAssignee() {

        List<Issue> expected = List.of(second, fourth, sixth);
        List<Issue> actual = manager.filterByAssignee("assignee2");

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFilterByLabel() {

        List<Issue> expected = List.of(second, fourth, sixth, seventh);
        List<Issue> actual = manager.filterByLabel("LABEL3");

        assertEquals(expected, actual);


    }



    @Test
    public void shouldCloseIssue() {

        Issue issue = new Issue();

        manager.close(6);

        assertEquals(false, issue.isOpened());


    }

    @Test
    public void shouldOpenIssue() {

        Issue issue = new Issue();

        manager.open(5);

        assertEquals(true, issue.isOpened());


    }


}