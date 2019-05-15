package aguinaga.cs.niu.assign5database;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    //class Variables
    private String name;
    private int id;
    private List<Item> items;

    //constructor
    public Item(String name, int id)
    {
        this.name = name;
        this.id = id;
        items = new ArrayList<>();
    }
    //getters
    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    //setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void addToList(String name, int id)
    {
        items.add(new Item(name, id));
    }


    //method to print out items in list
    public String toString()
    {
        return this.name;
    }
}
