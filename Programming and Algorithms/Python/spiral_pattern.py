def pattern(value):
	
	row = 2 * value - 1
	column = 2 * value - 1
	arr = [[0 for i in range(row)]
			for j in range (column)]

	for k in range( value):

		j = k
		while (j < column - k):
			arr[k][j] = value - k
			j += 1

		i = k + 1
		while (i < row - k):
			arr[i][row - 1 - k] = value - k
			i += 1

		j = column - k - 2
		while j >= k :
			arr[column - k - 1][j] = value - k
			j -= 1

		i = row - k - 2
		while i > k :
			arr[i][k] = value - k
			i -= 1

	for i in range(row):
		for j in range(column):
			print(arr[i][j], end = " ")
		print()
	
if __name__ == "__main__":
	n = 5
	pattern(n)

