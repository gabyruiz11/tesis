/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosAuxiliares;

/**
 *
 * @author David Hermosillo
 */
public class ImagenGlobalLocal {
    
    public int id;
    
    public String nombre;

    public ImagenGlobalLocal() {
    }

    public ImagenGlobalLocal(int id, String etiqueta) {
        this.id = id;
        this.nombre = etiqueta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
