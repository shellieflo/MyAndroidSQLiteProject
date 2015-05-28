package ie.gmit.shellieflo.womansapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnClickListener {
    private ImageButton BodyMetricsButton = null;
    private ImageButton FoodButton = null;
    private ImageButton BreastCheckButton = null;

    //Initialise and Set up listeners for the buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BodyMetricsButton = (ImageButton) findViewById(R.id.imageButtonBodyMetrics);
        BodyMetricsButton.setOnClickListener(this);
        FoodButton = (ImageButton)findViewById(R.id.imageButtonFood);
        FoodButton.setOnClickListener(this);
        BreastCheckButton = (ImageButton)findViewById(R.id.imageBreastchck);
        BreastCheckButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imageButtonBodyMetrics) {
           Intent a = new Intent(this, MenuActivity.class);
            startActivity(a);
        } else if (id == R.id.imageButtonFood) {
            Intent b = new Intent(this, FoodTrackerActivity.class);
            startActivity(b);
        } else if (id == R.id.imageBreastchck) {
            Intent c = new Intent(this, BreastCheckActivity.class);
            startActivity(c);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) switch (item.getItemId()) {
            case android.R.id.home:
                // This is called when the Home (Up) button is pressed
                // in the Action Bar.
                Intent parentActivityIntent = new Intent(this, MainActivity.class);
                parentActivityIntent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(parentActivityIntent);
                finish();
                return true;
        }
         return super.onOptionsItemSelected(item);
        }
}
