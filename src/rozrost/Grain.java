package rozrost;

public class Grain {

    private int id = 0;
    private double ro = 0;
    private boolean b = false;
    private boolean r = false;
    private int R;
    private int G;
    private int B;
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRo() {
        return ro;
    }

    public void setRo(double ro) {
        this.ro = ro;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
    
    public void addRo(double ro){
        this.ro +=ro;
    }
    
    public void setRGB(int R, int G, int B)
    {
      this.R = R;
      this.G = G;
      this.B = B;
    }
    
    public int getR() {
        return R;
    }
    
    public int getG() {
        return G;
    }
    
    public int getB() {
        return B;
    }
    
}
