var puntosdeldia = 1;
var totalpuntosdeldia = 1;

function anadePuntoDelDia() {
    var idpuntodeldiaAnterior = "#trpuntodeldia" + (puntosdeldia+1);
    $(idpuntodeldiaAnterior).show(600);
    puntosdeldia++;
    totalpuntosdeldia++;
    $("#numPuntos").val(totalpuntosdeldia);
    $("#eliminarultimo").removeAttr('disabled');
    if (totalpuntosdeldia==10){
        $("#agregarnuevo").attr('disabled', 'disabled');   
    }
    
    
}
function eliminaPuntoDelDia() {
    if (puntosdeldia>1){
        var idpuntodeldiaAnterior = "#trpuntodeldia" + puntosdeldia;
        $(idpuntodeldiaAnterior).hide(600);
        $(idpuntodeldiaAnterior).attr('value','HAHHAHAHAHAHA');
        puntosdeldia--;
        totalpuntosdeldia--;
        $("#numPuntos").val(totalpuntosdeldia);
        if(totalpuntosdeldia==1){
            $("#eliminarultimo").attr('disabled', 'disabled');
        }
        if(totalpuntosdeldia==9){
            $("#agregarnuevo").removeAttr('disabled');
        }  
    }
}
/*
function anadePuntoDelDia() {
    var idpuntodeldiaAnterior = "#trpuntodeldia" + puntosdeldia - 1;
    $(idpuntodeldiaAnterior).after('<tr id="trpuntodeldia' + puntosdeldia + '"><td><div class="labelslogin"><ice:outputLabel for="puntodeldia' + puntosdeldia + '">Punto del día ' + puntosdeldia + ':</ice:outputLabel></div></td><td><div class="inputslogin"><ice:inputText id="puntodeldia' + puntosdeldia + '" value="#\{creaReunion.listaPuntosdelDia\}" required="true" maxlength="255" validator="#\{validaciones.validarCadena255\}"></ice:inputText></div></td><td><div class="errorformulario"><ice:message id="errorpuntodeldia' + puntosdeldia + '" for="puntodeldia' + puntosdeldia + '"></ice:message></div></td></tr>');
    puntosdeldia++;
    totalpuntosdeldia++;
    $("#numerodepuntosdeldia").val(totalpuntosdeldia);
}
function eliminaPuntoDelDia() {
    if (puntosdeldia>1){
        var idpuntodeldiaActual = "#trpuntodeldia" + puntosdeldia;
        $(idpuntodeldiaActual).remove();
        puntosdeldia--;
        totalpuntosdeldia--;
    }
}
*/