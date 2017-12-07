/**
 * Created by Ivank on 2017-12-05.
 */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arr1 = new ArrayList<>();

        Collections.addAll(arr1, 3,4,3,1,9,6);
        Collections.sort(arr1, (o1, o2) -> (o1.compareTo(o2)));

        MyArrayList<Integer> arr2 = new MyArrayList<>();

        Collections.addAll(arr2, 18,19,12,15,16,17);
        Collections.sort(arr2, (o1, o2) -> (o1.compareTo(o2)));

        for (int i = 0; i < arr2.size(); i++)
        {
            System.out.println(arr2.get(i));

        }

        Collections.copy(arr2, arr1);

        for (int i = 0; i < arr2.size(); i++)
        {
            System.out.println(arr2.get(i));

        }
    }
}
