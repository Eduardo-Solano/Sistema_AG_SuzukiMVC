
package modelo;

/**
 *
 * @author Edward
 */
public class Modelo_Categoria {
    private int idCategoria;
    private String descripcion;
    private int estado;
    
    public Modelo_Categoria(){
        idCategoria=0;
        descripcion="";
        estado=0;
    }

    public Modelo_Categoria(int idCategoria, String descripcion, int estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
