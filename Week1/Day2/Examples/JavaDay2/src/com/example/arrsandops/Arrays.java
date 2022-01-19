package com.example.arrsandops;

public class Arrays {

    //Ways to create an arrays
    //Create a new Array with 5 indexes that can store strings
    public String names[] = new String[5];

    //Create an array with the indexes already defined
    public String places[] = {"Iowa", "Florida", "Texas"};

    public int[] numbers = {1,2,3,4,5,6,7,8,9,10};

    //Arrays can also be multidimensional
    //Makes an empty 2d array
    public int[][] my2dArray = new int[3][3];

    public int myOther2dArray[][] = {{1,2,3},
                                     {4,5,6},
                                     {7,8,9}};


    public int accessIndex(int index, int[] arr){
        //You can use the square brackets to access specific indexes of an array
        //But be careful because if you try to access an index that does exist
        //You will get an indexoutofbounds exception
        return arr[index];
    }

    public void setName(int index, String name){
        names[index] = name;
        System.out.println("Set the value of index: " + index + " to " + name);
    }

    //You can view the size of the array with .length
    public int arraySize(String[] arr){
        return arr.length;
    }

    //To access the value in a 2d array is the same as a 1d, but you must input both indexes
    public int valueAt2d(int [][] arr, int indexX, int indexY){
        return arr[indexX][indexY];
    }

    //Set the value of a 2d array
    public void set2dIndex(int index1, int index2, int value){
        my2dArray[index1][index2] = value;
    }

}
