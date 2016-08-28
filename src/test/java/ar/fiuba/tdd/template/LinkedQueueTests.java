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
}
