package ie.gmit.shellieflo.womansapp;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BodyMetricsActivity extends ListActivity implements OnClickListener {

    private SQLiteDatabase database;
    private SQLiteMetricsDatabaseHelper dbHelper;
    private Button saveButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        saveButton.setOnClickListener(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_metrics);

    }


    @Override
    public void onClick(View v) {

        EditText nameTxt = (EditText) findViewById(R.id.txtName);
        EditText weightTxt = (EditText) findViewById(R.id.txtWeight);
        EditText heightTxt = (EditText) findViewById(R.id.txtHeight);
        EditText ageTxt = (EditText) findViewById(R.id.txtAge);
        EditText waistTxt = (EditText) findViewById(R.id.txtWaist);
        EditText hipsTxt = (EditText) findViewById(R.id.txtHips);
        saveButton = (Button) findViewById(R.id.DBSave);

        ArrayAdapter<BodyMetrics> adapter = (ArrayAdapter<BodyMetrics>) getListAdapter();
        Cursor cursor = null;
        BodyMetrics bodyMetric = new BodyMetrics(cursor.getLong(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), Integer.parseInt(cursor.getString(4)), cursor.getDouble(5), cursor.getDouble(6), cursor.getDouble(7), cursor.getDouble(8), cursor.getDouble(9), cursor.getDouble(10));
        assert bodyMetric != null;
//        new BodyMetrics(bodyMetric.setName(nameTxt.getText().toString()),
//                        bodyMetric.setWeight(Double.parseDouble(String.valueOf(weightTxt.getText()))),
//                        bodyMetric.setHeight(Double.parseDouble(String.valueOf(heightTxt.getText()))),
//                        bodyMetric.setAge(Integer.parseInt(String.valueOf(ageTxt.getText()))),
//                        bodyMetric.setWaist(Double.parseDouble(String.valueOf(waistTxt.getText()))),
//                        bodyMetric.setHips(Double.parseDouble(String.valueOf((hipsTxt.getText())))),
//                       // bodyMetric.setBmi(BodyMetrics.getBmi()), bodyMetric.setLeanMass(), bodyMetric.setBodyfat(), bodyMetric.setRatio());
//        dbHelper = new SQLiteMetricsDatabaseHelper(BodyMetricsActivity.this.getApplicationContext()));
        dbHelper.addBodyMetric(bodyMetric);
        adapter.add(bodyMetric);
        Toast.makeText(getApplicationContext(), nameTxt.getText().toString() + "your metrics have been saved to the database", Toast.LENGTH_SHORT).show();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_body_metrics, menu);
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


