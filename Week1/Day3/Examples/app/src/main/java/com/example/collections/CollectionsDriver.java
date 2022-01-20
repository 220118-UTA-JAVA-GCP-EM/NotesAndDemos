package com.example.collections;

import com.example.generics.GenericLinkedList;
import com.example.models.Student;

import javax.swing.text.Style;
import java.util.*;

public class CollectionsDriver {

    public static void main(String args[]){
        GenericLinkedList<String> ll = new GenericLinkedList<>();

        ll.add("Hello");
        ll.add("world");
        ll.add("adding");
        ll.add("more");
        ll.add("will");
        ll.add("I");
        ll.add("break?");
        System.out.println(ll.toString());

        ll.remove(0);
        ll.remove(3);
        ll.remove(4);
        System.out.println(ll.toString());
        //ll.remove(4);

        System.out.println(ll.get(0));
        System.out.println(ll.get(3));
        //System.out.println(ll.get(4));

        //ll.add(5);
        GenericLinkedList<Integer> integerGenericLinkedList = new GenericLinkedList<>();
        integerGenericLinkedList.add(5);

        String classes[] = {"Math", "English", "Science"};

        /* Collections API Data Structures */
        Student s1 = new Student("Summer", "Smith", classes, 3.0);
        Student s2 = new Student("Morty", "Smith", classes, 2.3);
        Student s3 = new Student("Tiny", "Rick", classes, 4.0);
        Student s4 = new Student("Jessica", "W", classes, 3.6);

        //LinkedLists
        //Luckily we don't ACTUALLY have create these ourselves, because Java has already created them for us
        List<Student> studentLinkedList = new LinkedList<>();

        //Like our custom linked list we can add students
        studentLinkedList.add(s1);
        studentLinkedList.add(s2);
        studentLinkedList.add(s3);
        studentLinkedList.add(s4);

        //If we want to loop through, we could use a regular for loop, or we can use an iterator
        //To get an iterator you call LinkedList.iterator()
        Iterator<Student> studentIterator = studentLinkedList.iterator();

        //With our iterator we can loop through linked lists with .next() method of the iterator
        System.out.println("Looping through our students with an iterator");

        while(studentIterator.hasNext()){
            System.out.println(studentIterator.next());
        }

        //There are also many other LinkedList methods you can see by looking here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

        //ArrayList
        List<Student> studentArrayList = new ArrayList<>();

        //Again arraylist has all the functionality you could really need
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);

        System.out.println("Looping through the arraylist with a regular ole for loop");
        for(int i=0; i<studentArrayList.size(); i++){
            System.out.println(studentArrayList.get(i));
        }

        //There are many other ArrayList methods you can see by looking here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        //Sets, in Java will most likely use a HashSet, TreeSet, or a LinkedHashSet
        //Treesets are sorted with a comparator, we will take a look at these later on
        //Remember, sets wont store duplicates, you can try but they will be stored
        Set<Student> studentHashSet = new HashSet<>();

        studentHashSet.add(s1);
        studentHashSet.add(s1);

        System.out.println("Printing our hashset");
        //We added the same student twice, but if we print out the elements, we will only see this student once
        for(Student s : studentHashSet){
            System.out.println(s);
        }

        //More methods of the HashSet class can be found here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html

        //Queues and Deques
        //Queues are implemention of the first in first our data structure
        //Deque is a double ended queue, you can take and add from either the front or the rear

        Deque<Student> studentDeque = new ArrayDeque<>();

        //To add students to the front of the queue
        studentDeque.push(s1);
        System.out.println("Our Queue");
        System.out.println(studentDeque);

        //To add a student to the end of the queue use .add
        studentDeque.add(s2);
        System.out.println(studentDeque);

        //Add one more to the front
        studentDeque.push(s3);
        System.out.println(studentDeque);

        //Add one more to the back
        studentDeque.add(s4);
        System.out.println(studentDeque);

        //To remove from the front of the queue
        Student tinyRick = studentDeque.remove();
        System.out.println(tinyRick);

        //To remove the last object use removeLast()
        Student jessica = studentDeque.removeLast();
        System.out.println(jessica);
        System.out.println(studentDeque);

        //For more information about what you can do with the Deque look here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html

        //Maps
        //With maps we store items in a key value pair
        //The most popular implemenation is a Hashmap

        //Hashmaps are great for searching for information against the key because they generate
        //a hash based on the value generated from an algorithm when passing that key
        //Then the object gets stored in the corresponding index that equals that hashed value
        //Map<Key,Value>
        Map<String, Student> studentMap = new HashMap<>();

        System.out.println("Playing with maps");

        //We insert data using .put
        studentMap.put("Tiny Rick", tinyRick);
        studentMap.put("Jessica", jessica);
        studentMap.put("Summer", s1);
        studentMap.put("Morty", s2);

        //To search for a value use the .get(key) method
        System.out.println(studentMap.get("Summer"));

        //If you remember, maps are not technically part of the collections API because they do not implement Iterable
        //However, you can still iterate through the values or keys of the map
        Iterator<Student> mapValues = studentMap.values().iterator();
        Collection<Student> mapCollection = studentMap.values();

        while(mapValues.hasNext()){
            System.out.println(mapValues.next());
        }

        //For more information on the HashMap class you can look here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

        //The Collections class is a class that holds utility methods we can use on Collections
        //This includes things like sorting collections
        //However for sorting work we need to implement the Comparable interface
        //We implemented the interface to compare students based on their gpas
        Collections.sort(studentArrayList);
        System.out.println(studentArrayList);


        //We mentioned TreeSets earlier, as a set that holds no duplicates, but stores the items in sorted order
        //To use a tree set we must have some way to compare the items, treesets use comparators
        //to create our own comparator we create a class that implements Comparator
        Set<Student> studentTree = new TreeSet<>();
        studentTree.add(s1);
        studentTree.add(s2);
        studentTree.add(s3);
        studentTree.add(s4);

        System.out.println(studentTree);
    }

}
