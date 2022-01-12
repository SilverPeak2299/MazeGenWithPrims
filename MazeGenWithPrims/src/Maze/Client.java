package Maze;

public class Client {
    public static void main(String[] args) { // A maze generator that uses a modified version of Prims algorithim - 1 represents a wall
        mazeGenerator Maze = new mazeGenerator();
        Maze.generateMaze();
        Maze.printMaze();
    }
}
