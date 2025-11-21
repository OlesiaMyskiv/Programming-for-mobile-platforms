package com.example.lab23ind;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Клас повинен імплементувати View.OnClickListener для обробки переходу
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Глобальна статична змінна для підрахунку балів
    public static int score = 0;
    String s = "Відповідь зараховано";
    Button btn; // Кнопка для переходу

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Встановлення макету
        setContentView(R.layout.activity_main);

        // Обнуляємо бал на початку тесту (Правильно!)
        score = 0;

        // 2. Зв'язування кнопки переходу до ActivityTwo
        btn = findViewById(R.id.btnActTwo);

        // 3. Встановлення обробника подій
        btn.setOnClickListener(this);
    }

    // Методи для обробки відповідей (викликаються через android:onClick)
    public void addPointA (View v) { score += 3; display(s); }
    public void addPointB (View v) { score += 1; display(s); }
    public void addPointC(View v) { score += 0; display(s); }

    // Метод для відображення повідомлення
    public void display (String s) {
        TextView scoreView = findViewById(R.id.txt);
        scoreView.setText(String.valueOf(s));
    }

    // Метод обробника подій (onClick) для переходу
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnActTwo) {
            // Створення Intent для запуску ActivityTwo
            Intent intent = new Intent(this, ActivityTwo.class);
            startActivity(intent);
        }
    }
}