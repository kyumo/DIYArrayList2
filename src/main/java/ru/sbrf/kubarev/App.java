package ru.sbrf.kubarev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DIYArrayList<String> list = new DIYArrayList<>(2);



        list.add("1");
        list.add("2");
        list.add("3");


        for (int j = 0 ; j<40; j++)
        {
            list.add("str  " + j);
        }

        ArrayList<String> ar = new ArrayList<>(3);

        ar.add("new 1");
        ar.add("new 2");

        list.addAll(ar);

        DIYArrayList<String> list2 = new DIYArrayList<>(list.size());

        for (int i=0; i<list.size();i++)
            list2.add("x" + i);




        Collections.copy(list2, list);



        Comparator<String> c = new Comparator<String>()
       {

          public int compare(String o1, String o2)
          {
              return o1.length()-o2.length();
          }
      };


        Collections.sort(list2, c);

    }
}
