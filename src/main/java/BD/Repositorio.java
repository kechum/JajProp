package BD;

import BD.Excepciones.NoExisteObjetoConEsaQueryException;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Excepciones.NoExistenObjetosException;

import java.util.ArrayList;
import java.util.List;

public abstract class Repositorio<T extends TipoDeRepositorio> {
    protected NombreRepositorio tabla;
    private Proveedor<T> proveedor = null;

    public Repositorio(NombreRepositorio nombreTabla) {
        this.tabla = nombreTabla;
    }

    public String getTabla() {
        return this.tabla.darNombreRepositorio();
    };

    public void setProveedor(Proveedor<T> unProveedor) {
        this.proveedor = unProveedor;
    }

    public Proveedor<T> getProveedor() {
        return proveedor;
    }

    public T buscarObjeto(String unNombre) throws NoExisteObjetoConEseNombreException {
        return this.getProveedor().darObjeto(unNombre, this.getTabla());
    }

    public List<T> buscarListaDeObjetos() throws NoExistenObjetosException {
        return this.getProveedor().darLista(this.getTabla());
    }

    public List<String> darListaNombres() {
        return this.getProveedor().darListaNombres(this.getTabla());
    }

    public void agregarObjeto(T unObjeto) {
        this.getProveedor().agregar(unObjeto);
    }

    public void agregarListaDeObjetos(List<T> listaObjetos) {
        this.getProveedor().agregarLista(listaObjetos);
    }

    public void modificarObjeto(T unObjeto) throws NoExisteObjetoConEseNombreException {
        this.getProveedor().modificar(unObjeto);
    }

    public void eliminarObjeto(T unObjeto) {
        this.getProveedor().eliminar(unObjeto);
    }

    public T buscarObjetoPorQuery(Object query) throws NoExisteObjetoConEsaQueryException {return this.getProveedor().ejecutarQuery(query);}

    public List<T> createQueryReturnList(Object query) throws NoExistenObjetosException {return this.getProveedor().EjecutarQueryReturnList(query);}

    public void deteleByQuery (Object query) {this.getProveedor().eliminarConQuery(query);}

    public void eliminarTodos() throws NoExistenObjetosException
    {
        getProveedor().setLista(new ArrayList<T>());
    }
}
