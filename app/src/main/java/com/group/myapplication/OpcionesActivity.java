package com.group.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OpcionesActivity extends AppCompatActivity {

    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    private String pel, hor, dni;
    private LoginOpenHelper datosOpenHelper;
    private SQLiteDatabase conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        rb1 = (RadioButton)findViewById(R.id.rb_pelicula1);
        rb2 = (RadioButton)findViewById(R.id.rb_pelicula2);
        rb3 = (RadioButton)findViewById(R.id.rb_pelicula3);
        rb4 = (RadioButton)findViewById(R.id.rb_pelicula4);
        rb5 = (RadioButton)findViewById(R.id.rb_horario1);
        rb6 = (RadioButton)findViewById(R.id.rb_horario2);
        rb7 = (RadioButton)findViewById(R.id.rb_horario3);

        dni = getIntent().getStringExtra("dni");
    }

    //metodo para hacer reserva
    public void Reservar(View view) {

        //
        datosOpenHelper = new LoginOpenHelper(this, "DATOS",null, 1);
        conexion = datosOpenHelper.getWritableDatabase();

        if (rb1.isChecked()) {
            pel = rb1.getText().toString();}
        else if (rb2.isChecked()) {
            pel = rb2.getText().toString();}
        else if (rb3.isChecked()) {
            pel = rb3.getText().toString();}
        else {
            pel = rb4.getText().toString();}

        if (rb5.isChecked()) {
            hor = rb5.getText().toString();}
        else if (rb6.isChecked()) {
            hor = rb6.getText().toString();}
        else {
            hor = rb7.getText().toString();}

        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.FeedEntry.COLUMN_DNI, dni.trim());
        values.put(FeedReaderContract.FeedEntry.COLUMN_PELICULA, pel.trim());
        Toast.makeText(this, "pelicula = " + pel, Toast.LENGTH_SHORT).show();
        values.put(FeedReaderContract.FeedEntry.COLUMN_HORARIO, hor.trim());
        finish();

        conexion.insert(FeedReaderContract.FeedEntry.TABLE_RESERVAS, null, values);

        Toast.makeText(this, "Reservacion exitosa", Toast.LENGTH_SHORT).show();
        conexion.close();
        finish();
    }
/*
    public void
    datosOpenHelper = new LoginOpenHelper(this, "DATOS", null, 1);
    SQLiteDatabase db = datosOpenHelper.getWritableDatabase();
    String count = "SELECT count(*) FROM tabla_reservas";
    Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
    int icount = mcursor.getInt(0);
        if(icount>0)
            Toast.makeText(this, "te digo q si hay elementos", Toast.LENGTH_SHORT).show();
        else
                Toast.makeText(this, "no elementos", Toast.LENGTH_SHORT).show();
        mcursor.close();*/


    public void MostrarReservas(View view) {

        Intent siguiente = new Intent(this, ReservacionesActivity.class);
        siguiente.putExtra("dni",dni);
        startActivity(siguiente);



    }

    public void Eliminar(View view) {
        datosOpenHelper = new LoginOpenHelper(this, "DATOS",null, 1);
        conexion = datosOpenHelper.getWritableDatabase();

        String[] argumentos = {dni};
        //if(!dni.isEmpty()) {
        conexion.delete(FeedReaderContract.FeedEntry.TABLE_RESERVAS, FeedReaderContract.FeedEntry.COLUMN_DNI + "=?", argumentos );
        conexion.close();
        Toast.makeText(this, "Se ha borrado las reservas", Toast.LENGTH_SHORT).show();
        //} else {
        //            Toast.makeText(this, "No existen reservaciones previas" + pel, Toast.LENGTH_SHORT).show();
        //}
    }

    public void Regresar(View view) {
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

}