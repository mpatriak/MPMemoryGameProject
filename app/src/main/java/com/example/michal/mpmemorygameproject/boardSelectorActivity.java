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

public class boardSelectorActivity extends AppCompatActivity
{
    String gamesize;

    // String to used a a key in the key-value pair when passing the Extra.
    public static final String EXTRA_GAMESIZE = "com.example.michal.memorygameproject.gamesize";

    // Define the androidListView.
    ListView mListView;

    // Elements that will be displayed in android ListView.
    String[] gameTypes = new String[] {"4 cards", "6 cards", "8 cards", "10 cards", "12 cards",
            "14 cards", "16 cards", "18 cards", "20 cards"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board_selector);
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

                String ETGameSize = (String)mListView.getItemAtPosition(position);

                switch (ETGameSize)
                {
                    case "4 cards":
                        Intent i = new Intent(boardSelectorActivity.this, card4Activity.class);
                        startActivity(i);
                        break;
                    case "6 cards":
                        Intent b = new Intent(boardSelectorActivity.this, card6Activity.class);
                        startActivity(b);
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
} // End class boardSelectorActivity.
