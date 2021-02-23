import java.util.Arrays;

public class Board {

    boolean[][] world;

    public Board(boolean[][] initialState) {
        this.world = initialState;
    }

    public boolean hasLivingCells() {
        for (boolean[] rows : world) {
            for (boolean cell : rows) {
                if (cell) {
                    return true;
                }
            }
        }
        return false;
    }

    public Board evolveBoard() {
        boolean [][] newWorld = createNewWorld();
        for (int x = 0; x < getWorldWidth(); x++) {
            evolveToNewWorld(newWorld, x);
        }
        return new Board(newWorld);
    }

    private void evolveToNewWorld(boolean[][] newWorld, int x) {
        for (int y = 0; y < getWorldHeight(); y++) {
            newWorld[x][y] = evolveCell(x,y);
        }
    }

    private boolean[][] createNewWorld() {
        return new boolean[getWorldWidth()][getWorldHeight()];
    }

    public boolean evolveCell(int x, int y) {
        int livingNeighbours = getLivingNeighbours(x, y);

        if (lessThanTwoNeighbours(livingNeighbours))
            return false;
        if (moreThanThreeNeighbours(livingNeighbours))
            return false;
        return true;
    }

    private boolean moreThanThreeNeighbours(int livingNeighbours) {
        return livingNeighbours > 3;
    }

    private boolean lessThanTwoNeighbours(int livingNeighbours) {
        return livingNeighbours < 2;
    }

    private int getLivingNeighbours(int x, int y) {
        int livingCellsAround = countLivingCellsAround(x, y);

        return (isAlive(x,y))
                ? livingCellsAround-1
                : livingCellsAround;
    }

    private int countLivingCellsAround(int x, int y) {
        int livingCellsInArea = 0;
        for (int row : getAdjacent(x)) {
            livingCellsInArea += countNeighboursOverColumns(y, row);
        }
        return livingCellsInArea;
    }

    private int countNeighboursOverColumns(int column, int row) {
        int livingCells = 0;
        for (int col : getAdjacent(column)) {
            livingCells += countLiving(row, col);
        }
        return livingCells;
    }

    private int countLiving(int row, int col) {
        if (isAlive(row, col)) {
            return 1;
        }
        return 0;
    }

    private boolean isAlive(int row, int col) {
        if (isRowInsideTheMap(row) && isColumnInsideTheMap(col)) {
            return world[row][col];
        }
        return false;
    }

    private boolean isRowInsideTheMap(int row) {
        return isInsideTheWorld(row, getWorldWidth());
    }

    private boolean isColumnInsideTheMap(int col) {
        return isInsideTheWorld(col, getWorldHeight());
    }

    private boolean isInsideTheWorld(int row, int i) {
        return row >= 0 && row < i;
    }

    private int[] getAdjacent(int position) {
        return new int[]{position - 1, position, position + 1};
    }

    private int getWorldWidth() {
        return world.length;
    }

    private int getWorldHeight() {
        if(world.length > 0){
            return world[0].length;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Arrays.deepEquals(world, ((Board) o).world);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(world);
    }
}