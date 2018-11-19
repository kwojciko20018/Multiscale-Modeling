package rozrost;

import java.util.ArrayList;
import java.util.Random;

public class MonteCarlo {

    private final int size_x;
    private final int size_y;
    private Grain boardGrain[][];
    private int n;
    private Random rand;
    private boolean perio;
    ArrayList<BoardPoint> grains;
    private int changed;

    public MonteCarlo(int size_x, int size_y, Grain[][] boardGrain) {
        this.boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                this.boardGrain[i][j] = new Grain();
            }
        }
        this.size_x = size_x;
        this.size_y = size_y;
        this.boardGrain = boardGrain;
        rand = new Random();
        grains = new ArrayList<BoardPoint>();
    }

    public void changePerio() {
        this.perio = !perio;
    }

    public int getChanged() {
        return changed;
    }

    public MonteCarlo(int size_x, int size_y, int n) {
        grains = new ArrayList<BoardPoint>();
        perio = false;
        rand = new Random();
        this.size_x = size_x;
        this.size_y = size_y;
        this.n = n;
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }
    }

    public MonteCarlo() {
        grains = new ArrayList<BoardPoint>();
        perio = false;
        rand = new Random();
        this.size_x = 500;
        this.size_y = 300;
        this.n = 50;
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }

    }

    public Grain[][] randomBoard() {
        if (n == 0) {

            ArrayList<BoardPoint> tmp = new ArrayList<BoardPoint>();
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    tmp.add(new BoardPoint(i, j, 0, 0));
                }
            }

            for (int i = 0; i < size_x * size_y; i++) {
                int rand_id = rand.nextInt(tmp.size());
                int rand_x = tmp.get(rand_id).getX();
                int rand_y = tmp.get(rand_id).getY();;
                boardGrain[rand_x][rand_y].setId(i + 1);
                tmp.remove(rand_id);
            }

        } else {
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    boardGrain[i][j].setId(rand.nextInt(n) * 7 + 1);
                }
            }
        }

        return boardGrain;
    }

    public Grain[][] calculate() {
        changed = 0;
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                grains.add(new BoardPoint(i, j, 0, boardGrain[i][j].getId()));
            }
        }

        int id = 0;
        int randGrain = 0;
        int[][] tab_tmp = new int[3][3];
        int[][] tab = new int[3][3];
        int randomArea = 0;
        int power = 0;

        while (id < size_x * size_y) {
            randGrain = rand.nextInt(grains.size());
            tab = createArea(grains.get(randGrain).getX(), grains.get(randGrain).getY());
            power = power(tab);

            if (power > 0) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tab_tmp[i][j] = tab[i][j];
                    }
                }

                randomArea = getRandomNeighbor(tab);

                tab_tmp[1][1] = randomArea;

                int power_tmp = power(tab_tmp);

                if (power_tmp <= power) {
                    boardGrain[grains.get(randGrain).getX()][grains.get(randGrain).getY()].setId(randomArea);
                    changed++;
                }
            }
            grains.remove(randGrain);
            id++;
        }

        return boardGrain;
    }

    private int[][] createArea(int i, int j) {
        int tmp[][] = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int l_x = (size_x + (i - 1 + k)) % size_x;
                int l_y = (size_y + (j - 1 + l)) % size_y;
                tmp[k][l] = boardGrain[l_x][l_y].getId();
            }
        }

        if (!perio) {
            if (i == 0) {
                for (int k = 0; k < 3; k++) {
                    tmp[0][k] = 0;
                }
            }
            if (j == 0) {
                for (int k = 0; k < 3; k++) {
                    tmp[k][0] = 0;
                }
            }
            if (i == size_x - 1) {
                for (int k = 0; k < 3; k++) {
                    tmp[2][k] = 0;
                }
            }
            if (j == size_y - 1) {
                for (int k = 0; k < 3; k++) {
                    tmp[k][2] = 0;
                }
            }
        }

        return tmp;
    }

    private int power(int[][] tab) {
        int power = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] != tab[1][1]) {
                    power++;
                }
            }
        }

        return power;
    }

    private int getRandomNeighbor(int[][] tab) {
        // int id = rand.nextInt(8);
        //id = id > 3 ? id + 1 : id;
        //return tab[id / 3][id % 3];

        ArrayList<BoardPoint> tmp = new ArrayList<BoardPoint>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(tab[i][j] == 0 || (i == 1 && j == 1))) {
                    tmp.add(new BoardPoint(i, j, 0, tab[i][j]));
                }
            }
        }
        return tmp.get(rand.nextInt(tmp.size())).getId();
    }

}
