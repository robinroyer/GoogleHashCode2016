package GoogleHashCode2016.HashCode2016;

import static GoogleHashCode2016.HashCode2016.Helpers.getTime;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Drone {
    int id;
    int r;
    int c;
    int maxWeight;

    public Drone(int id, int r, int c, int maxWeight) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.maxWeight = maxWeight;
    }

    public int goTo (int r, int c) {
        //
        // return time fo travel to position
        return getTime(this.r, this.c, r, c);
    }


}
