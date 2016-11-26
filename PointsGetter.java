/**
 * Created by Sofia228 on 20.11.16.
 */

public class PointsGetter {
    
    private double DELTA = 1;
    private double curN = 0;
    private double curSin = 0;
    private double nextX = 0;
    private double nextY = 0;
    
    PointsGetter() {
        
    }
    
    PointsGetter(double DELTA, double curN, double curSin, double nextX, double nextY) {
        this.DELTA = DELTA;
        this.curN = curN;
        this.curSin = curSin;
        this.nextX = nextX;
        this.nextY = nextY;
    }
    
    double getDELTA() {
        return DELTA;
    }
    
    double getNextX() {
        return nextX;
    }
    
    double getNextY() {
        return nextY;
    }
    
    private void getNextSin(double nextN) {
        curSin = curSin * curN / nextN;
        curN = nextN;
    }
    
    void getNextPoint(double nextN) {
        getNextSin(nextN);
        nextX += Math.tan(Math.asin(curSin)) / DELTA;
        nextY += DELTA;
    }
    
}
