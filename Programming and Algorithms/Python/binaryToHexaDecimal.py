# Binary to Hexadecimal Converter
# This program lets you convert a binary number to a hexadecimal number
# Created by Amey Karan

binNum = str(input("Enter the binary number: "))
if len(binNum) % 4 == 1:
    binNum = "000" + binNum
elif len(binNum) % 4 == 2:
    binNum = "00" + binNum
elif len(binNum) % 4 == 3:
    binNum = "0" + binNum

result = ""
for i in range(0, len(binNum), 4):
    bit = binNum[i:i + 4]

    if bit == "0000":
        result += "0"
    if bit == "0001":
        result += "1"
    if bit == "0010":
        result += "2"
    if bit == "0011":
        result += "3"
    if bit == "0100":
        result += "4"
    if bit == "0101":
        result += "5"
    if bit == "0110":
        result += "6"
    if bit == "0111":
        result += "7"
    if bit == "1000":
        result += "8"
    if bit == "1001":
        result += "9"
    if bit == "1010":
        result += "A"
    if bit == "1011":
        result += "B"
    if bit == "1100":
        result += "C"
    if bit == "1101":
        result += "D"
    if bit == "1110":
        result += "E"
    if bit == "1111":
        result += "F"

print(f"The hexadecimal number for 0b{binNum.lstrip("0")} is 0x{result.lstrip("0")}")
