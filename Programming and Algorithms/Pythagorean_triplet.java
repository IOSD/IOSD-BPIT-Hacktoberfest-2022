import java.util.*;
public class Pythagorean_triplet{

    public static void main(String[] args) {
        
    Scanner sc=new Scanner(System.in);		//making object of scanner class
    
    int first=sc.nextInt();			//inputing first number
    int second=sc.nextInt();			//inputing second number
    int third=sc.nextInt();			//inputing third number
        
    if(first>second & first>third){			//condition to check if first number is the greatest one

        if(first*first==second*second+third*third){	//to check if it follows the rule of pythagorean triplet

            System.out.println("They form a pythagorean triplet");

        }
        else{

            System.out.println("They do not form a pythagorean triplet");

        }
    } 
    else if(second>third & second>first){		//condition to check if second number is the greatest one

        if(second*second==first*first+third*third){	//to check if it follows the rule of pythagorean triplet

            System.out.println("They form a pythagorean triplet");

        }
        else{

            System.out.println("They do not form a pythagorean triplet");

        }
    }
    else{					//this condition will run if third number is the largest one

         if(third*third==second*second+first*first){	//to check if it follows the rule of pythagorean triplet

            System.out.println("They form a pythagorean triplet");

        }
        else{

            System.out.println("They do not form a pythagorean triplet");

        }

    }
        
    }
}
