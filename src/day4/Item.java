package day4;

public class Item {
    private boolean flagged;
    private int data;

    public Item(int data) {
        this.data = data;
        this.flagged = false;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getData() {
        return data;
    }

}