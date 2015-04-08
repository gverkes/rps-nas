package nl.mrprog.govert.week1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener{
    private static final String TAG = "MainActivity";
    TextView lblAICount, lblPlayerCount, lblWinner;
    ImageView imgAI, imgPlayer;
    Button btnRock, btnPaper, btnScissor;

    // Counters for winnings
    int AICount = 0, playerCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAI = (ImageView) findViewById(R.id.imgAI);
        imgPlayer = (ImageView) findViewById(R.id.imgPlayer);

        lblAICount = (TextView) findViewById(R.id.lblAICount);
        lblPlayerCount = (TextView) findViewById(R.id.lblPlayerCount);
        lblWinner = (TextView) findViewById(R.id.lblWinner);

        btnRock = (Button) findViewById(R.id.btnRock);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnScissor = (Button) findViewById(R.id.btnScissor);

        btnRock.setOnClickListener(this);
        btnPaper.setOnClickListener(this);
        btnScissor.setOnClickListener(this);
    }

    public void onClick(View v) {
        int winner = RPS.DRAW;
        int AIChoice = RPS.generateOuputAI();
        choosePicture(RPS.AI, AIChoice);

        switch (v.getId()) {
            // determine winner
            case R.id.btnRock:
                winner = RPS.getWinner(RPS.ROCK, AIChoice);
                choosePicture(RPS.PLAYER, RPS.ROCK);
                Log.d(TAG, "Rock");
                break;
            case R.id.btnPaper:
                winner = RPS.getWinner(RPS.PAPER, AIChoice);
                choosePicture(RPS.PLAYER, RPS.PAPER);
                Log.d(TAG, "Paper");
                break;
            case R.id.btnScissor:
                winner = RPS.getWinner(RPS.SCISSOR, AIChoice);
                choosePicture(RPS.PLAYER, RPS.SCISSOR);
                Log.d(TAG, "Scissor");
                break;

        }

        if (winner == RPS.PLAYER) {
            playerCount++;
            lblPlayerCount.setText(Integer.toString(playerCount));
            lblWinner.setText(RPS.MSG_PLAYER_WIN);
        } else if (winner == RPS.AI) {
            AICount++;
            lblAICount.setText(Integer.toString(AICount));
            lblWinner.setText(RPS.MSG_AI_WIN);
        } else if (winner == RPS.DRAW) {
            lblWinner.setText(RPS.MSG_DRAW);
        }
    }

    public void choosePicture(int player, int choice) {
        lblAICount = (TextView) findViewById(R.id.lblAICount);
        lblPlayerCount = (TextView) findViewById(R.id.lblPlayerCount);

        switch (choice) {
            case RPS.ROCK:
                if (player == RPS.PLAYER)
                   imgPlayer.setImageResource(R.drawable.prock);
                else
                    imgAI.setImageResource(R.drawable.airock);
                break;
            case RPS.PAPER:
                if (player == RPS.PLAYER)
                    imgPlayer.setImageResource(R.drawable.ppaper);
                else
                    imgAI.setImageResource(R.drawable.aipaper);
                break;
            case RPS.SCISSOR:
                if (player == RPS.PLAYER)
                    imgPlayer.setImageResource(R.drawable.pscissor);
                else
                    imgAI.setImageResource(R.drawable.aiscissor);
                break;
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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
