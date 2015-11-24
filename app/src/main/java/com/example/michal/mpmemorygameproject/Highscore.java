package com.example.michal.mpmemorygameproject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Michal on 11/18/2015.
 */
public class Highscore
{
    private final static String JSON_SCORE = "score";

    private int mHighscore;

    public Highscore(){}

    public void setScore(int score)
    {
        mHighscore = score;
    }

    public int getScore()
    {
        return mHighscore;
    }

    public Highscore(JSONObject json) throws JSONException
    {
        mHighscore = json.getInt(JSON_SCORE);
    }

    public JSONObject toJSON() throws JSONException
    {
        JSONObject json = new JSONObject();
        json.put(JSON_SCORE, mHighscore);
        return json;
    }


}
