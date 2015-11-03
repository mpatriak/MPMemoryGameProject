package com.example.michal.mpmemorygameproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class gameActivity extends AppCompatActivity
{
    private Card selectedCard;
    private Button mNewGame;
    private Button mTryAgain;
    private List<Card> cards;
    private Card c1;
    private Card c2;
    private String name;
    private Button c;
    int matchVal1 = 100;
    int matchVal2 = 200;
    int cardFilled = 0;
    private Timer t;
    int score = 0;
    int triesLeft;
    TextView triesRemaining;
    TextView scoreNumber;
    int mScoreIncrement;
    int mTotalScore;

    private void startGame()
    {

        Bundle extras = getIntent().getExtras();
        int gameSize = extras.getInt("GameSize");
        List<Card> cardList = new ArrayList<Card>();
        List<Integer> cardVals = new ArrayList<Integer>();
        triesLeft = 10;
        mScoreIncrement = 1000;
        mTotalScore = 0;

        triesRemaining = (TextView)findViewById(R.id.triesLeftNumber);
        triesRemaining.setText(triesLeft + "");

        scoreNumber = (TextView)findViewById(R.id.score_number);
        scoreNumber.setText(mTotalScore + "");

        mNewGame = (Button)findViewById(R.id.new_game);
        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gameActivity.this, menuActivity.class);
                startActivity(i);
            }
        });


        // Loop through the 10 pairs and add each incremented values to
        // the ArrayList twice so that a pair will exist.
        for (int i = 0; i < gameSize; i++)
        {
            cardVals.add(i);
            cardVals.add(i);
        }
        // Shuffles the ArrayList of cards for a new game.
        Collections.shuffle(cardVals);

        ViewGroup row1 = (ViewGroup) findViewById(R.id.row1);
        ViewGroup row2 = (ViewGroup) findViewById(R.id.row2);
        ViewGroup row3 = (ViewGroup) findViewById(R.id.row3);
        ViewGroup row4 = (ViewGroup) findViewById(R.id.row4);
        ViewGroup row5 = (ViewGroup) findViewById(R.id.row5);
        ViewGroup row6 = (ViewGroup) findViewById(R.id.row6);
        ViewGroup row7 = (ViewGroup) findViewById(R.id.row7);
        int count = 0;

        // Loops through each Card Value in the ArrayList to create Card objects that is a Button.
        for (final int val : cardVals)
        {
            final Card c = new Card(this);
            c.setId(val);
            //c.setText(val);
            //final Button c = new Button(this);
            c.setText("");
            //c.setBackgroundColor(Color.CYAN);
            c.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams
                            .WRAP_CONTENT));

            if (count < 3)
            {
                row1.addView(c);
            } else if (count >= 3 && count <= 5)
            {
                row2.addView(c);
            } else if (count >= 6 && count <= 8)
            {
                row3.addView(c);
            } else if (count >= 9 && count <= 11)
            {
                row4.addView(c);
            } else if (count >= 12 && count <= 14)
            {
                row5.addView(c);
            } else if (count >= 15 && count <= 17)
            {
                row6.addView(c);
            } else if (count >= 18 && count <= 20)
            {
                row7.addView(c);
            }

            count++;



            c.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                   // When the user presses a button, selectedCard is set to the current card
                   // selected.
                    selectedCard = c;
                    // Calls the method to turn the card over.
                    flipCard();

                }


            });

            // Each Card object that is created is added to the cardsList ArrayList.
            cardList.add(c);
        }
        this.cards = cardList;




    }



    private void flipCard()
    {
        if (c1 == null && c2 == null)
        {
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getId()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null)
        {
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getId()));



            checkCard();
        }
    }

    private void checkCard()
    {
        if (c1.getId() == c2.getId())
        {
            c1.setEnabled(false);
            c2.setEnabled(false);

            c1.setMatched(true);
            c2.setMatched(true);

            scoreNumber = (TextView)findViewById(R.id.score_number);
            mTotalScore = mTotalScore + mScoreIncrement;
            scoreNumber.setText("" + mTotalScore);

            if (this.isGameWon())
            {
                Toast.makeText(this, "You Won!", Toast.LENGTH_LONG).show();
                mNewGame = (Button)findViewById(R.id.new_game);
                //mNewGame.setEnabled(true);
                mNewGame.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(gameActivity.this, menuActivity.class);
                        startActivity(i);
                    }
                });


            }
        } else
        {
            triesRemaining = (TextView)findViewById(R.id.triesLeftNumber);
            triesLeft--;
            triesRemaining.setText("" + triesLeft);

            for (Card c : cards)
            {
                c.setMatched(false);
            }



            mScoreIncrement = mScoreIncrement - 100;

            if (triesLeft == 0)
            {
                gameOver();
            } else
            {
                mTryAgain = (Button)findViewById(R.id.try_again);
                mTryAgain.setEnabled(true);

                mTotalScore = 0;
                scoreNumber = (TextView)findViewById(R.id.score_number);
                scoreNumber.setText(mTotalScore + "");

                for (Card c : cards)
                {
                    c.setEnabled(false);
                }

                mTryAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (Card c : cards)
                        {
                            c.setText("");
                            c.setEnabled(true);
                        }

                        mTryAgain.setEnabled(false);
                    }
                });
            }
        }
        c1 = null;
        c2 = null;
    }

    private boolean isGameWon()
    {
        for (Card c : this.cards)
        {
            if (c.getMatched() == false)
            {
                return false;
            }
        }
        return true;

    }

    private void gameOver()
    {
        for (Card c : this.cards)
        {
            c.setText("");
            c.setEnabled(false);
        }
        //mTryAgain.setEnabled(false);
        mNewGame = (Button)findViewById(R.id.new_game);
        mNewGame.setEnabled(true);
        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gameActivity.this, menuActivity.class);
                startActivity(i);
            }
        });
        Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();

    }


    // Activity Initilization Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the view.
        setContentView(R.layout.game);
        startGame();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


