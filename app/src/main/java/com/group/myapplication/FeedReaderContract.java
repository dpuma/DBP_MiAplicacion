package com.group.myapplication;
import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_RESERVAS = "tabla_reservas";
        public static final String COLUMN_DNI = "dni";
        public static final String COLUMN_PELICULA = "pelicula";
        public static final String COLUMN_HORARIO = "horario";

        public static final String TABLE_USUARIOS = "tabla_usuarios";
        public static final String COLUMN_PASSWORD = "password";
    }
}
