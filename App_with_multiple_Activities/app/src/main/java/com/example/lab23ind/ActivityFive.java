package com.example.lab23ind;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityFive extends AppCompatActivity {

    String s = "Відповідь зараховано";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
    }

    // Методи для обробки відповідей
    public void addPointA (View v) { MainActivity.score += 3; display(s); }
    public void addPointB (View v) { MainActivity.score += 1; display(s); }
    public void addPointC(View v) { MainActivity.score += 0; display(s); }

    public void display (String s) {
        TextView scoreView = findViewById(R.id.txt);
        scoreView.setText(String.valueOf(s));
    }

    // Метод, викликаний кнопкою "Отримати результат" через android:onClick="finished"
    public void finished(View v) {
        displayResult();
    }

    // Метод виведення фінального результату
    public void displayResult() {
        TextView resultView = findViewById(R.id.txt_result);

        int finalScore = MainActivity.score;
        String resultType;
        String recommendation;

        if (finalScore >= 11) {
            resultType = "АНАЛІТИЧНО-ЛОГІЧНИЙ ТИП ТВОРЧОСТІ";
            recommendation = "Ви створюєте систематично, використовуючи структуру та планування. Ваш метод ефективний для комплексних проєктів.";
        } else if (finalScore >= 5) {
            resultType = "ЗМІШАНИЙ (АДАПТИВНИЙ) ТИП ТВОРЧОСТІ";
            recommendation = "Ви вмієте поєднувати планування з інтуїцією. Ваша творчість гнучка та адаптивна.";
        } else {
            resultType = "ЕМОЦІЙНО-ІНТУЇТИВНИЙ ТИП ТВОРЧОСТІ";
            recommendation = "Ви залежите від натхнення та емоцій. Ваші сильні сторони — імпровізація та швидке генерування ідей.";
        }

        String finalMessage = "Ваш фінальний бал: " + finalScore + "/15\n\nТип: " + resultType + "\n\nРекомендація: " + recommendation;

        resultView.setText(finalMessage);
    }
}