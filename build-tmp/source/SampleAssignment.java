import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SampleAssignment extends PApplet {

int x;
int y;
int w;
int h;
int playerVal = -1; //the value of the current player--can only be -1 or 1, 0 represents an empty spot
int[] colors = new int[9]; //stores the color of each square on the board
int[] playerColors = new int[6]; //stores the value of 2 moused over (light) colors and 2 confirmed (dark) colors and 2 fill colors
int[] board = new int[9]; //stores board data

public void setup() {
  size(600,600);
  background(136, 225, 247);
  playerColors[0] = color(255,0,0);  //moused over color for playerVal -1
  playerColors[1] = color(254,0,0);  //fill color for playerVal -1
  playerColors[2] = color(200,0,0);  //pressed color for playerVal -1
  playerColors[3] = color(0,0,255);  //moused over color for playerVal 1
  playerColors[4] = color(0,0,254);  //fill color for playerVal 1
  playerColors[5] = color(0,0,155);  //pressed color for playerVal 1
  //made a fill color so that when mouse if over a square that is already colored it wont fill it. when i did it with if color=background it would flash
  for(int i=0; i<colors.length; i ++) {
    colors[i] = color(255,255,255);
  }
}

public void draw() {
  
  x = -1; //numbers are wacky bc i wanted to make it look like 4 lines with 9 rects, so i made the nums like this
  y = -1;
  w = 201;
  h = 201;

  for(int j=0; j<9; j++) {
    rect(x,y,w,h);
    if (mouseX>x && mouseX <x+h && mouseY>y && mouseY<y+h && get(mouseX,mouseY) != playerColors[1] && get(mouseX,mouseY) != playerColors[4]) { 
      if (playerVal == -1) {
        fill(playerColors[0]); //preview color
        if (mousePressed) {
          fill(playerColors[2]); //pressed color
          colors[j] = playerColors[1]; //fill color
          board[j] = playerVal;
          playerVal = 1;
        }
      } else if (playerVal == 1) {
        fill(playerColors[3]); //preview color
        if (mousePressed) {
          fill(playerColors[5]); //pressed color
          colors[j] = playerColors[4]; //fill color
          board[j] = playerVal;
          playerVal = -1;
        }
      }
    } else {
      fill(colors[j]);
    }
    
    
    x += w;
    if (x > ((w-3)*3)) {
      y += h;
      x = -1;
    }

  }
}

// void cat(int x, int y) {
//   translate(x, y);
//   fill(8, 159, 228);
//   stroke(8, 159, 228);
//   bezier(157,95,164,89,236,89,244,97);//head
//   bezier(244,97,243,82,252,38,275,56);
//   bezier(275,56,297,73,369,221,298,304);
//   bezier(298,304,265,343,170,376,101,303);
//   bezier(101,303,32,226,101,78,123,57);
//   bezier(123,57,146,37,154,80,157,95);

//   beginShape();
//   vertex(157, 95);
//   vertex(244, 97);
//   vertex(275, 63);
//   vertex(295, 304);
//   vertex(104, 303);
//   vertex(123, 63);
//   endShape(CLOSE);
  
//   stroke(0, 0, 0);
//   strokeWeight(10);
//   bezier(116,212,118,250,163,246,162,212);//eye
//   bezier(233,212,232,246,276,253,279,212);

//   strokeWeight(1);
//   fill(247, 200, 200);
//   stroke(247, 200, 200);
//   bezier(186,263,192,258,212,258,215,264);//nose
//   bezier(215,264,218,270,209,283,201,283);
//   bezier(201,283,192,283,180,270,186,263);
//   triangle(186,263,215,264,201,283);
  
  
//   strokeWeight(10);
//   stroke(8,159,228);
//   line(77,259,47,251);//left
//   line(89,285,48,296);
  
//   line(322,261,353,251);//right
//   line(311,285,353,296);
//   }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SampleAssignment" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
