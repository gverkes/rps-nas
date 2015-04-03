package nl.mrprog.govert.week1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import nl.mrprog.govert.week1.RPS;

public class MainActivity extends ActionBarActivity implements OnClickListener{
    private static final String TAG = "MainActivity";
    TextView lblAICount, lblPlayerCount;
    Button btnRock, btnPaper, btnScissor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblAICount = (TextView) findViewById(R.id.lblAICount);
        lblPlayerCount = (TextView) findViewById(R.id.lblPlayerCount);

        btnRock = (Button) findViewById(R.id.btnRock);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnScissor = (Button) findViewById(R.id.btnScissor);

        btnRock.setOnClickListener(this);
        btnPaper.setOnClickListener(this);
        btnScissor.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRock:
                Log.v(TAG, Integer.toString(RPS.generateOuputAI()));
                Log.v(TAG, "Rock");
                break;
            case R.id.btnPaper:
                Log.v(TAG, "Paper");
                break;
            case R.id.btnScissor:
                Log.v(TAG, "Scissor");
                break;

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
