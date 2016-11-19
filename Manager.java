import com.sun.tools.example.debug.expr.ExpressionParser;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Sofia228 on 20.11.16.
 */
public class Manager {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt")); // we can change all fields which
        // can be available to user
        PrintWriter out = new PrintWriter(new File("output.txt"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        double height = Double.parseDouble(st.nextToken());
        
        PointsGetter pointsGetter;
        if (st.countTokens() == 6) {   // get some data for constructor with arguments if we have them in input
            pointsGetter = new PointsGetter(
                                            Double.parseDouble(st.nextToken()),
                                            Double.parseDouble(st.nextToken()),
                                            Double.parseDouble(st.nextToken()),
                                            Double.parseDouble(st.nextToken()),
                                            Double.parseDouble(st.nextToken()));
        } else {
            pointsGetter = new PointsGetter(); // else make new pointsGetter with default values for all arguments
        }
        
        out.print(pointsGetter.getNextX() + pointsGetter.getNextY());
        
        height /= pointsGetter.getDELTA();
        for (int i = 0; i < height; i++) {
            double nextN = 0;// ExpressionParser(pointsGetter.getNextX); here will be new n from parser for each iteration
            pointsGetter.getNextPoint(nextN);
            out.print(pointsGetter.getNextX() + pointsGetter.getNextY());
        }
        
        out.close();
    }
}
