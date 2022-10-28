#Python program to add two numbers using function

def add_num(a,b):#function for addition
    sum=a+b;
    return sum; #return value
num1=int(input("input the number one: "))#input from user for num1
num2=int(input("input the number one :"))#input from user for num2

print("The sum is",add_num(num1,num2))#call te function
