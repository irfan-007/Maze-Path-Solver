package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    public static void main(String[] args) {
        Main mn = new Main();
    }
    public Main(){
        setTitle("Maze Path Solver");
        setSize(630,520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Dfs.dfs(maze,path,1,1);
        System.out.println(path);
    }
    private int[][] maze={
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public ArrayList<Integer> path=new ArrayList();

    @Override public void paint(Graphics g){
        g.translate(120,120);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color clr = Color.white;
                switch (maze[i][j]){
                    case 0:clr=Color.WHITE;break;
                    case 1:clr=new Color(128,128,128);break;
                    case 9:clr=new Color(102,178,255);break;
                }
                g.setColor(clr);
                g.fillRect(j*30,i*30,30,30);
                g.setColor(Color.black);
                g.drawRect(j*30,i*30,30,30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int xx=path.get(i);
            int yy=path.get(i+1);
            g.setColor(new Color(204,255,153));
            g.fillRect(yy*30,xx*30,30,30);
            g.setColor(Color.black);
            g.drawRect(yy*30,xx*30,30,30);
        }
    }
}