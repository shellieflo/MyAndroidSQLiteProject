package ie.gmit.shellieflo.womansapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

import java.sql.SQLException;
import java.util.List;

public class ViewMetric extends ListActivity implements OnClickListener {
    private ArrayAdapter<BodyMetrics> listAdapter;
    private SQLiteMetricsDatabaseHelper dbHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            listAdapter = new ArrayAdapter<>(this, R.layout.body_metric_item, allBodyMetrics());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setListAdapter(listAdapter);

    }

    @Override
    public void onClick(View v) {

    }
    private List<BodyMetrics> allBodyMetrics() throws SQLException {
        SQLiteFoodDatabaseHelper database = new SQLiteFoodDatabaseHelper(this.getApplicationContext());
        return dbHelper.getAllBodyMetrics();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This is called when the Home (Up) button is pressed
                // in the Action Bar.
                Intent parentActivityIntent = new Intent(this,ViewMetric.class);
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

