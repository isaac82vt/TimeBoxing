/**
 * 
 */
package timeBoxing;

//import linkedlist.SinglyLinkedList.Node;

//import linkedlist.SinglyLinkedList;
//import linkedlist.SinglyLinkedList.Node;

//import linkedlist.SinglyLinkedList.Node;

/**
 * @author Isaac Brumbley
 * 
 * This class defines a linked list to sort my tasks.
 *
 */
public class LList<T> {
    
    /**
     * 
     * @author Isaac Brumbley
     *
     * This static class will serve as the nodes in
     * the linked list
     */
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         * @param d
         *      the data to put inside the node
         */
        public Node(D d) {
            data = d;
        } 

        /**
         * Sets the node after this node
         * @param n 
         *      the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }

        /**
         * Gets the next node
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }

        /**
         * Gets the data in the node
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }
    
    
    
    
    
    private int size; // size or length of linked list
    private Node<T> head; // the first node in the list
    
    /**
     * Constructor of LinkedList
     * Initializes the linked list
     */
    public LList() {
        size = 0;
        head = null;
    }
    
    /**
     * Returns the length of the list
     * 
     * @return the size of the linked list
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Checks if the linked list is empty
     * 
     * @return true if array is empty, false otherwise
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, T obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size() + 1)) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<T>(obj);
        }

        // all other cases
        else {
            if (index == 0) {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                        
                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }
    
    /**
     * Adds an object to the end of the list
     * 
     * @param obj 
     *      This is the object that will be added
     *      to the list
     */
    public void add(T obj) {
     // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<T>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;    }
    
    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public boolean remove(int index) {
        
        // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } 
        
        // check when index is 0
        if (index == 0) {  
            head = null;
            return true;
        }
        
        Node<T> curr = head;
        int currIndex = 0;
        
        while (curr.next != null) {
            if (currIndex + 1 == index) {
                Node<T> newNode = curr.next.next;
                curr.setNext(newNode);
                size--;
                return true;
            }
            curr = curr.next;
            currIndex++;
        }
        
        return false;
        
    }
    
    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(T obj) {
        Node<T> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }
    
    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        if (obj == null) {
            return false;
        }
        Node<T> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T obj) {
        if (obj == null) {
            return -1;
        }
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     *      the index of the element to replace
     * @param element
     *      the element to be stored at the specified position
     * @throws IndexOutOfBoundsException
     *      if the index is out of range (index < 0 || index >= size())
     */
    public void set(int index, T element) {
        // check if the index is out of bounds
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // check if the element is null
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                current.data = element;
                return;
            }
            currentIndex++;
            current = current.next();
        }
    }



    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LList<T> other = ((LList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }

    
    
}