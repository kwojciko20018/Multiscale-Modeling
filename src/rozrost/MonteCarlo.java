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
    private boolean edgeGenerated;
    private ArrayList<Integer> grainsToSkip = new ArrayList();

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
        boardGrain = new Grain[size_x][size_y];
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
                if(boardGrain[rand_x][rand_y].getId() == 0)
                    while(grainsToSkip.contains(i+1))
                    boardGrain[rand_x][rand_y].setId(i + 1);
                tmp.remove(rand_id);
            }

        } else {
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    if(boardGrain[i][j].getId() == 0)
                    {
                        int tmpId = rand.nextInt(n) * 7 + 1;
                        while(grainsToSkip.contains(tmpId))
                            tmpId = rand.nextInt(n) * 7 + 2;
                        boardGrain[i][j].setId(tmpId);
                    }
                }
            }
        }

        return boardGrain;
    }
    
    public Grain[][] removeAllGrainsExceptSeleected(ArrayList<Integer> selectedGrains)
    {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if(!selectedGrains.contains(boardGrain[i][j].getId()))
                {
                    boardGrain[i][j].setId(0);
            }}
        }
        return boardGrain;
    }
    
    Grain[][] dualPhaseIdChange() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                 if (boardGrain[i][j].getId() != 0)
                     boardGrain[i][j].setId(-2);
            }
        }
        return boardGrain;
    }
    
    boolean isHaveBoundariesInNaiberhood(int x, int y)
    {
        for (int i = x-1; i <= x+1 && i>0 && i< size_x; i++) {
            for (int j = y-1; j <= y+1 && j>0 && j< size_y; j++) {
                if(boardGrain[i][j].isB()) return true;
            }
        }
        return false;
    }
    
        public Grain[][] edge() {
        for (int i = 1; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i - 1][j].getId() && !boardGrain[i][j].isB()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }
        for (int i = 0; i < size_x; i++) {
            for (int j = 1; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i][j - 1].getId() && !boardGrain[i][j].isB()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }
        edgeGenerated = true;
        return boardGrain;
    }

    
    Grain[][] growBoundaries( int size , ArrayList<Integer> selectedGrainList)
    {
        boardGrain = edge();
        ArrayList<Grain> grainToSet = new ArrayList<Grain>();
        
        if(selectedGrainList.isEmpty())
        {
            for (int k = size -1; k > 0; k--)
            {
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    if (isHaveBoundariesInNaiberhood(i,j))
                    {
                        grainToSet.add(boardGrain[i][j]);
                    }
                }
            }
            for(Grain grain : grainToSet)
            {
                grain.setB(true);
                grain.setId(0);
            }
            
        }
        drawBoundaries();
        }
        else
        {
            for (int k = size -1; k > 0; k--)
            {
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    if (isHaveBoundariesInNaiberhood(i,j) && selectedGrainList.contains(boardGrain[i][j].getId()))
                    {
                        grainToSet.add(boardGrain[i][j]);
                    }
                }
            }
            clearEdgedifferentThan(selectedGrainList);
            for(Grain grain : grainToSet)
            {
                grain.setB(true);
            }
        }
        }
        drawBoundaries();
        return boardGrain;
    }
    
    void drawBoundaries()
    {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if(boardGrain[i][j].isB()) boardGrain[i][j].setId(0);
            }
        }
    }
    
    void clearEdgedifferentThan(ArrayList<Integer> selectedGrainList)
    {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if(boardGrain[i][j].isB() && !selectedGrainList.contains(boardGrain[i][j].getId()))
                    boardGrain[i][j].setB(false);
            }
        }
    }

    public Grain[][] calculate(float grainBoundaryEnergy) {
        changed = 0;
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if(boardGrain[i][j].getId() > 0 && !grainsToSkip.contains(boardGrain[i][j].getId()) )
                    grains.add(new BoardPoint(i, j, 0, boardGrain[i][j].getId()));
            }
        }
        
        int numberOfGrains = grains.size();
        int id = 0;
        int randGrain = 0;
        int[][] tab_tmp = new int[3][3];
        int[][] tab = new int[3][3];
        int randomArea = 0;
        float power = 0;

        while (id < numberOfGrains) {
            randGrain = rand.nextInt(grains.size());
            tab = createArea(grains.get(randGrain).getX(), grains.get(randGrain).getY());
            power = power(tab, grainBoundaryEnergy);

            if (power > 0) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tab_tmp[i][j] = tab[i][j];
                    }
                }

                randomArea = getRandomNeighbor(tab, tab[1][1]);
                
                tab_tmp[1][1] = randomArea;

                float power_tmp = power(tab_tmp, grainBoundaryEnergy);

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

    private float power(int[][] tab, float grainBoundaryEnergy) {
        int power = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] != tab[1][1]) {
                    power++;
                }
            }
        }

        return power * grainBoundaryEnergy;
    }

    private int getRandomNeighbor(int[][] tab, int self) {
        // int id = rand.nextInt(8);
        //id = id > 3 ? id + 1 : id;
        //return tab[id / 3][id % 3];

        ArrayList<BoardPoint> tmp = new ArrayList<BoardPoint>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(tab[i][j] == 0 || (i == 1 && j == 1)) ) {
                     if(tab[i][j] == -2) continue;
                     if(grainsToSkip.contains(tab[i][j])) continue;
                    tmp.add(new BoardPoint(i, j, 0, tab[i][j]));
                }
            }
        }
        if(tmp.size() == 0) return -3;
        return tmp.get(rand.nextInt(tmp.size())).getId();
    }

    void setSeedsCount(int n) {
        this.n = n;
    }
    
    void setBoard(Grain boardGrain[][])
    {
        this.boardGrain = boardGrain;
    }
    
    Grain[][] getBoard()
    {
        return this.boardGrain;
    }
    
    ArrayList<Integer> getGrainsToSkip()
    {
        return this.grainsToSkip;
    }
    
    void setGrainsToSkip(ArrayList<Integer> selectedGrainList) 
    {
        grainsToSkip = selectedGrainList;
        return;
    }

}
