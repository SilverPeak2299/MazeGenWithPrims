package Maze;

import java.util.Random;

public class mazeGenerator {
    private int[][] map = new int[99][99];
    private PriorityQueue availableCells = new PriorityQueue();

    public void generateMaze() {
        Random r = new Random();
        mazeCell currentCell = new mazeCell(2 * r.nextInt(49) + 1, 2 * r.nextInt(49) + 1); // randomly picking the first cell
        map[currentCell.y][currentCell.x] = 0;
        findMoves(currentCell); // add all the bordering cells to a list
        
        while(availableCells.peek() != null) {
            currentCell = moveCell(currentCell); // pick one of the available cells, move it it and store it in current cell - updates the map tp reflect this
            findMoves(currentCell); // find all of the new moves
        }
    }

    private void findMoves(mazeCell cell) { // adding available cells to move to to the list
        Random r = new Random();

        if (cell.x - 2 > -1 && map[cell.y][cell.x - 2] == 1) { // checking of cell is available
            availableCells.push(new mazeCell(cell.x - 2, cell.y), r.nextInt(100)); // use of random to create variation in the Prioroty Queue
            map[cell.y][cell.x - 2] = 2; // marking cell so no duplicates in list
        }

        if (cell.x + 2 < 99 && map[cell.y][cell.x + 2] == 1) {
            availableCells.push(new mazeCell(cell.x + 2, cell.y), r.nextInt(100));
            map[cell.y][cell.x + 2] = 2;
        }

        if (cell.y - 2 > -1 && map[cell.y - 2][cell.x] == 1) {
            availableCells.push(new mazeCell(cell.x, cell.y - 2), r.nextInt(100));
            map[cell.y - 2][cell.x] = 2;
        }

        if (cell.y + 2 < 99 && map[cell.y + 2][cell.x] == 1) {
            availableCells.push(new mazeCell(cell.x, cell.y + 2), r.nextInt(100));
            map[cell.y + 2][cell.x] = 2;
        }
    }


    private mazeCell moveCell(mazeCell lastCell) {
        mazeCell nextCell = availableCells.pop().data; // remove the top item in the list
        map[nextCell.y][nextCell.x] = 0; // update the position
        
            Random r = new Random();
            switch (r.nextInt(4)) { // looking where the maze currently is to remove the wall between the new cell and another - use of random to add variation to the direction checked first
                case 3:
                    if (nextCell.x - 2 > -1 && map[nextCell.y][nextCell.x-2] == 0) {
                        map[nextCell.y][nextCell.x - 1] = 0;
        
                    } else if (nextCell.x+2 < 99 && map[nextCell.y][nextCell.x+2] == 0) {
                        map[nextCell.y][nextCell.x + 1] = 0;
        
                    } else if (nextCell.y - 2 > -1 && map[nextCell.y-2][nextCell.x] == 0) {
                        map[nextCell.y-1][nextCell.x] = 0;
        
                    } else {
                        map[nextCell.y+1][nextCell.x] = 0;
                    }
                    break;

                case 2:
                     if (nextCell.x+2 < 99 && map[nextCell.y][nextCell.x+2] == 0) {
                        map[nextCell.y][nextCell.x + 1] = 0;
        
                    } else if (nextCell.y - 2 > -1 && map[nextCell.y-2][nextCell.x] == 0) {
                        map[nextCell.y-1][nextCell.x] = 0;
        
                    } else if (nextCell.y + 2 < 99 && map[nextCell.y+2][nextCell.x] == 0) {
                        map[nextCell.y+1][nextCell.x] = 0;

                    } else if (nextCell.x - 2 > -1 && map[nextCell.y][nextCell.x-2] == 0) {
                        map[nextCell.y][nextCell.x - 1] = 0;
                    }
                    break;

                case 1:
                    if (nextCell.y - 2 > -1 && map[nextCell.y-2][nextCell.x] == 0) {
                        map[nextCell.y-1][nextCell.x] = 0;
    
                    } else if (nextCell.y + 2 < 99 && map[nextCell.y+2][nextCell.x] == 0) {
                        map[nextCell.y+1][nextCell.x] = 0;

                    } else if (nextCell.x - 2 > -1 && map[nextCell.y][nextCell.x-2] == 0) {
                        map[nextCell.y][nextCell.x - 1] = 0;
                        
                    } else if (nextCell.x+2 < 99 && map[nextCell.y][nextCell.x+2] == 0) {
                        map[nextCell.y][nextCell.x + 1] = 0;
                    }
                    break;

                case 0:
                    if (nextCell.y + 2 < 99 && map[nextCell.y+2][nextCell.x] == 0) {
                        map[nextCell.y+1][nextCell.x] = 0;

                    } else if (nextCell.x - 2 > -1 && map[nextCell.y][nextCell.x-2] == 0) {
                        map[nextCell.y][nextCell.x - 1] = 0;
                    
                    } else if (nextCell.x+2 < 99 && map[nextCell.y][nextCell.x+2] == 0) {
                        map[nextCell.y][nextCell.x + 1] = 0;

                    } else if (nextCell.y - 2 > -1 && map[nextCell.y-2][nextCell.x] == 0) {
                        map[nextCell.y-1][nextCell.x] = 0;
                    }
                    break;
            }

        return nextCell;
    }


    public void printMaze() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    mazeGenerator() {
        for (int i = 0; i < map.length; i++) { // initalizing the maze
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 1;
            }
        }
    }

}
