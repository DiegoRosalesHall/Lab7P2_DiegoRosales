
package lab7p2_diegorosales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdmProducto {
    ArrayList<Producto> productos = new ArrayList<>();
    File archivo = null;

    public AdmProducto() {
    }
    
    public AdmProducto(String path){
        archivo = new File(path);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void cargarArchivo(){
        Scanner sc = null;
        productos = new ArrayList<>();
        if(archivo.exists()){
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    productos.add(new Producto(sc.nextInt(),
                                    sc.nextInt(),
                                    sc.nextInt(),
                            sc.nextInt(),
                            sc.next(),
                            sc.nextDouble()
                                 ) 
                    );
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
   public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto t : productos) {
                
                bw.write(t.getId()+",");
                bw.write(t.getName()+",");
                bw.write(t.getCategory()+",");
                bw.write(t.getPrice()+",");
                bw.write(t.getAisle()+",");
                bw.write(t.getBin()+",");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
}
