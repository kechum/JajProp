package UI.ListaAspirantes.ListaApirantes1920x1080;

import Model.NotificationCenter;
import UI.ListaAspirantes.ItemListView;

public class ItemListView1920x1080 extends ItemListView
{

    @Override
    protected Double getSizeLabel() {
        return 15.0;
    } //tamañoTexto

    @Override
    protected Double getSizeIconLabel() {
        return 25.0;
    }

    @Override
    protected Double getGraphicTextGap() {
        return 15.0;
    } //Espacio entre icono y texto

    @Override
    protected Double getLabelPadding() {
        return 3.0;
    }

    @Override
    protected Double getAlturaListView() {
        return 230.0;
    }

    @Override
    protected Double getVerticalGapListView() {
        return 10.0;
    } //espacio entre label de la list view

    @Override
    protected Double getAnchoListView() {
        return 195.0;
    }

    @Override
    protected Double popupInitialPositionX() {
        return -205.0;
    }

    @Override
    protected Double popupInitialPositionY() {
        return 10.0;
    }

    @Override
    protected double desplazamientoMostarMenuEditar() {
        return -1300;
    }

    @Override
    protected double desplazamientoEliminarAspirante() {
        return 1300;
    }


}