# Image to ASCII Converter #

The scripts converts images into ascii art in couple dozen lines of code. You might want to preprocess the image in a program like Paint, GIMP or Photoshop to reduce the image size to run the ascii program faster. In addition, you also want to stretch the image horizontally a quarter of the image size because ascii symbols don't have the same width, your ascii art will look skinny if you don't stretch it. You can view the ascii art by opening your txt file in a web browser like Internet Explorer and zooming out. Have fun!

There's a python script and a Java program. You need OpenCV to run the program, and the python program runs by 'python image2ascii.py image.png' The Java program needs an image path specified in the code and it'll search for that image and load it.
