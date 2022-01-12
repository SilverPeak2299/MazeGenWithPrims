package Maze;

public class Client {
    public static void main(String[] args) {
        mazeGenerator Maze = new mazeGenerator();
        Maze.generateMaze();
        Maze.printMaze();
    }
}
