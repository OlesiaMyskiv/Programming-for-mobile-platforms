package com.example.lab23ind;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityThree extends AppCompatActivity implements View.OnClickListener {

    String s = "Відповідь зараховано";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        // Перехід до Activity 4 через OnClickListener
        btn = findViewById(R.id.btnActFour);
        btn.setOnClickListener(this);
    }

    // Методи для обробки відповідей
    public void addPointA (View v) { MainActivity.score += 3; display(s); }
    public void addPointB (View v) { MainActivity.score += 1; display(s); }
    public void addPointC(View v) { MainActivity.score += 0; display(s); }

    public void display (String s) {
        TextView scoreView = findViewById(R.id.txt);
        scoreView.setText(String.valueOf(s));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnActFour) {
            Intent intent = new Intent(this, ActivityFour.class);
            startActivity(intent);
        }
    }
}
