package com.example.ex1_pdm_17042023;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String concat = "";
    String recebe_string = "";

    String contaternartexto = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void Soma(View view){
        EditText editText1 = (EditText) findViewById(R.id.editText01);
        EditText editText2 = (EditText) findViewById(R.id.editText02);
        double v1 = Double.parseDouble(editText1.getText().toString());
        double v2 = Double.parseDouble(editText2.getText().toString());
        editText1.getText().clear();
        editText2.getText().clear();


        double soma = v1 + v2;
        concat = concat+" "+v1+" + "+v2+" ="+soma+" \n";


    }


    public void Subtrair(View view){
        EditText editText1 = (EditText) findViewById(R.id.editText01);
        EditText editText2 = (EditText) findViewById(R.id.editText02);
        double v1 = Double.parseDouble(editText1.getText().toString());
        double v2 = Double.parseDouble(editText2.getText().toString());
        editText1.getText().clear();
        editText2.getText().clear();
        double sub = v1 - v2;
        concat = concat+" "+v1+" - "+v2+" ="+sub+" \n";

    }

    public void Multiplicar(View view){


        EditText editText1 = (EditText) findViewById(R.id.editText01);
        EditText editText2 = (EditText) findViewById(R.id.editText02);
        double v1 = Double.parseDouble(editText1.getText().toString());
        double v2 = Double.parseDouble(editText2.getText().toString());
        editText1.getText().clear();
        editText2.getText().clear();
        double mult = v1 * v2;
        concat = concat+" "+v1+" * "+v2+" ="+mult+" \n";

    }

    public void Dividir(View view){
        EditText editText1 = (EditText) findViewById(R.id.editText01);
        EditText editText2 = (EditText) findViewById(R.id.editText02);
        double v1 = Double.parseDouble(editText1.getText().toString());
        double v2 = Double.parseDouble(editText2.getText().toString());
        editText1.getText().clear();
        editText2.getText().clear();
        double soma = v1 / v2;
        concat =concat+ " "+v1+" / "+v2+" ="+soma+" \n";
    }


    public void Mostrar(View view){

        String filename = "myfile";
        String concatenador = concat;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(concatenador.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream input = openFileInput("myfile");
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((recebe_string = bufferedReader.readLine()) != null) {
                //Toast.makeText(getApplicationContext(), recebe_string, Toast.LENGTH_SHORT).show();
                contaternartexto += recebe_string+"\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView textView = (TextView) findViewById(R.id.textView02);

        textView.setText(contaternartexto);
    }





    public void Clear(View view){
        TextView textView = (TextView) findViewById(R.id.textView02);

        textView.setText("");

        String myfile = "myfile";
        File file = getBaseContext().getFileStreamPath(myfile);
        if(file.exists()) {
            boolean deleted = deleteFile(myfile);
            if (deleted) {
                Toast.makeText(getApplicationContext(), "Histórico limpo com sucesso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Erro ao limpar histórico", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Histórico vazio", Toast.LENGTH_SHORT).show();
        }
    }









}
