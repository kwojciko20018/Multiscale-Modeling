package rozrost;

import java.util.ArrayList;
import java.util.Random;

public class WorkerThread extends Thread {

    private int thread_pool;
    private int size_x;
    private int size_y;
    private Grain boardGrain[][];
    private int board_tmp[][];
    private int id;
    private Random rand = new Random();
    private boolean perio;
    private int areaSetup;
    private int r;

    public WorkerThread(int thread_pool, int size_x, int size_y, Grain[][] boardGrain, int id, boolean perio, int areaSetup, int r) {
        this.thread_pool = thread_pool;
        this.size_x = size_x;
        this.size_y = size_y;
        this.boardGrain = boardGrain;
        this.id = id;
        this.perio = perio;
        this.areaSetup = areaSetup;
        this.r = r;
        boardGrain = new Grain[size_x][size_y];
        board_tmp = new int[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }
    }

    @Override
    public void run() {
        calculate();
    }

    private void calculate() {
        int tmp[][] = new int[3][3];
        int pocz = (size_x / thread_pool) * id;
        int kon = (size_x / thread_pool) * (id + 1);

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                board_tmp[i][j] = boardGrain[i][j].getId();
            }
        }

        for (int i = pocz; i < kon; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() == 0) {

                    if (areaSetup == 7) {
                        board_tmp[i][j] = randomArea(i, j, r);
                    } else {
                        tmp = createArea(i, j, areaSetup, false);
                        board_tmp[i][j] = area(tmp);
                    }
                }
            }
        }
    }

    private int randomArea(int x, int y, int r) {
        int tmp[][];
        tmp = new int[2 * r + 1][2 * r + 1];

        for (int i = 0; i < 2 * r + 1; i++) {
            for (int j = 0; j < 2 * r + 1; j++) {
                float r_tmp = (float) (Math.sqrt(Math.pow(r - i, 2) + Math.pow(r - j, 2)));
                if (r < r_tmp) {
                    tmp[i][j] = 0;
                } else {
                    int xl = (x - r + i) % size_x;
                    xl = xl < 0 ? size_x - 1 : xl;

                    int yl = (y - r + j) % size_y;
                    yl = yl < 0 ? size_y - 1 : yl;

                    if (perio) {
                        tmp[i][j] = boardGrain[xl][yl].getId();
                    } else {
                        if ((x - r + i) >= 0 && (x - r + i) < size_x && (y - r + j) >= 0 && (y - r + j) < size_y) {
                            tmp[i][j] = boardGrain[xl][yl].getId();
                        } else {
                            tmp[i][j] = 0;
                        }
                    }

                }
            }
        }

        ArrayList<BoardPoint> areas = new ArrayList<BoardPoint>();
        ArrayList<BoardPoint> maxAreas = new ArrayList<BoardPoint>();
        int max = 0;
        boolean find = false;

        for (int i = 0; i < 2 * r + 1; i++) {
            for (int j = 0; j < 2 * r + 1; j++) {
                if (tmp[i][j] != 0) {

                    find = false;
                    for (int l = 0; l < areas.size(); l++) {
                        if (tmp[i][j] == areas.get(l).getId()) {
                            areas.get(l).valueUp();
                            find = true;
                            max = max < areas.get(l).getValue() ? areas.get(l).getValue() : max;
                            break;
                        }
                    }

                    if (!find) {
                        areas.add(new BoardPoint(i, j, 1, tmp[i][j]));
                        max = max < 1 ? 1 : max;
                    }
                }
            }
        }

        if (max == 0) {
            return 0;
        } else {
            for (int l = 0; l < areas.size(); l++) {
                if (max == areas.get(l).getValue()) {
                    maxAreas.add(areas.get(l));
                }
            }
            return maxAreas.get(new Random().nextInt(maxAreas.size())).getId();
        }

    }

    private int area(int[][] tab) {
        int areas[][] = new int[3][3];
        ArrayList<BoardPoint> max_l = new ArrayList<BoardPoint>();
        int max_x = 0;
        int max_y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (tab[k][l] != 0) {
                            if (tab[i][j] == tab[k][l]) {
                                areas[i][j]++;
                            }
                        }
                    }
                }

                if (areas[i][j] > areas[max_x][max_y]) {
                    max_x = i;
                    max_y = j;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (areas[i][j] == areas[max_x][max_y]) {
                    max_l.add(new BoardPoint(i, j, areas[i][j]));
                }
            }
        }
        int max = rand.nextInt(max_l.size());

        return tab[max_l.get(max).getX()][max_l.get(max).getY()];
    }

    private int[][] createArea(int i, int j, int areaSetup, boolean recrystal) {
        int tmp[][] = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int l_x = (size_x + (i - 1 + k)) % size_x;
                int l_y = (size_y + (j - 1 + l)) % size_y;
                if (recrystal) {
                    if (boardGrain[l_x][l_y].isR()) {
                        tmp[k][l] = boardGrain[l_x][l_y].getId();
                    } else {
                        tmp[k][l] = 0;
                    }
                } else {
                    tmp[k][l] = boardGrain[l_x][l_y].getId();
                }
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

        int tmp_area = areaSetup;
        boolean _rand = true;
        while (_rand) {
            switch (tmp_area) {
                case 0: //moor
                {
                    _rand = false;
                    break;
                }
                case 1: //neumann
                {
                    tmp[0][0] = 0;
                    tmp[2][0] = 0;
                    tmp[0][2] = 0;
                    tmp[2][2] = 0;
                    _rand = false;
                    break;
                }
                case 2: //hex L
                {
                    tmp[0][2] = 0;
                    tmp[2][0] = 0;
                    _rand = false;
                    break;
                }
                case 3: //hex P
                {
                    tmp[0][0] = 0;
                    tmp[2][2] = 0;
                    _rand = false;
                    break;
                }
                case 4: //hex R
                {
                    if (rand.nextBoolean()) {
                        tmp[0][2] = 0;
                        tmp[2][0] = 0;
                    } else {
                        tmp[0][0] = 0;
                        tmp[2][2] = 0;
                    }
                    _rand = false;
                    break;
                }
                case 5: //pen L
                {
                    int randPent = rand.nextInt(4);
                    if (randPent == 0) {
                        for (int k = 0; k < 3; k++) {
                            tmp[0][k] = 0;
                        }
                    } else if (randPent == 1) {
                        for (int k = 0; k < 3; k++) {
                            tmp[k][0] = 0;
                        }
                    } else if (randPent == 2) {
                        for (int k = 0; k < 3; k++) {
                            tmp[2][k] = 0;
                        }
                    } else {
                        for (int k = 0; k < 3; k++) {
                            tmp[k][2] = 0;
                        }
                    }
                    _rand = false;
                    break;
                }
                case 6: //rand
                {
                    tmp_area = rand.nextInt(5);
                    break;
                }
                default:
                    _rand = false;
                    break;
            }
        }

        return tmp;
    }

    public int[][] getBoard_tmp() {
        return board_tmp;
    }

}
