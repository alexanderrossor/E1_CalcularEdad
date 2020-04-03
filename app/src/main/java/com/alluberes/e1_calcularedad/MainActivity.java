package com.alluberes.e1_calcularedad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    /// TODO (11) Declarar objeto tipo EditText de "nombre_persona"
    EditText nombre_per;
    /// TODO (12) Declarar objeto tipo DatePicker de "date_of_birth"
    DatePicker date_of_b;
    /// TODO (13) Declarar objeto tipo Button de "calcular_edad"
    Button calcular_ed;
    /// TODO (14) Declarar objeto tipo EditText de "edad_actual"
    TextView edad_act ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /// TODO (15) Relacionar elemento de layout para nombre de persona con variable
        nombre_per = findViewById(R.id.nombre_persona);
        /// TODO (16) Relacionar elemento de layout para fecha de nacimiento con variable
        date_of_b = findViewById(R.id.date_of_birth);
        /// TODO (17) Relacionar elemento de layout para accion de calcular edad con variable
        calcular_ed = findViewById(R.id.calcular_edad);
        /// TODO (18) Relacionar elemento de layout para mostrar la edad actual con variable
        edad_act = findViewById(R.id.edad_actual);
        /// TODO (20) Asignar accion para el evento setOnClickListener del elemento de boton que calcula la edad
        /// en el evento onClick se debe tomar el valor del DatePicker que indica la fecha de nacimiento,
        /// e invocar la funcion que se crea en el paso 19 para calcular la edad
        /// y mostrar en el elemento del layout para mostrar edad un texto en el siguiente orden
        /// [nombre de la persona] tiene [edad] años  de edad
        /// debe sustituir los valores que estan en los corchetes por los valores de los elementos del layout
        calcular_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date fechanac = new GregorianCalendar(date_of_b.getYear(), date_of_b.getMonth(), date_of_b.getDayOfMonth()).getTime();
                Date fechaActual = new Date();
                    edad_act.setText(nombre_per.getText() + " Tiene: " + obtenerAnos(fechanac, fechaActual) + " Años de edad ");
            }
        });
    }
    /// TODO (19) Crear funcion para calcular edad. Ha de recibir como parametro año, mes y dia
    /// internamente ha de sacar la diferencia entre la fecha actual y la fecha dada y retornara el valor
    public static int obtenerAnos(Date primera, Date ultima) {
        Calendar fechaa = getCalendar(primera);
        Calendar fechab = getCalendar(ultima);
        int dif = fechab.get(Calendar.YEAR) - fechaa.get(Calendar.YEAR);
        if (fechaa.get(Calendar.MONTH) > fechab.get(Calendar.MONTH) ||
                (fechaa.get(Calendar.MONTH) == fechab.get(Calendar.MONTH) &&
                        fechaa.get(Calendar.DATE) > fechab.get(Calendar.DATE))) {
            dif--;
        }
        return dif;
    }
    public static Calendar getCalendar(Date fecha) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(fecha);
        return cal;
    }
}