package GoogleHashCode2016.HashCode2016;

import java.util.List;

import static java.lang.Math.*;

/**
 * Created by haidara on 11/02/16.
 */
import static java.lang.Math.*;

public class Helpers {

    public static int getTime (int x1, int y1, int x2, int y2) {
        //
        double distance = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return (int)ceil(distance);
    }
}
