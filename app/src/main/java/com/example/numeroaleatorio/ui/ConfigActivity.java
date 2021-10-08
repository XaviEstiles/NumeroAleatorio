package com.example.numeroaleatorio.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.numeroaleatorio.data.model.User;
import com.example.numeroaleatorio.databinding.ActivityConfigBinding;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class ConfigActivity extends AppCompatActivity {
    ActivityConfigBinding binding;
    class Vacio extends Exception {
        public Vacio() {
            super();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnJugar.setOnClickListener(view -> {

            Random rnd = new Random();
            try {
                User usr = new User(binding.edNombre.getText().toString(), Integer.parseInt(binding.edIntentos.getText().toString()), rnd.nextInt(100), false);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", usr);
                if (binding.edIntentos.getText().length() <= 0 || binding.edNombre.getText().length() <= 0){
                    Vacio vacio = new Vacio();
                    throw  vacio;
                }
                startActivity(new Intent(this, PlayActivity.class).putExtras(bundle));
            }catch (NumberFormatException e) {
                binding.tvError.setText("EL DATO INTRODUCIDO NO ES CORRECTOS");
            }catch (Vacio vacio){
                binding.tvError.setText("EL NOMBRE NO PUEDE ESTAR VACIO");
            }
        });
    }
}