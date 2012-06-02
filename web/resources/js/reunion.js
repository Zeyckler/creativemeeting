function tiempoRestante( fechfin) {

    var arrayhoraf = fechfin.split(":");
    
    var fechaini = new Date();
    var seginiciales = fechaini.getHours()*3600+ fechaini.getMinutes()*60+ fechaini.getSeconds() ;
    
    var segfin = arrayhoraf[2];
    var segminfin = parseInt(arrayhoraf[1])*60;
    var seghorfin = parseInt(arrayhoraf[0])*3600;
    var segfinales = parseInt(segfin)+parseInt(segminfin)+parseInt(seghorfin);
    
    var segrestantes = 0;
    segrestantes= parseInt( segfinales )- parseInt(seginiciales);
    
    var segundos = pad(segrestantes%60);
    var minutos = pad(parseInt((segrestantes/60)%60));
    var horas = pad(parseInt(segrestantes/3600));

    var restante = horas+":"+minutos+":"+segundos;
    return restante;
}

function diferenciarest() {
    
    var hfin = getElementsByClass("horafinal")[0].value;

    var aux = tiempoRestante(hfin);
    var aux2 = getElementsByClass("tiemporestante");
    aux2[0].value = aux;

}


function tiemporeunion(){
    
    var contador = getElementsByClass("horainicio")[0].value;
    var arrayI = contador.split(":");
    
    var seg = arrayI[2];
    var segmin = parseInt((arrayI[1])*60);
    var hor = parseInt((arrayI[0])*3600);
    var seginiciales = parseInt(seg)+parseInt(segmin)+parseInt(hor);

    var fechaact = new Date();
    var segfinales = fechaact.getHours()*3600+ fechaact.getMinutes()*60+ fechaact.getSeconds() ;

    var segrestantes = 0;
    segrestantes= parseInt( segfinales )- parseInt(seginiciales);
    
    var segundos = pad(segrestantes%60);
    var minutos = pad(parseInt((segrestantes/60)%60));
    var horas = pad(parseInt(segrestantes/3600));
    
    getElementsByClass("tiempotranscurrido")[0].value = horas +":"+ minutos +":"+ segundos;
    return segrestantes;
    
}


function setTime(){
    var totalSegundos = tiemporeunion();
    
    ++totalSegundos;
    var segundos = pad(totalSegundos%60);
    var minutos = pad(parseInt((totalSegundos/60)%60));
    var horas = pad(parseInt(totalSegundos/3600));
    getElementsByClass("tiempotranscurrido")[0].value = horas +":"+minutos+":"+segundos;
}

function pad(val)
{
    if(val <= 9)
    {
        return "0" + val;
    }
    else
    {
        return val;
    }
}
   
function getElementsByClass(searchClass, node, tag) {
    var classElements = new Array();
    if(node == null)
        node = document;
    if(tag == null)

        tag = '*';
    var els = node.getElementsByTagName(tag);
    var elsLen = els.length;
    var pattern = new RegExp("(^|\\s)" + searchClass + "(\\s|$)");
    for( i = 0, j = 0; i < elsLen; i++) {
        if(pattern.test(els[i].className)) {
            classElements[j] = els[i];
            j++;
        }
    }
    return classElements;
}

function costesReunionEmpleados(){
    
    var arraySalarios = getElementsByClass("salarioasist");
    var arrayCoste = getElementsByClass("costeasist");
    var tamS = arraySalarios.length;
    var totalSegundos = tiemporeunion();

    
    for(var i = 0; i<tamS; i++ ){
        
        var salasis = arraySalarios[i].firstChild.nodeValue;
        var costeSegAsis =((salasis/160))/3600;
        var costeAsisReun = arrayCoste[i].firstChild.nodeValue;
        
        
     
        costeAsisReun = parseFloat(costeSegAsis)* parseFloat(totalSegundos);
        costeAsisReun= costeAsisReun.toFixed(2);
        
        getElementsByClass("costeasist")[i].firstChild.nodeValue = costeAsisReun;
           
    }
    
    
}
function costesReunionEmpresas(){
    
    var arrayEmpresas = getElementsByClass("empresasAsis");
    var numEmpresas = arrayEmpresas.length;
   
    for(var i = 0; i<numEmpresas; i++){
        
        var nombreEmpresa  = arrayEmpresas[i].firstChild.nodeValue;
        var arrayCostesEmpresas = getElementsByClass(nombreEmpresa);
        var numCostes = arrayCostesEmpresas.length;
        var costePorEmpresa = 0;
        
        for (var j= 0; j<numCostes; j++){
            
            var coste = arrayCostesEmpresas[j].firstChild.nodeValue;
            costePorEmpresa = parseFloat(costePorEmpresa) + parseFloat(coste) ;
            
            costePorEmpresa= costePorEmpresa.toFixed(2);
        }
        var claseCambio = "cos"+arrayEmpresas[i].firstChild.nodeValue;
        
        getElementsByClass(claseCambio)[0].firstChild.nodeValue= costePorEmpresa;
   
    }
   
}
function costeTotalR(){
    var arraycosteasis = getElementsByClass("costeasist");
    var arrayCosteSala = getElementsByClass("alquilersala");
    var tamcosasis = arraycosteasis.length;
    var costeTotalUsuarios  = 0;

     
    for(var i =0; i<tamcosasis; i++){
         
        var costeAsistente = arraycosteasis[i].firstChild.nodeValue;
         
        costeTotalUsuarios = parseFloat(costeTotalUsuarios)+ parseFloat(costeAsistente);   
    }
    var costeSala = arrayCosteSala[0].firstChild.nodeValue;
     
    var totalAlquiler = parseFloat(costeSala)+parseFloat(costeTotalUsuarios);
     
    totalAlquiler = totalAlquiler.toFixed(2);
    
     
    getElementsByClass("alquilertotal")[0].firstChild.nodeValue= totalAlquiler;
    
    
}

function costes(){
    
    costesReunionEmpleados(); 
    return setInterval(costesReunionEmpleados, 15000);
    
}
function costeEmpresas(){
    
    costesReunionEmpresas();
    return setInterval(costesReunionEmpresas, 15000)
    
}
function costeTotalReunion(){
    costeTotalR();
    return setInterval(costeTotalR, 15000);
}

function contador(){
   
    return setInterval(setTime , 1000);
}
function diferenciarestante(){
    
    diferenciarest();
    return setInterval(diferenciarest, 1000);
    
    
}

function terminarFunciones(){

    clearInterval(costesEmpleadosReunion);
    clearInterval(costesEmpresasReunion);
    clearInterval(contadorReunion);
    clearInterval(diferenciaRestante);
    clearInterval(costeTotaldReunion);
  
    costesReunionEmpleados();
    costesReunionEmpresas();
    costeTotalR();
    setTime();
    diferenciarest();
    
}
