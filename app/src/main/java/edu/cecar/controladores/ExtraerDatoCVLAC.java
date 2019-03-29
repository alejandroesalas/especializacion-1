package edu.cecar.controladores;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtraerDatoCVLAC {
    private ExtraerDatoCVLAC() {

    }

    public static Investigador  getDatos(String url) throws IOException {

        Investigador investigador = null;
         List<LineaInvestigacion> lineas = new ArrayList<>();

            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).validateTLSCertificates(false).
            get();
            Elements tablas = documentoHTML.select("table");
            Element tablaDatosPersonales = documentoHTML.select("table").get(1); //Se obtiene la segunda tabla
            //Element tablaLineaInvestigacion = documentoHTML.select("table").get(6); //Se obtiene la octava tabla
            Elements filasTabla = tablaDatosPersonales.select("tr"); // Se obtienen las filas de la tabla
           // Elements filasTablaOcho = tablaLineaInvestigacion.select("tr"); // Se obtienen las filas de la tablaLineaOcho
            int  filaNombre = 0;
            int filaNacionalidad = 2;
            int filaSexo = 3;

            if(filasTabla.size() > 5) {
                filaNombre = 2;
                filaNacionalidad = 4;
                filaSexo = 5;
            }
            //Se obtienen las columnas para cada atributo del invstigador
            String nombre = filasTabla.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTabla.get(filaNacionalidad).select("td").get(1).text();
            String sexo = filasTabla.get(filaSexo).select("td").get(1).text();
            investigador = new Investigador(nombre, nacionalidad,sexo,true);
            for (int i = 2; i < tablas.size(); i++) {
                Element tr = tablas.get(i).select("tr").first();
                if (tr!=null && tr.text().equalsIgnoreCase("Líneas de investigación")){
                        Elements listas = tablas.get(i).select("li");
                        for (Element lista : listas) {
                            List<TextNode> nodos = lista.textNodes();
                            boolean isActivo = nodos.get(1).text().equalsIgnoreCase("Si");
                            lineas.add(new LineaInvestigacion(nodos.get(0).text(),isActivo));
                            investigador.setLineas(lineas);
                        }
                }
            }

        return investigador;

    }
}
