package tw.brad.android.games.guessnumber;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

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
        Log.i("brad", answer);

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
        String result = checkAB(strInput);

        log.append(strInput + " => " + result + "\n");

        input.setText("");


    }

    public void reset(View view){
        showDialog();
    }

    private void showDialog(){
        AlertDialog alert = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("WINNER");
        builder.setMessage("恭喜老爺, 賀喜夫人");
        builder.setCancelable(false);


        alert = builder.create();

        alert.show();
    }


    private String createAnswer(){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<3){
            set.add((int)(Math.random()*10));
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set){
            sb.append(i.toString());
        }

        return sb.toString();
    }
    private String checkAB(String guess){
        int A, B; A = B = 0;
        for (int i=0; i<answer.length(); i++){
            if (answer.charAt(i) == guess.charAt(i)){
                A++;
            }else if (answer.indexOf(guess.charAt(i)) != -1){
                B++;
            }
        }

        return A + "A" + B+ "B";
    }

}
