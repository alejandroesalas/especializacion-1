package edu.cecar.controladores;

import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraerDatoCVLACUnitTest {
    private List<Investigador> investigadores;
    private String urls[] = {"https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001578518",
    "https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180",
    "https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001480575"};
    @Before
    public  void setUpClass() {
        investigadores = new ArrayList<>();
        investigadores.add(new Investigador("MIGUEL ANGEL ROMERO GARAVITO",
                "Colombiana","Masculino",false));
        investigadores.add(new Investigador("Jhon Jaime Mendez Alandete",
                "Colombiana","Masculino",false));
        investigadores.add(new Investigador("INGRID JOHANNA ROMERO LAZARO",
                "Colombiana","Masculino",false));
        //
    }
    @Rule
    public GestionTestExtraerDatosCVLAC gestionTestExtraerDatosCVLAC = new GestionTestExtraerDatosCVLAC();



    @Test
    public void testDatosCVLAC() throws IOException {

         Investigador garavito = ExtraerDatoCVLAC.getDatos("https://scienti.colciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001578518");
         Investigador Jhon = ExtraerDatoCVLAC.getDatos(urls[1]);
        Investigador Ingrid = ExtraerDatoCVLAC.getDatos(urls[2]);
        // Se comprueba o testea el valor esperado con el obtenido
        assertEquals(garavito.getNombres(), investigadores.get(0).getNombres());
        assertEquals(Jhon.getNombres(), investigadores.get(1).getNombres());
        assertEquals(Ingrid.getNombres(), investigadores.get(2).getNombres());

        //Lineas de investigacion

     
    }
}
