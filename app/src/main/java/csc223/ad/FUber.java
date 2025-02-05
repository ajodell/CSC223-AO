package csc223.ad;

public class FUber {

    // Returns the Euclidean distance between two points (i.e. "as the crow flies")
    public static float euclidean(float x1, float y1, float x2, float y2) {
        double xdiff = x1 - x2;
        double ydiff = y1 - y2;

        double xsqr = Math.pow(xdiff, 2);
        double ysqr = Math.pow(ydiff, 2);
        double total = xsqr + ysqr;

        double result = Math.sqrt(total);
        return (float) result;
    }

    // Returns the distance between two points following a grid
    public static float manhattan(float x1, float y1, float x2, float y2) {
        float xdiff = x1 - x2;
        float ydiff = y1 - y2;

        float absx = Math.abs(xdiff);
        float absy = Math.abs(ydiff);

        float total = absx + absy;
        return total;
    }
}