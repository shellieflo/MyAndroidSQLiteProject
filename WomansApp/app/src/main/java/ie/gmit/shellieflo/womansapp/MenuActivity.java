package ie.gmit.shellieflo.womansapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MenuActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //declaration and initialisation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        View ButtonView = findViewById(R.id.imageButtonView);
        ButtonView.setOnClickListener(this);
        View ButtonAdd = findViewById(R.id.imageButtonAdd);
        ButtonAdd.setOnClickListener(this);
        View ButtonMeasure = findViewById(R.id.imageButtonMeasure);
        ButtonMeasure.setOnClickListener(this);
        View ButtonQuit = findViewById(R.id.imageButtonQuit);
        ButtonQuit.setOnClickListener(this);
    }


    public void onClick(View view) {//intent used to start another activity
        int id = view.getId();
        if (id == R.id.imageButtonView) {
            Intent a = new Intent(this, ViewMetric.class);
            startActivity(a);
        } else if (id == R.id.imageButtonAdd) {
            Intent b = new Intent(this, BodyMetricsActivity.class);
            startActivity(b);
        } else if (id == R.id.imageButtonMeasure) {
            Intent c = new Intent(this, MeasureActivity.class);
            startActivity(c);
        } else if (id == R.id.imageButtonQuit) {
            Toast.makeText(getBaseContext(),
                    "You clicked the Quit button, Don't forget to Track Your Food", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
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
