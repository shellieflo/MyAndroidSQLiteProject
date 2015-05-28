package ie.gmit.shellieflo.womansapp;

import android.app.Activity;
import android.os.Bundle;


public class BreastCheckActivity extends Activity {
//    TextView myTextView;
//    String res = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //myTextView = (TextView) findViewById(R.id.txtViewBrCheck);
        setContentView(R.layout.activity_breast_check);
    }
}

  /*  try {

        // OPENING THE REQUIRED TEXT FILE
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (getAssets().open("brCheckInfo")));
        String myLine = reader.readLine();

        // NOW READING THEM LINE BY LINE UPTO THE END OF FILE
        while (myLine != null) {
            res += myLine + "\n";
            myLine = reader.readLine();
        }

        // CLOSE THE FILE AFTER WE HAVE FINISHED READING
        reader.close();
    } catch (IOException e) {
        Toast.makeText(getApplicationContext(),
                "Error Opening Information file!!!", Toast.LENGTH_LONG).show();
    }
    myTextView.setText(res);
}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_breast_check, menu);
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
*/