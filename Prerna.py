def add(a):
    sum=a
    b=float(input("Enter the next numbers to add : "))
    sum+=b
    c=str(input("want to add more (y/n) - "))
    if (c=="y" or c=="Y"):
        add(sum)
        return(sum)
    print("Ans = ",sum)
def sub(a):
    sum=a
    b=float(input("Enter the next numbers to subtract : "))
    sum-=b
    c=str(input("want to subtract more (y/n) - "))
    if (c=="y" or c=="Y"):
        sub(sum)
        return(sum)
    print("Ans = ",sum)
def multiply(a):
    sum=a
    b=float(input("Enter the next numbers to multiply : "))
    sum*=b
    c=str(input("want to multiply more (y/n) - "))
    if (c=="y" or c=="Y"):
        multiply(sum)
        return(sum)
    print("Ans = ",sum)
def divide(a):
    sum=a
    b=float(input("Enter the next numbers to divide : "))
    sum/=b
    c=str(input("want to divide more (y/n) - "))
    if (c=="y" or c=="Y"):
        divide(sum)
        return(sum)
    print("Ans = ",sum)

def main():
    while True:
        option=int(input("Select what operation you want to do -\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Quit\nEnter the number - "))
        if (option==1):
            a=int(input("Enter the first number : "))
            add(a)
        elif (option==2):
            a=int(input("Enter the first number : "))
            sub(a)
        elif (option==3):
            a=int(input("Enter the first number : "))
            multiply(a)
        
        elif (option==4):
            a=int(input("Enter the first number : "))
            divide(a)
        
        else :
            print("Quit..")
            break
main()
