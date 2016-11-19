import com.sun.tools.example.debug.expr.ExpressionParser;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Sofia228 on 20.11.16.
 */
public class Manager {
    private static double height;
    private static PointsGetter pointsGetter;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        height = Double.parseDouble(st.nextToken());

        if (st.countTokens() == 6) {
            pointsGetter = new PointsGetter(
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()));
        }

        out.print(pointsGetter.getNextX() + pointsGetter.getNextY());

        int sz = (int) (height / pointsGetter.getDELTA());
        for (int i = 0; i < sz; i++) {
            double nextN = 0;// ExpressionParser(); here will be new n from parser for each iteration
            pointsGetter.getNextPoint(nextN);
            out.print(pointsGetter.getNextX() + pointsGetter.getNextY());
        }

    }
}
