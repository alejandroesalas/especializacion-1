package edu.cecar.controladores;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText teNombres;
    private TextInputEditText teNacionalidad;
    private TextInputEditText teSexo;
    private TextInputEditText teCategoria;

    String url_uno = "https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001578518";
    String url_dos = "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180";
    String url_tres = "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001007017";
    String url_cuatro = "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478";
    String url_cinco = "https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001480575";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se referencias los elementos graficos
        teNombres = findViewById(R.id.teNombres);
        teNacionalidad = findViewById(R.id.teNacionalidad);
        teSexo = findViewById(R.id.teSexo);
        teCategoria = findViewById(R.id.teCategorizado);


        Button btObtenerDatosCVLac = findViewById(R.id.btObtenerDatos);
        btObtenerDatosCVLac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                extraerDatosCVLAC();

            }
        });
    }

    public void extraerDatosCVLAC() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Investigador investigador = ExtraerDatoCVLAC.getDatos(url_cuatro);
                adicionarDatosCasillasTexto(investigador);
            }
        }).start();

    }

    public void adicionarDatosCasillasTexto(final Investigador investigador) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                teNombres.setText(investigador.getNombres());
                teNacionalidad.setText(investigador.getNacionalidad());
                teSexo.setText(investigador.getSexo());
                teCategoria.setText(investigador.isCategorizado() ? "Si" : "No");


            }
        });

    }

}
