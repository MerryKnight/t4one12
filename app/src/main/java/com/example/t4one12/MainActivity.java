package com.example.t4one12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*2. Создать новый проект. Разместить три фрагмента с разным наполнением
тремя способами (статически, динамически и через элемент fragmentContainerView).
3. Сделать перемещение между созданными фрагментами.*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new ContainerFragment());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new StaticFragment());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new DynamicFragment());
            }
        });

    }
    public void navigateToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(null) // Добавляем транзакцию в стек возврата для возможности возврата назад
                .commit();
    }
}