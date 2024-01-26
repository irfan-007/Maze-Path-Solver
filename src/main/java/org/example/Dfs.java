package org.example;
import java.util.*;
public class Dfs {
    public static boolean dfs(int[][] maze,ArrayList<Integer> path,int x,int y){
        if(x>= maze.length || y>= maze[0].length || x<0 || y<0)
            return false;
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[x][y]==0){
            maze[x][y]=2; // visited
            if(dfs(maze,path,x,y-1)){
                path.add(x);
                path.add(y);
                return true;
            }
            if(dfs(maze,path,x,y+1)){
                path.add(x);
                path.add(y);
                return true;
            }
            if(dfs(maze,path,x-1,y)){
                path.add(x);
                path.add(y);
                return true;
            }
            if(dfs(maze,path,x+1,y)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
