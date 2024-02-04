//FrameSort java program

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class FrameSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Frames:");
        int n = sc.nextInt();
        Random rd = new Random();
        System.out.println("Enter the Data for Each Frame");
        ArrayList <int []> arr = new ArrayList<>();
        for(int i =0;i<n;i++)
            arr.add(new int []{sc.nextInt() , rd.nextInt(10000)}); 
        System.out.println("Before Sorting");
        for (int[] is : arr) 
            System.out.println(is[0] + " "+is[1]);
            
        Collections.sort(arr , (a,b) -> Integer.compare(a[1], b[1]));

        System.out.println("After Sorting");
        for (int[] is : arr) 
            System.out.println(is[0] + " "+is[1]);
        sc.close();
    }
}
