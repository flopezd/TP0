package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedQueueTests {
    @Test
    public void initialQueueIsEmpty() {
        assertTrue(new LinkedQueue<String>().isEmpty());
    }

    @Test
    public void afterAddQueueIsNotEmpty() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        assertFalse(linkedQueue.isEmpty());
    }

    @Test
    public void afterAddElementIsInQueue() {
        final String test = "test";
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add(test);
        assertEquals(linkedQueue.top(),test);
    }

    @Test
    public void initialQueueHaveZeroSize() {
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
    public void addRemoveElementQueueEmpty() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        linkedQueue.remove();
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void addTwoElementsRemoveOneQueueSizeOne() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.add("test");
        linkedQueue.add("test2");
        linkedQueue.remove();
        assertEquals(linkedQueue.size(),1);
    }

    @Test(expected = AssertionError.class)
    public void topOnEmptyQueueThrowsException() {
        new LinkedQueue<String>().top();
    }

    @Test(expected = AssertionError.class)
    public void removeOnEmptyQueueThrowsException() {
        new LinkedQueue<String>().remove();
    }
}
