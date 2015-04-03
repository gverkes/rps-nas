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

    // Counters for winnings
    int AICount = 0, playerCount = 0;

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
        int winner = RPS.DRAW;
        switch (v.getId()) {
            // determine winner
            case R.id.btnRock:
                winner = RPS.getWinner(RPS.ROCK, RPS.generateOuputAI());
                Log.v(TAG, "Rock");
                break;
            case R.id.btnPaper:
                winner = RPS.getWinner(RPS.PAPER, RPS.generateOuputAI());
                Log.v(TAG, "Paper");
                break;
            case R.id.btnScissor:
                winner = RPS.getWinner(RPS.SCISSOR, RPS.generateOuputAI());
                Log.v(TAG, "Scissor");
                break;

        }
        if (winner == RPS.PLAYER) {
            playerCount++;
            lblPlayerCount.setText(Integer.toString(playerCount));
        } else if (winner == RPS.AI) {
            AICount++;
            lblPlayerCount.setText(Integer.toString(AICount));
        } else if (winner == RPS.DRAW) {

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
