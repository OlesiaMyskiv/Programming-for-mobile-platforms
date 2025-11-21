package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Створення списку продуктів [cite: 360]
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product ("Картопля", "кг."));
        products.add(new Product ("Чай", "шт."));
        products.add(new Product ("Яйце", "шт."));
        products.add(new Product ("Молоко", "л."));
        products.add(new Product ("Макарони", "кг."));

        // Отримання посилання на ListView [cite: 371]
        ListView productList = findViewById(R.id.productList);

        // Створення адаптера [cite: 371]
        ProductAdapter adapter = new ProductAdapter(
                this, R.layout.list_item, products);

        // Встановлення адаптера для ListView [cite: 373]
        productList.setAdapter (adapter);
    }
}