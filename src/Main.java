import com.parser.*;
import com.model.*;
import com.graphics.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 26.11.16.
 */
class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Painter painter = new Painter();
        String func = "1";
        Node f = parser.getNode(func);

        PointsGetter pget = new PointsGetter();
        int x = 100, y = 0;

        List<Point> points = new ArrayList<>();

        int height = 200;
        int iters = height / pget.getDELTA();



    }

}



