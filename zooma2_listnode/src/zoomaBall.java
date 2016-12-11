/**
 * @author Nutthapol
 */
public class zoomaBall {
    private int index;
    private int ballNumber;
    private int color;

    public zoomaBall(int index, int ballNumber, int color) {
        this.index = index;
        this.ballNumber = ballNumber;
        this.color = color;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getIndex() {
        return index;
    }

    public int getColor() {
        return color;
    }
}
