package academy.mate.model;

public class Move {

    private Integer value;
    private int pointY;
    private int pointX;
    private String move;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Move{" +
                "value=" + value +
                ", pointY=" + pointY +
                ", pointX=" + pointX +
                ", move='" + move + '\'' +
                '}';
    }
}
