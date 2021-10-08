package com.example.numeroaleatorio.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.numeroaleatorio.R;
import com.example.numeroaleatorio.data.model.User;
import com.example.numeroaleatorio.databinding.ActivityPlayBinding;


public class PlayActivity extends AppCompatActivity {
    ActivityPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = (User) getIntent().getExtras().getSerializable("user");
        binding.tvNumIntentos.setText("Nº Intentos: "+ user.getIntentos().toString());// : "+user.getNumAleatorio());

        binding.btnComprobar.setOnClickListener(view -> {
            if(Ganar(binding, user)) {
                Bundle bnl = new Bundle();
                bnl.putSerializable("user", user);
                startActivity(new Intent(this, EndPlayActivity.class).putExtras(bnl));
            }
        });

        binding.btnReintentar.setOnClickListener(view -> {
            binding.edNum.setEnabled(true);
            binding.edNum.setText("");
            binding.tvMensage.setText("");
        });
    }
    private static boolean Ganar(ActivityPlayBinding binding, User user){
        try {
            if (Integer.parseInt(binding.edNum.getText().toString()) == user.getNumAleatorio()) {
                user.setWin(true);
                return true;
            } else {
                user.setIntentos(user.getIntentos() - 1);
                if (user.getIntentos() == 0) {
                    user.setWin(false);
                    return true;
                }
            }
            binding.edNum.setEnabled(false);
            binding.tvMensage.setText("Has fallado sigue intentandolo");
            binding.tvNumIntentos.setText("Nº Intentos: " + user.getIntentos().toString() + " : " + user.getNumAleatorio());
        }catch (NumberFormatException e) {
            binding.tvMensage.setText("EL DATO INTRODUCIDO NO ES CORRECTO");
        }
        return false;
    }
}