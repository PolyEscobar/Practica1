package Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtils {
    public static void jsonControl(){
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader("JsonFiles/Stock.json"));
            JsonObject fileObject = fileElement.getAsJsonObject();

            JsonArray productosArray = fileObject.getAsJsonArray("productos");

            for (JsonElement productoElement : productosArray) {
                JsonObject productoObject = productoElement.getAsJsonObject();

                String nombre = productoObject.get("nombre").getAsString();
                double precio = productoObject.get("precio").getAsDouble();
                String descripcion = productoObject.get("descripcion").getAsString();

                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Descripcion: " + descripcion);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}