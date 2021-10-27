package com.techreturners.mars;

public class MarRoverPos {
    //the x,y co-ordinates of the Rover
    //orientation as an enum
    private int CoOrdX;
    private int CoOrdY;
    private Orientation orientation;

    public enum Orientation {
        N("N", "W", "E"),
        E("E", "N", "S"),
        S("S", "E", "W"),
        W("W", "S", "N");

        private final String value;
        private final String left;
        private final String right;

        Orientation(String value, String left, String right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Orientation right() {
            return matchingOrientation(right);
        }

        public Orientation left() {
            return matchingOrientation(left);
        }

        public String value() {
            return value;
        }

        public Orientation matchingOrientation(String value) {
            for (Orientation orientN : values()) {
                if (orientN.value.equals(value) ) {
                    return orientN;
                }
            }
            return null;
        }
    }

    MarRoverPos(int CoOrdX, int CoOrdY, String orientation) {
        this.CoOrdX = CoOrdX;
        this.CoOrdY = CoOrdY;
        this.orientation = Orientation.valueOf(orientation);

    }

    public int getCoOrdX() {
        return CoOrdX;
    }

    public int getCoOrdY() {
        return CoOrdY;
    }

    public void setCoOrdX(int CoOrdX) {
        this.CoOrdX = CoOrdX;
    }

    public void setCoOrdY(int CoOrdY) {
        this.CoOrdY = CoOrdY;
    }

    @Override
    public String toString() {
        return CoOrdX + " " + CoOrdY + " ";
    }
}
