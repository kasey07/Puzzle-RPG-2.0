package cs2114.puzzlerpg.puzzle;

import java.util.Iterator;

/**
 * A linked list implementation with index lookup.
 *
 * @param <E>
 *            The type of each member.
 * @author Andrew Dudash
 * @version Apr 8, 2015
 */
public class LinkedList<E> implements Iterable<E>
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
     * @param index The index of the node to change.
     * @param value The value to change the node to.
     */
    public void set(int index, E item)
    {
        Node<E> currentNode = head;
        for (int i = 0; i < index - 1; i++)
        {
            if (currentNode == null)
            {
                return;
            }
        }
        Node<E> nextNode = currentNode.getNext();

    }


    /**
     * Return the value at the given position.
     *
     * @param index The given position. @return The value at that position.
     */
    public E get(int index)
    {

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++)
        {
            if (head == null)
            {
                return null;
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
     * Makes this the new element at the given index. The current element at
     * that index and all elements after it are moved to accommodate the new
     * value.
     *
     * @param newItem The new item.
     * @param index The index to insert the new value before.
     */
    public void insert(E newItem, int index)
    {
        // TODO
    }


    /**
     * Insert a new value to the front of the list.
     *
     * @param newItem
     *            The new item.
     */
    public void insert(E newItem)
    {
        insert(newItem, 0);
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
        if (index == 0)
        {
            Node<E> temp = head;
            head = null;
            return temp.data();
        }
        else
        {
            Node<E> lastNode = null;
            Node<E> currentNode = head;
            for (int i = 0; i < index; i++)
            {
                if (currentNode == null)
                {
                    // TODO List too short, blow up.

                }
                lastNode = currentNode;
                currentNode = currentNode.getNext();
            }
            lastNode.setNext(currentNode.getNext());
            return currentNode.data();
        }
    }


    /**
     * Used for iterating over the linked list.
     *
     * @return An iterator for the values in the linked list.
     */
    public Iterator<E> iterator()
    {
        return null;
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
         * @param value The value inside the node.
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

    }


    /**
     * Check if a list contains an item.
     * @param targetItem The item to look for.
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
