package com.example.stringbuildbuff;

public class StringBuilderBuffer {

    public static void main(String[] args) throws Exception{

        //StringBuilder object is a string object that is mutable but not thread safe
        StringBuilder sb = new StringBuilder("Ahh gee Rick, Im not sure about this \n");
        sb.append("You'll be fine Morty, just go through the portal");

        System.out.println(sb);

        //If you are using stringbuilder or buffer and you need a string for your method,
        //you can use the .toString()
        String output = sb.toString();

        System.out.println(output);

        //StringBuffer is a string object that is mutable and threadsafe
        StringBuffer sBuff = new StringBuffer("Rick");
        sBuff.append(" & ");
        sBuff.append("Morty");

        System.out.println(sBuff);
    }

}
