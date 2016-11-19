import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Deque;

/**
 * Created by Sofia228 on 20.11.16.
 */

public class PointsGetter {

    private double DELTA = 1;
    private double curN = 0;
    private double curSin = 0;
    private double nextX = 0;
    private double nextY = 0;

    public double getDELTA() {
        return DELTA;
    }

    public double getCurN() {
        return curN;
    }

    public double getCurSin() {
        return curSin;
    }


    public double getNextX() {
        return nextX;
    }

    public double getNextY() {
        return nextY;
    }

    PointsGetter(double DELTA, double curN, double curSin, double nextX, double nextY) {
        this.DELTA = DELTA;
        this.curN = curN;
        this.curSin = curSin;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    private void getNextSin(double nextN) {
        curSin = curSin * curN / nextN;
    }

    public void getNextPoint(double nextN) {
        getNextSin(nextN);
        nextX += Math.tan(Math.asin(curSin)) / DELTA;
        nextY += DELTA;
    }

}
