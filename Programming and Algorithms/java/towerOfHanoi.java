import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
       
       Scanner sc=new Scanner (System.in);
       
       int n=sc.nextInt();
       
       int t1=sc.nextInt();     //source tower
       int t2=sc.nextInt();     //destination tower
       int t3=sc.nextInt();     //auxiliary or helper tower
       
       toh(n,t1,t2,t3);
    }

    public static void toh(int n, int t1, int t2, int t3){
        
        if(n==1){   //edge case
            
            System.out.println(n+" [ "+t1+" -> "+t2+" ] ");
            
        }
        else{
            
            toh(n-1,t1,t3,t2);      //transfering all disk except last one on auxiliary tower 
            
            System.out.println(n+" [ "+t1+" -> "+t2+" ] ");     //transfering last disk on destination tower from source tower 
            
            toh(n-1,t3,t2,t1);      //transfering all the disk placed on auxiliary tower to destination tower
            
        }
        
    }

}
