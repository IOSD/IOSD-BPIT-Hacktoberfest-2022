# Number of Rows
row = int(input("Enter number of rows required to generate hourglass pattern:\n"))

# Upper-Half
for i in range(row, 0, -1):
    for j in range(row-i):
        print(" ", end="")
    for j in range(1, 2*i):
        print(i, end="")
    print()

# Lower-Half
for i in range(2, row+1):
    for j in range(row-i):
        print(" ", end="")
    for j in range(1, 2*i):
        print(i, end="")
    print()
