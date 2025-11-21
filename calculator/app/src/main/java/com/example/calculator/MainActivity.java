package com.example.calculator; // Пакет, як на вашому скріншоті

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View; // Додано імпорт для View.OnClickListener
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultField;       // текстове поле для виводу результату
    EditText numberField;       // поле для вводу числа
    TextView operationField;    // текстове поле для виводу знаку операнда
    Double operand = null;      // операнд операції
    String lastOperation = "="; // остання операція

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // отримуємо всі поля по id із activity_main.xml
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        operationField = findViewById(R.id.operationField);

        // --- Обробники натискання для кнопок операцій (використовуємо анонімні класи) ---

        // Кнопка '+'
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperationClick("+");
            }
        });

        // Кнопка '-'
        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperationClick("-");
            }
        });

        // Кнопка '*'
        findViewById(R.id.mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperationClick("*");
            }
        });

        // Кнопка '/'
        findViewById(R.id.div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperationClick("/");
            }
        });

        // Кнопка '='
        findViewById(R.id.eq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperationClick("=");
            }
        });

        // --- Обробники натискання для числових кнопок та коми (використовуємо анонімні класи) ---

        // Кнопка '0'
        findViewById(R.id.n0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("0");
            }
        });

        // Кнопка '1'
        findViewById(R.id.n1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("1");
            }
        });

        // Кнопка '2'
        findViewById(R.id.n2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("2");
            }
        });

        // Кнопка '3'
        findViewById(R.id.n3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("3");
            }
        });

        // Кнопка '4'
        findViewById(R.id.n4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("4");
            }
        });

        // Кнопка '5'
        findViewById(R.id.n5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("5");
            }
        });

        // Кнопка '6'
        findViewById(R.id.n6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("6");
            }
        });

        // Кнопка '7'
        findViewById(R.id.n7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("7");
            }
        });

        // Кнопка '8'
        findViewById(R.id.n8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("8");
            }
        });

        // Кнопка '9'
        findViewById(R.id.n9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick("9");
            }
        });

        // Кнопка ',' (кома)
        findViewById(R.id.comma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(",");
            }
        });
    } // кінець onCreate

    // обробка натискання числової кнопки
    public void onNumberClick(String number) {
        numberField.append(number);
        // якщо остання операція була одержанням результату, скидаємо операнд
        if (lastOperation.equals("=") && operand != null) {
            operand = null;
        }
    }

    // обробка натискання кнопки операнда
    public void onOperationClick(String op) {
        String number = numberField.getText().toString();
        // якщо введено щось
        if (number.length() > 0) {
            // Заміна коми на точку, оскільки Double у java використовує точку як роздільник
            number = number.replace(',', '.');
            try {
                performOperation(Double.valueOf(number), op);
            } catch (NumberFormatException ex) {
                numberField.setText("");
            }
        }

        lastOperation = op;
        operationField.setText(lastOperation);
    }

    // виконання операції
    private void performOperation(Double number, String operation) {
        // Якщо операнд раніше не був встановлений (при вводі самої першої операції)
        if (operand == null) {
            operand = number;
        } else {
            // При введенні другої та наступних операцій застосовуємо попередню операцію
            if (lastOperation.equals("=")) {
                lastOperation = operation;
            }

            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
            }
        }

        // Отриманий результат зберігаємо у змінній operand.
        // Виведення результату, заміна точки на кому для відображення
        resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");
    }

    // збереження стану при зміні орієнтації
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    // отримання раніше збереженого значення
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");

        // Оновлення полів відображення
        if (operand != null) {
            resultField.setText(operand.toString().replace('.', ','));
        }
        operationField.setText(lastOperation);
    }
}