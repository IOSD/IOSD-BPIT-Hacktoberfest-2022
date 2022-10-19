import mysql.connector as mycon


# 'root'--- is the username here
# 'hotelparadise'---- is database name


try:
    con=mycon.connect(host='localhost',user='root',passwd='-----',database='hotelparadise')
    cursor=con.cursor()
except:
    pass
    con=mycon.connect(host='localhost',user='root',passwd='-----')
    cursor=con.cursor()
    cursor.execute("create database hotelparadise;")
    con=mycon.connect(host='localhost',user='root',passwd='-----',database='hotelparadise')
    cursor=con.cursor()

print('*'*150)
print('**                                                           WELCOME TO HOTEL PARADISE                                                             **')
print('*'*150)


def entry():                #1 entry of customer
    global t
    try:
        cursor.execute('select max(customer_id) from hotel;')
        c=cursor.fetchone()
        for i in c:
            ci=i+1
    except:
        ci=1
 
    
    print("\nENTER THE DETAILS OF CUSTOMER'S-------->")

    while True:
        n=str(input("\nEnter Customer's Full Name: "))
        p=str(input("Enter Customer's Phone no. : "))
        ad=str(input("Enter Customer's Address: "))
        aa=str(input("Enter Customer's Aadhar(in 12-digits): "))
        ch=str(input("Enter Customer's Check In Date (in YYYY-MM-DD format): "))
        t=int(input('We have the following rooms for you:- \n1).Master Suite(double room)--->8000 \n2).Master Suite(single room)--->7000 \n3).Mini Suite(double room)--->6000 \n4).Mini Suite(single room)--->5000 \n5).Studio(double room)--->4000 \n4).Studio(single room)--->3000 \nEnter your choice please(number)--->' ))
        r=room()
        print('-'*60)
        print("\nYour Room No. is -->",r)
        print('Customer ID -->',ci)
        
        st="insert into hotel(customer_id,room_no,name,phone_no,address,aadhar,check_in_date,bill,room_type) values({},{},'{}',{},'{}',{},'{}',{},{})".format(ci,r,n,p,ad,aa,ch,0,t)
        
        cursor.execute(st)
        con.commit()
        
        ju=str(input('\nDo you want to input more data(Yes/No) : '))
        ci+=1
        if ju.lower()=='no':
            print('\n--------------DETAILS HAS BEEN SUCCESSFULLY REGISTERED--------------')

            break
    
    


def room():                                                     #for room number
    try:
        cursor.execute("select distinct(room_no) from hotel where check_out_date is null;")
        li=cursor.fetchall()
        l=[]
        
        for i in li:
            kl=i[0]
            l.append(kl)
        for r in range(101,351):
            if r not in l:
                if t==6 and r in range(101,151):
                    return r
                elif t==5 and r in range(151,201):
                    return r
                elif t==4 and r in range(201,251):
                    return r
                elif t==3 and r in range(251,301):
                    return r
                elif t==2 and r in range(301,326):
                    return r
                elif t==1 and r in range(326,351):
                    return r 
    except:
        if t==6:
            r=101
        elif t==5:
            r=151
        elif t==4:
            r=201
        elif t==3:
            r=251
        elif t==2:
            r=301
        elif t==1:
            r=326
        return r
    

                                                                               #2 to update data
def modify():
    try:
        print("\nEnter Customer's details whose data to be changed--->" )
        cd=str(input("Customer's ID: "))
        rn=int(input("Customer's Room No.: "))
        
        cursor.execute("select * from hotel where room_no='%s' and customer_id='%s'"%(rn,cd))
        data=cursor.fetchone()
        data=list(data)
        print("Check Customer's name ---",data[2])
        r=int(input("\n1. Customer's Name \n2. Customer's Phone No. \n3. Customer's Address \n4. Customer's Aadhar \n5. Customer's Check In Date \n6. Customer's Check Out Date  \n7. Customer's Bill \n8. Customer's Room Type \nWhat do you want to change(Enter the number) - "))
        rh=str(input('\nEnter the correct detail------->'))

        
        if r==1:
            data[2]=rh
        elif r==2:
            data[3]=rh
        elif r==3:
            data[4]=rh
        elif r==4:
            data[5]=int(rh)
        elif r==5:
            data[6]=rh
        elif r==6:
            pass
        elif r==7:
            data[8]=int(rh)
        elif r==8:
            data[9]=int(rh)
        else:
            print('####### YOU HAVE CHOSEN AN INVALID NUMBER #######')

            
        if r==6:
            cdd="update hotel set check_out_date='%s' where room_no='%s' and customer_id='%s';"
            cursor.execute(cdd%(rh,rn,cd))
        else:
            cdd="update hotel set name='%s',phone_no='%s',address='%s',aadhar='%s',check_in_date='%s',bill='%s',room_type='%s' where room_no='%s' and customer_id='%s';"
            vd=(data[2],data[3],data[4],data[5],data[6],data[8],data[9],rn,cd)
            cursor.execute(cdd%vd)
        con.commit()
        print('***************************DETAILS ARE SUCCESSFULLY UPDATED***************************')
    except:
        print('###### There is some error occurring......... ######')

        

                                                                                   #3 delete details
def delete():
    try:
        print('\nEnter the details of customer whose data you want to delete-','-'*70,sep='\n')
        cd=str(input("Customer's ID: "))
        cursor.execute("delete from hotel where customer_id='%s';"%(cd,))
        con.commit()
        print('**********************DETAILS ARE SUCCESSFULLY DELETED**********************')
        
    except:
        print("######## There is some error occurring.......... ########")
    


def read():                                          #4 [A]shows all details by cust.id
    try:
        cursor.execute("select * from hotel order by customer_id;")
        data=cursor.fetchall()
        print('\nDetails of All Customers')
        print('-'*165)
        print('%10s %10s %18s %15s %25s %15s %15s %15s %15s %15s'%('CUSTOMER ID','ROOM NO.','NAME','PHONE NO.','ADDRESS','AADHAR NO.','CHECK IN DATE','CHECK OUT DATE','BILL','ROOM TYPE'))
        print('-'*165)
        
        for row in data:
            j=0
            for i in row:
              j+=1
              if j ==5:
                  print('%25s'% i,end=' ')
              elif j==3:
                  print('%18s'% i ,end=' ')
              elif j==1 or j==2:
                  print('%10s'% i ,end=' ')
              else:
                  print('%15s'% i ,end=' ')
            print()
        print('-'*165)
    except:
        print("######## There is some error occurring......... ########")


def read1():                 #4 [B]shows all details by room no
    try:
        cursor.execute("select * from hotel order by ROOM_NO;")
        data=cursor.fetchall()
        print('\nDetails of All Customers')
        print('-'*165)
        print('%10s %10s %18s %15s %29s %15s %15s %15s %15s %15s'%('CUSTOMER ID','ROOM NO.','NAME','PHONE NO.','ADDRESS','AADHAR NO.','CHECK IN DATE','CHECK OUT DATE','BILL','ROOM TYPE'))
        print('-'*165)
        
        for row in data:
            j=0
            for i in row:
              j+=1
              if j ==5:
                  print('%29s'% i,end=' ')
              elif j==3:
                  print('%18s'% i ,end=' ')
              elif j==1 or j==2:
                  print('%10s'% i ,end=' ')
              else:
                  print('%15s'% i ,end=' ')
            print()
        print('-'*165)
    except:
        print("######## There is some error occurring......... ########")



def display():       #5 (A)details of particular customer
    try:
        cd=str(input("\nEnter Customer's ID whose details you want to see:"))
        nm=str(input("Enter Customer's Name:"))
        cursor.execute("select * from hotel where customer_id='%s' and name='%s'"%(cd,nm))
        data=cursor.fetchone()
        print('CUSTOMER\'S DETAILS-')
        print('='*60)
        print('CUSTOMER\'S ID : ',data[0])
        print('CUSTOMER\'S ROOM NO. : ',data[1])
        print('CUSTOMER\'S NAME. : ',data[2])
        print('CUSTOMER\'S PHONE NO : ',data[3])
        print('CUSTOMER\'S ADDRESS : ',data[4])
        print('CUSTOMER\'S AADHAR : ',data[5])
        print('CUSTOMER\'S CHECK IN DATE : ',data[6])
        print('CUSTOMER\'S CHECK OUT DATE : ',data[7])
        print('CUSTOMER\'S ROOM TYPE : ',data[9])
        print('CUSTOMER\'S BILL : ',data[8])
        print('='*60)
        
    except:
        print("######## There is some error occurring......... ########")
    

def specific():               #5 (B)details of particular room
    try:
        a=int(input('\nEnter the room no. whose details you want to see:'))
        cursor.execute("select * from hotel where room_no='{}'".format(a))
        data=cursor.fetchall()
        print('ROOM\'S DETAILS-')
        print('='*55)
        for row in data:
            print('CUSTOMER\'S NAME. : ',row[2])
            print('CUSTOMER\'S PHONE NO : ',row[3])
            print('CUSTOMER\'S ADDRESS : ',row[4])
            print('CUSTOMER\'S CHECK IN DATE : ',row[5])
            print('CUSTOMER\'S CHECK OUT DATE : ',row[6])
            print('CUSTOMER\'S EMAIL : ',row[7])
            print('CUSTOMER\'S ROOM TYPE : ',row[9])
            print('CUSTOMER\'S BILL : ',row[8])
            print()
            print('='*55)
    except:
        print("######## There is some error occurring......... ########")
        




def booked():           #6 number of booked rooms
    try:
        cursor.execute("select distinct(room_no) from hotel where check_out_date is null;")
        data=cursor.fetchall()
        print('Room No. that are booked-')
        print('='*140)
        print(data)
        print('='*140)

    except:
        print("######## There is some error occurring......... ########")




    

def bill():             #7 bill of customer
    try:
        ro=int(input('\nEnter Customer\'s Room No.: '))
        na=str(input('Enter Customer\'s full Name: '))
        dt=str(input('Enter Check Out Date: '))
        d=int(input('Enter the number of nights customer stayed in the hotel:'))
        
        
        cn="select * from hotel where room_no='%s' and name='%s';"
        cursor.execute(cn%(ro,na))
        data=cursor.fetchone()
        t=data[9]
        ty=0
        rt=''
        if t==1:
            ty=8000.00
            rt='Master Suite (Double Room)'
        elif t==2:
            ty=7000.00
            rt='Master Suite (Single Room)'
        elif t==3:
            ty=6000.00
            rt='Mini Suite (Double Room)'
        elif t==4:
            ty=5000.00
            rt='Mini Suite(Single Room)'
        elif t==5:
            ty=4000.00
            rt='Studio (Double Room)'
        elif t==6:
            ty=3000.00
            rt='Studio (Single Room)'
        
        bill=d*ty
        print("\n\n-------------------------  \"  THANKS FOR VISITING  \"-------------------------")
        print(' \n********************** HOTEL BILL ******************************')
        print('CUSTOMER\'S ID : ',data[0])
        print('CUSTOMER\'S ROOM NO. : ',data[1])
        print('CUSTOMER\'S NAME : ',data[2])
        print('CUSTOMER\'S ADDRESS : ',data[4])
        print('CUSTOMER\'S CHECK IN DATE : ',data[6])
        print('CUSTOMER\'S CHECK OUT DATE : ',dt)
        print('\nCUSTOMER\'S ROOM TYPE : ',rt)
        print('\nCUSTOMER\'S TOTAL BILL : ',bill)
        print("\n-------------------------  \"  VISIT AGAIN  \"-------------------------")

        cn="update hotel set bill='%s',check_out_date='%s' where room_no='%s' and name='%s'"
        cursor.execute(cn%(bill,dt,ro,na))
        con.commit()

            
        
    except Exception:
        print("######## There is some error occurring......... ########")


    
    


def main():
    
    while True :
        print('\n \n')
        print('~~~~~~~~~~~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~~~~~~~~~~~~~ '.center(140))
        print('1. Book a Rooom'.center(140))
        print('2. Update Customer\'s details'.center(140))
        print('3. Delete Customer\'s details'.center(140))          # PRINTING RECORD NOT FOUND
        print('4. Show records of All Customers sort by'.center(140))
        print('         A. Customer\'s ID'.center(140))
        print('B. Room'.center(140))
        print('5. Show record of a particular -'.center(140))
        print('     A. Customer'.center(140))           # PRINTING RECORD NOT FOUND
        print('  B. Room'.center(140))
        print('6. Show Room No. of currently Booked Rooms'.center(140))
        print('7. TOTAL BILL'.center(140))# check out
        print('8. Quit'.center(140))
        print('='*160)
        a=int(input('\nEnter your choice : '))
        if a==1:
            entry()
        elif a==2:
            modify()
        elif a==3:
            delete()
        elif a==4:
            op=str(input('4.Show records of All Customers sort by -\n    A.Customer\'s ID\n    B.Room\nSelect option (A/B)----->'))
            if op=='A' or op=='a':
                read()
            elif op=='B' or op=='b':
                read1()
            else:
                print('######## INVALID CHOICE TRY AGAIN ########')
            
        elif a==5:
            op=str(input('5.Show record of a particular -\n    A.Customer\n    B.Room\nSelect option (A/B)----->'))
            if op=='A' or op=='a':
                display()
            elif op=='B' or op=='b':
                specific()
            else:
                print('######## INVALID CHOICE TRY AGAIN ########')
        elif a==6:
            booked()
        elif a==7:
            bill()
        elif a==8:
            break
        else:
            print('##### INVALID CHOICE TRY AGAIN #####')
            main()

try:
    cursor.execute('select * from hotel;')
    data=cursor.fetchall()
except:
    cursor.execute('CREATE TABLE HOTEL(CUSTOMER_ID INTEGER NOT NULL PRIMARY KEY,ROOM_NO INTEGER NOT NULL,NAME VARCHAR(30) NOT NULL,PHONE_NO VARCHAR(10),ADDRESS VARCHAR(50),AADHAR CHAR(12) NOT NULL,CHECK_IN_DATE DATE,CHECK_OUT_DATE DATE,BILL DECIMAL,ROOM_TYPE INTEGER);')
    entry()
    
main()


