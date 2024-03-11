//Leaky Bucket congestion control java program.

import java.util.*;

public class LB{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter no of packets: ");
        n = sc.nextInt();
        System.out.println("Enter the bucket size:");
        int b = sc.nextInt();
        System.out.println("Enter output rate:");
        int out = sc.nextInt();
        int []packet = new int[n];
        System.out.println("Enter packet size in order:");
        for(int i=0 ; i<n ; i++){
            packet[i] = sc.nextInt();
        }
        
        List <Integer> buffer = new ArrayList <> ();
        for(int i:packet){
            if(i<=b){
                buffer.add(i);
            }
        }
        System.out.println("Sent Data");
        while(!buffer.isEmpty()){
            if(buffer.get(0)<=out){
                System.out.println("Data Sent :"+buffer.get(0));
                buffer.remove(0);
            }
            else{
                System.out.println("Data Sent : "+out);
                buffer.set(0,buffer.get(0)-out);
            }
        }
    }
}
