package tw.brad.android.games.guessnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        View view = findViewById(R.id.welcome);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =
                        new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });

    }
}
