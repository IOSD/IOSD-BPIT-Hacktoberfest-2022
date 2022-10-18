
import cv2
import numpy as np
img1 = cv2.imread('butterfly.png')


img = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
img_blur = cv2.GaussianBlur(img,(5,5),0)
#ar = np.array(img_blur)
y,x = img_blur.shape
print(y)
print(x)
print(img_blur)
new = np.zeros_like(img_blur, dtype = np.uint32)
for j in range(x):
    for i in range(y):
        new[i,j] = img_blur[0:i,0:j].sum()
print(new)

s = 3
final = []

for j in range(x):
    for i in range(y):
        y0 = max(i - s, 0)
        y1 = min(i+s, y -1)
        x0 = max(j - s, 0)
        x1 = min(j + s, x-1)

        ct = (y1 - y0)*(x1-x0)

        su = new[y1, x1]-new[y0, x1]-new[y1, x0]+new[y0, x0]

        if new[j, i]*ct< su*(100-20)/100.:
            final[j,i] = 0
        else:
            final[j,i] = 255

plt.imshow(final)
plt.show()
                    

'''
def integral(x,y,arr):
    if (x == 0 and y == 0):
        return (arr[x][y])
    elif(x == 0):
        return(arr[x][y] + integral(x,y,arr) + integral(x,y-1,arr))
    elif(y == 0):
        return (arr[x][y] + integral(x-1,y,arr) + integral(x,y,arr))
    else:
        i = arr[x][y]
        return (i + integral(x-1,y,arr) + integral(x,y-1,arr) + integral(x-1,y-1,arr))

for i in range(m):
    for j in range(n):
        new[i][j] = integral(i,j,ar)
print(new)



thresh1 = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 199, 5)

thresh2 = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 199, 5)

cv2.imshow('Adaptive Mean', thresh1)
cv2.imshow('Adaptive Gaussian', thresh2)



'''
