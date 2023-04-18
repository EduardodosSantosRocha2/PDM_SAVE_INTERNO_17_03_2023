package com.example.ex2_pdm_17042023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String concat = "";
    String recebe_string = "";

    String texto = "";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public  void  AddFrase(View view){
        EditText editText = (EditText) findViewById(R.id.editText01);
        concat = concat +""+ editText.getText().toString();
    }

    public void Mostrar(View view){


        TextView textView = (TextView) findViewById(R.id.textView02);
        EditText editText2 = (EditText) findViewById(R.id.editText02);
        EditText editText1 = (EditText) findViewById(R.id.editText01);


        //
        int contarVogais = 0;






        String filename = "myfile";
        String concatenador = concat;
        FileOutputStream outputStream;


        try{
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(concatenador.getBytes());
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }




        try {
            FileInputStream input = openFileInput("myfile");
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);


            while( (recebe_string = bufferedReader.readLine() )!= null){
//                Toast.makeText(getApplicationContext(),recebe_string,Toast.LENGTH_SHORT);
                    texto =  recebe_string;
            }

        }catch (IOException e ){
            e.printStackTrace();
        }


        for (int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                contarVogais++;
        }




        String[] palavras = texto.split(" ");
        int var  = palavras.length;
        textView.setText("Texto: "+ texto+ "\n Numero palavras: "+var+"\nNumero vogais: "+ contarVogais+"\n ");
        editText1.getText().clear();



    }



    public void buscarPalavra(View view){


        TextView textView = (TextView) findViewById(R.id.textView02);
        EditText editText = (EditText) findViewById(R.id.editText02);
        String palavraestado = "Palavra não encontrada!";
        String palavraBuscada = editText.getText().toString();
        palavraBuscada = palavraBuscada.trim();





        try {
            FileInputStream input = openFileInput("myfile");
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);


            while( (recebe_string = bufferedReader.readLine() )!= null){
//                Toast.makeText(getApplicationContext(),recebe_string,Toast.LENGTH_SHORT);
                texto  = recebe_string;
            }

        }catch (IOException e ){
            e.printStackTrace();
        }



        String[] palavras = texto.split(" ");





        for(int i = 0; i< palavras.length;i++){
            if (palavras[i].equals(palavraBuscada)) {
                palavraestado = "Palavra encontrada!";
                break;
            }
        }








        textView.setText(palavraestado);
        editText.getText().clear();



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