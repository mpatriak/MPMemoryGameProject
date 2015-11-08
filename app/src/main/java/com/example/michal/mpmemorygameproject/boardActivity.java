package com.example.michal.mpmemorygameproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class boardActivity extends AppCompatActivity
{

    // String to be used a a key in the key-value pair when passing the Extra.
    public static final String EXTRA_GAMESIZE = "com.example.michal.memorygameproject.gameSize";
    // Define the androidListView.
    ListView mListView;
    // Elements that will be displayed in ListView.
    String[] gameTypes = new String[] {"4 cards", "6 cards", "8 cards", "10 cards", "12 cards",
            "14 cards", "16 cards", "18 cards", "20 cards"};

    // Initialization methods.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        mListView = (ListView) findViewById(R.id.list);

        // Declare Array adapter.
        ArrayAdapter<String> gameAdapter = new ArrayAdapter<String>(this,android.R.layout
                .simple_list_item_1, gameTypes);

        // Setting the android ListView's adapter to the newly created adapter.
        mListView.setAdapter(gameAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Creates a vriable to hold the selected item from the list.
                String ETGameSize = (String)mListView.getItemAtPosition(position);

                // Launches the gameActivity depending on the size of ETGameSize.
                switch (ETGameSize)
                {
                    case "4 cards":
                        Intent a = new Intent(boardActivity.this, gameActivity.class);
                        a.putExtra("GameSize", (int) 2);
                        startActivity(a);
                        break;
                    case "6 cards":
                        Intent b = new Intent(boardActivity.this, gameActivity.class);
                        b.putExtra("GameSize", (int) 3);
                        startActivity(b);
                        break;
                    case "8 cards":
                        Intent c = new Intent(boardActivity.this, gameActivity.class);
                        c.putExtra("GameSize", (int) 4);
                        startActivity(c);
                        break;
                    case "10 cards":
                        Intent d = new Intent(boardActivity.this, gameActivity.class);
                        d.putExtra("GameSize", (int) 5);
                        startActivity(d);
                        break;
                    case "12 cards":
                        Intent e = new Intent(boardActivity.this, gameActivity.class);
                        e.putExtra("GameSize", (int) 6);
                        startActivity(e);
                        break;
                    case "14 cards":
                        Intent f = new Intent(boardActivity.this, gameActivity.class);
                        f.putExtra("GameSize", (int) 7);
                        startActivity(f);
                        break;
                    case "16 cards":
                        Intent g = new Intent(boardActivity.this, gameActivity.class);
                        g.putExtra("GameSize", (int) 8);
                        startActivity(g);
                        break;
                    case "18 cards":
                        Intent h = new Intent(boardActivity.this, gameActivity.class);
                        h.putExtra("GameSize", (int) 9);
                        startActivity(h);
                        break;
                    case "20 cards":
                        Intent i = new Intent(boardActivity.this, gameActivity.class);
                        i.putExtra("GameSize", (int) 10);
                        startActivity(i);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_board_selector, menu);
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
} // End class boardActivity.
