package BD.Proveedores;

import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Excepciones.NoExistenObjetosException;
import BD.Proveedor;
import BD.TipoDeRepositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProveedorMock <T extends TipoDeRepositorio> implements Proveedor<T> {

    private List<T> lista = new ArrayList<T>();

    public ProveedorMock(List<T> lista) {
        this.setLista(lista);
    }

    @SuppressWarnings("unchecked")
    public ProveedorMock(T... lista) {
        this.setLista(Arrays.asList(lista));
    }

    public List<T> getLista() {
        return lista;
    }

    @Override
    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public T darObjeto(String unNombre, String unTipo) throws NoExisteObjetoConEseNombreException {
        return this.getLista().stream().filter(o -> o.getNombre().equals(unNombre)).findFirst().orElseThrow(() -> new NoExisteObjetoConEseNombreException());
    }

    @Override
    public List<T> darLista(String unTipo) throws NoExistenObjetosException {
        if(this.getLista().isEmpty()) throw new NoExistenObjetosException();
        return this.getLista();
    }

    @Override
    public List<String> darListaNombres(String unTipo) {
        return this.getLista().stream().map((TipoDeRepositorio e) -> e.getNombre()).collect(Collectors.toList());
    }

    @Override
    public void agregar(T unObjeto) {
        ArrayList<T> nuevaLista = new ArrayList<T>();

        if(getLista().size() != 0)
        {
            nuevaLista.addAll(this.getLista());
        }

        nuevaLista.add(unObjeto);

        this.setLista(nuevaLista);
    }

    @Override
    public void agregarLista(List<T> listaObjetos) {

        ArrayList<T> nuevaLista = new ArrayList<T>();

        if(getLista().size() != 0)
        {
            nuevaLista.addAll(this.getLista());
        }

        nuevaLista.addAll(listaObjetos);

        this.setLista(nuevaLista);
    }

    @Override
    public void modificar(T unObjeto) throws NoExisteObjetoConEseNombreException {
        try
        {
            this.lista.set(this.lista.indexOf(unObjeto), unObjeto);
        }
        catch(IndexOutOfBoundsException excepcion)
        {
            throw new NoExisteObjetoConEseNombreException();
        }
    }

    @Override
    public void eliminar(T unObjeto) {
        this.lista.remove(unObjeto);
    }

    @Deprecated
    @Override
    public T ejecutarQuery(Object query) {
        return null;
    }

    @Deprecated
    @Override
    public List<T> EjecutarQueryReturnList(Object query) {
        return null;
    }

    @Deprecated
    @Override
    public void eliminarConQuery(Object query) {

    }

}
