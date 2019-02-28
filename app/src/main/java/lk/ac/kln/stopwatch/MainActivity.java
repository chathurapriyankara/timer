package lk.ac.kln.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int countDown = 99;
    private boolean running = false;
    private boolean wasRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDown();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning) {
            running = true;
        }
    }

    protected void clickStart(View view) {
        running = true;
    }

    private void countDown() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textView = findViewById(R.id.textView3);
                textView.setText(String.format("%2d",countDown));
                if(countDown==0) {
                    countDown = 100;
                }
                if(running) {
                    countDown--;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
