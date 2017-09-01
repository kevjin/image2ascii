package com.company;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //load OPENCV LIBRARY
        Mat img = Imgcodecs.imread("image.jpg");
        Size sizeImg = img.size();
        String[] table = {" ", ".", ",", ":", "-", "=", "+", "*", "#", "%", "@"};
        String[] ascii = new String[(int)(sizeImg.width)]; //image array
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY); // CONVERT TO GRAY SCALLLLE
        for(int y=0; y<sizeImg.height; y++) {
            for(int x=0; x<sizeImg.width; x++) {
                double[] data = img.get(y, x); //data has to be stored in double[] type
                ascii[x] = table[(int)(10 - data[0]/24)];
            }
            try (PrintWriter out = new PrintWriter(new FileWriter("asciiArtJAVA.txt", true))){ //overwrites the file
                for(int b = 0; b<sizeImg.width; b++) out.print(ascii[b]);
                out.println();
            } catch(Exception e){
                System.out.println("Your program screwed up, Kevin." + e);
            }
        }
        System.out.print("Complete");
    }
}
