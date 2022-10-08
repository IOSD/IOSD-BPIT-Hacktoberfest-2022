
# Function to check array is monotonic
def check(arr):
	N = len(arr)
	inc = True
	dec = True
		for i in range(0, N-1):
	
		if arr[i] > arr[i+1]:
			inc = False

	for i in range(0, N-1):

		if arr[i] < arr[i+1]:
			dec = False

	return inc or dec

if __name__ == "__main__":
	arr = [1, 2, 3, 3]

	ans = check(arr)
	if ans == True:
		print("The input list is monotonic")
	else:
		print("The input list is not monotonic")

