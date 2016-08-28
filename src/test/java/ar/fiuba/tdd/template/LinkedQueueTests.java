package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedQueueTests {
    @Test
    public void initialListIsEmpty() {
        assertTrue(new LinkedQueue<String>().isEmpty());
    }

    @Test
    public void afterAddListIsNotEmpty() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        assertFalse(linkedQueue.isEmpty());
    }

    @Test
    public void afterAddElementIsInList() {
        final String test = "test";
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add(test);
        assertEquals(linkedQueue.top(),test);
    }

    @Test
    public void initialListHaveZeroSize() {
        assertEquals(new LinkedQueue<String>().size(),0);
    }

    @Test
    public void afterAddElementSizeIsOne() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        assertEquals(linkedQueue.size(),1);
    }

    @Test
    public void afterAddTwoElementsSizeIncerease() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        linkedQueue.add("test2");
        assertEquals(linkedQueue.size(),2);
    }

    @Test
    public void afterAddTwoElementsTopNotChange() {
        final String test = "test";
        final String test2 = "test2";
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add(test);
        linkedQueue.add(test2);
        assertEquals(linkedQueue.top(),test);
    }

    @Test
    public void addRemoveElementListEmpty() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        linkedQueue.remove();
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void addTwoElementsRemoveOneListSizeOne() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        linkedQueue.add("test2");
        linkedQueue.remove();
        assertEquals(linkedQueue.size(),1);
    }
}
