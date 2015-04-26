package cs2114.puzzlerpg.puzzle;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * A linked list implementation with index lookup.
 *
 * @param <E>
 *            The type of each member.
 * @author Andrew Dudash
 * @version Apr 8, 2015
 */
public class LinkedList<E>
    implements Iterable<E>
{
    private Node<E> head;


    /**
     * Construct a new empty list.
     */
    public LinkedList()
    {
        head = null;
    }


    /**
     * Set the value at the given position
     *
     * @param index
     *            The index of the node to change.
     * @param item
     *            The value to change the node to.
     */
    public void set(int index, E item)
    {
        if (head == null)
        {
            return; // Should throw an exception
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
        {
            if (temp.getNext() == null)
            {
                return; // Should throw an exception.
            }
            temp = temp.getNext();
        }
        temp.setData(item);
    }


    /**
     * Return the value at the given position.
     *
     * @param index
     *            The given position. @return The value at that position.
     * @return The item at the index or null if the index does not exist.
     */
    public E get(int index)
    {

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++)
        {
            if (head == null)
            {
                return null; // TODO Exceptions
            }
            currentNode = currentNode.getNext();
        }
        return currentNode.data();
    }


    /**
     * Get the value of the first item.
     *
     * @return value of first item.
     */
    public E first()
    {
        return get(0);
    }


    /**
     * Get the value of the last item.
     *
     * @return value of last item
     */
    public E last()
    {
        return get(size() - 1);
    }


    /**
     * Get the size of the list.
     *
     * @return Size of the list.
     */
    public int size()
    {

        int accum = 0;
        Node<E> currentNode = head;
        while (currentNode != null)

        {
            currentNode = currentNode.getNext();
            accum++;
        }
        return accum;
    }


    /**
     * Check if the list is empty.
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }


    /**
     * Insert a new value to the front of the list.
     *
     * @param newItem
     *            The new item.
     */
    public void insert(E newItem)
    {
        if (head == null)
        {
            head = new Node<E>(newItem);
        }
        else
        {
            Node<E> temp = head;
            head = new Node<E>(newItem);
            head.setNext(temp);
        }
    }


    /**
     * Delete the item at the given position.
     *
     * @param index
     *            The item to delete.
     * @return The value that was deleted.
     */
    public E delete(int index)
    {
        Node<E> currentNode = head;
        // Get the node preceding the one we want to remove.
        for (int i = 0; i < index - 1; i++) //Note the - 1
        {
            // Blow up, list too short.
            if (currentNode == null)
            {
                return null;
            }
            currentNode = currentNode.getNext();
        }
        // Blow up, list too short.
        if (currentNode.getNext() == null)
        {
            return null;
        }
        // If removing the tail.
        else if (currentNode.getNext().getNext() == null)
        {
            E temp = currentNode.getNext().data();
            currentNode.setNext(null);
            return temp;
        }
        // If removing a middle node.
        else
        {
            E temp = currentNode.getNext().data();
            currentNode.setNext(currentNode.getNext().getNext());
            return temp;
        }
    }


    /**
     * Used for iterating over the linked list.
     *
     * @return An iterator for the values in the linked list.
     */
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }


    private class LinkedListIterator
        implements Iterator<E>
    {
        Node<E> current;
        int     index;


        public LinkedListIterator()
        {
            current = head;
            index = 0;
        }


        public boolean hasNext()
        {
            return current != null;
        }


        public E next()
        {
            if (hasNext())
            {
                E temp = current.data();
                current = current.getNext();
                index++;
                return temp;
            }
            else
            {
                throw new NoSuchElementException("There are no elements left.");
            }
        }


        public void remove()
        {
            delete(index);
        }
    }


    /**
     * Linked list nodes.
     */
    private class Node<E>
    {
        private E       value;
        private Node<E> next;


        /**
         * Create a new node linked to null.
         *
         * @param value
         *            The value inside the node.
         */
        @SuppressWarnings("unused")
        public Node(E value)
        {
            this.value = value;
            this.next = null;
        }


        /**
         * Point the next node to the argument node.
         *
         * @param next
         *            The new next node.
         */
        public void setNext(Node<E> next)
        {
            this.next = next;
        }


        /**
         * Return the next node or null if there are no other nodes.
         *
         * @return next node or null
         */
        public Node<E> getNext()
        {
            return next;
        }


        /**
         * Get the datum in the node.
         *
         * @return The datum.
         */
        public E data()
        {
            return value;
        }


        /**
         * Set the datum in the node.
         *
         * @param newValue
         *            The new value for the datum.
         */
        public void setData(E newValue)
        {
            value = newValue;
        }

    }


    /**
     * Check if a list contains an item.
     *
     * @param targetItem
     *            The item to look for.
     * @return True if the target item is found.
     */
    public boolean contains(E targetItem)
    {
        for (E item : this)
        {
            if (item.equals(targetItem))
            {
                return true;
            }
        }
        return false;
    }

}
