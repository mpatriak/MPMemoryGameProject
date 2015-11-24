package com.example.michal.mpmemorygameproject;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Michal on 10/3/2015.
 */
public class  AudioPlayer
{
    private MediaPlayer mPlayer;

    public void stop()
    {
        if (mPlayer != null)
        {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c)
    {
        // Initial call to stop MediaPlayer.
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.jingle);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                stop();
            }
        });
        mPlayer.start();
    }
} // End class AudioPlayer