package cs2114.puzzlerpg.puzzle;

import student.TestCase;

/**
 * A test class for the LinkedList<E> class.
 *
 * @author andrew
 * @version Apr 8, 2015
 */
public class LinkedListTest
    extends TestCase
{
    private LinkedList<String> list;


    /**
     * Create a new LinkedListTest object.
     */
    public LinkedListTest()
    {
        // Empty constructor. Not even sure I need this. (Cargo Cult! :D)
    }


    public void setUp()
    {
        list = new LinkedList<String>();
    }


    /**
     * Test the get method.
     */
    public void testGet()
    {
        list.insert("A");
        list.insert("B");
        list.insert("C");
        assertEquals("A", list.get(2));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(0));
    }


    /**
     * Test the first and last methods.
     */
    public void testFirstLast()
    {
        list.insert("A");
        list.insert("B");
        list.insert("C");
        assertEquals("C", list.first());
        assertEquals("A", list.last());
    }


    /**
     * Test the isEmpty method.
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.insert("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Test the single argument insert method.
     */
    public void testInsertSingle()
    {
        assertEquals(0, list.size());
        list.insert("hi");
        assertEquals(1, list.size());
        assertEquals("hi", list.first());
    }


    /**
     * Test the delete method.
     */
    public void testDelete()
    {
        list.insert("A");
        list.insert("B");
        list.insert("C");
        list.delete(1);
        assertEquals(2, list.size());
        assertEquals("C", list.first());
        assertEquals("A", list.last());
    }


    /**
     * Test the iterator.
     */
    public void testIterator()
    {
        list.insert("A");
        list.insert("B");
        list.insert("C");
        String accum = "";
        for (String item : list)
        {
            accum += item;
        }
        assertEquals("CBA", accum);
    }


    /**
     * Test the contains method.
     */
    public void testContains()
    {
        assertFalse(list.contains("A"));
        list.insert("B");
        assertFalse(list.contains("A"));
        assertTrue(list.contains("B"));
    }
}
