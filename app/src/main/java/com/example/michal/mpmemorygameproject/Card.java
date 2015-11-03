package com.example.michal.mpmemorygameproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by Michal on 10/17/2015.
 */
public class Card extends Button
{
    // Initializes the variables and sets matched to false to clear
    // the value every time this class is created.
    private int id;
    private boolean matched = false;

    public Card(Context context)
    {
        super(context);
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }


    public void setMatched(boolean matched)
    {
        this.matched = matched;
    }

    public boolean getMatched()
    {
        return this.matched;
    }

    public void setText(Integer integer)
    {

    }



}
