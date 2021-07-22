package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog();
    }

    public void dialog() {
        AlertDialog.Builder alterDialogBuilder = new AlertDialog.Builder(context);
            alterDialogBuilder.setTitle(" 프로그램 종료 ");
            alterDialogBuilder
                    .setMessage(" 프로그램을 종료하겠습니까? ")
                    .setCancelable(false)
                    .setPositiveButton(" 종료 ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton(" 취소 ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = alterDialogBuilder.create();
            alterDialog.show();
    }
}