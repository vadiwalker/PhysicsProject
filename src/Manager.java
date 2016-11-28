import com.sun.xml.internal.bind.v2.TODO;

import graphics.*;
import model.*;
import parser.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Sofia on 20.11.16.
 */
public class Manager {
    // TODO: need to clear params
    private static String function; // to much params
    private static Node expression;
    private static PointsGetter pointsGetter;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt")); // TODO :  change available to user fields
        PrintWriter out = new PrintWriter(new File("output.txt"));
        StringTokenizer st = new StringTokenizer(in.readLine());

        makeExpression(in);

        double height = 800;
/**
 *  get some data for constructor with arguments if we have them in input
 *  or
 *  make new pointsGetter with default values for all arguments
 */
//        if (st.countTokens() == 5) {   // TODO: normal constructor with correct fields of users data
//            pointsGetter = new PointsGetter(
//                    Double.parseDouble(st.nextToken()),
//                    Double.parseDouble(st.nextToken()),
//                    Math.sin(Math.toRadians(Double.parseDouble(st.nextToken()))),
//                    Double.parseDouble(st.nextToken()),
//                    Double.parseDouble(st.nextToken()));
//        } else {
//            pointsGetter = new PointsGetter();
//        }
        pointsGetter = new PointsGetter(30, 1, 0.85, 400, 0);

        height /= pointsGetter.getDELTA();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            double curX = pointsGetter.getNextX();
            double curY = pointsGetter.getNextY();
            double nextN = expression.evaluate(curX, curY); // TODO: fix bag with double value
            pointsGetter.getNextPoint(nextN);  // TODO: check this method
            pointsGetter.setCurN(nextN);
            points.add(new Point((int) curX, (int) curY));
            System.out.println();
        }

        points.add(new Point((int) pointsGetter.getNextX(), (int) pointsGetter.getNextY()));

        new Painter().paintRay(points);
        out.close();
    }

    private static void makeExpression(BufferedReader in) throws IOException {
        Parser parser = new Parser();
        function = "2";  // TODO: move to input file
        expression = parser.getNode(function);
    }
}
