package tw.brad.android.games.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View guess;
    private String answer;
    private EditText input;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        log = (TextView)findViewById(R.id.log);

        answer = createAnswer();

        guess = findViewById(R.id.guess);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGuess();
            }
        });

    }

    private void doGuess(){
        String strInput = input.getText().toString();

        // 檢查幾A幾B
        String result = checkAB();

        log.append(strInput + " => " + result + "\n");

        input.setText("");


    }

    public void reset(View view){

    }

    private String createAnswer(){
        return "175";
    }
    private String checkAB(){
        return "1A2B";
    }

}
