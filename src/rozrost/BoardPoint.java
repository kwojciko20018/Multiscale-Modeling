package rozrost;

public class BoardPoint {
    private int x;
    private int y;
    private int id;
    private int value;

    public BoardPoint(){
        this.x = 0;
        this.y = 0;
        this.value = 0;
    }
    
    public BoardPoint(int x, int y, int value, int id){
        this.x = x;
        this.y = y;
        this.value = value;
        this.id = id;
    }
    
    public BoardPoint(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getId(){
        return id;
    }
    
    public void valueUp(){
        value++;
    }
    
    public boolean point2point(int x, int y,int r){
        return Math.sqrt(Math.pow(this.x - x,2)+Math.pow(this.x - x,2))>r ;
    }
    
    
}
