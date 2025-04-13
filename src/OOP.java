import java.util.*;

public class OOP
{
    public static void main(String args[])
    {
        Pen pen = new Pen();
        pen.setColor("Blue");
        System.out.println(pen.getColor());
    }
}

class Pen
{
    // attributes
    private String color;
    private int nib;

    Pen(){}

    Pen(Pen pen)
    {
        this.color = pen.color;
        this.nib = pen.nib;
    }

    String getColor()
    {
        return this.color;
    }

    void setColor(String newColor)
    {
        this.color = newColor;
    }

    int getNib()
    {
        return this.nib;
    }

    void setNib(int newNib)
    {
        nib = newNib;
    }
}