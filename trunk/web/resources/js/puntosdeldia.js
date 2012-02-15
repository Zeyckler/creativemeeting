var puntodeldia = 1;

function anadePuntoDelDia() {

    if(puntodeldia < 10) {
        var idpuntodeldia="puntodeldia" + puntodeldia;
        if(document.getElementById(idpuntodeldia) != "") {
            var tridpuntodeldiaSiguiente = "#trpuntodeldia" + (puntodeldia + 1);
            $(tridpuntodeldiaSiguiente).show(600);
            puntodeldia++;
        }
    }
}

function eliminaPuntoDelDia() {
    if(puntodeldia > 1) {
        var idpuntodeldiaAnterior = "#trpuntodeldia" + puntodeldia;
        $(idpuntodeldiaAnterior).hide(600);
        puntosdeldia--;
    }
}