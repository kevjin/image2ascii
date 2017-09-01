import sys
from PIL import Image
import numpy as np
import cv2

symbols = [' ', '.', ',', ':', '-', '=', '+', '*', '#', '%', '@'] #from lowest to highest density symbols
step = 256/11

if len(sys.argv) != 2: print("Specify the image which you want the ascii art of, by doing python image2ascii.py <image.png>")
f = sys.argv[1]

img = cv2.imread(f,0) #read image in grayscale

#create matrix
w, h = img.shape[0], img.shape[1]
ascis = [[" " for x in range(w)] for y in range(h)] 

for x in range(0,img.shape[0]):
	for y in range(0,img.shape[1]):
		ascis[y][x] = symbols[-1*((img[x,y]/step))]

line = ''
print "Almost done!"
with open("asciiArt.txt",'w') as f:
	for x in range(0,img.shape[0]):
		for y in reversed(range(0,img.shape[1])):
			line = ascis[y][x] + line
		f.write(line + '\n')
		line = ""
print "Done!!"