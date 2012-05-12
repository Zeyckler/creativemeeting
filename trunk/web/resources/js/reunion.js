function tiempoRestante(fechini, fechfin) {

    var arrayhora = fechini.split(":");
    var arrayhoraf = fechfin.split(":");

    var fechaini = new Date();

    var fechafin = new Date();
	
    fechafin.setHours(arrayhoraf[0], arrayhoraf[1], arrayhoraf[2], 0);

    var seg = fechafin.getSeconds()-fechaini.getSeconds();
    var rmin=0;
    if(seg<0){
        seg = 60+fechafin.getSeconds()+seg;
        rmin = 1;
    }
        
    var min = fechafin.getMinutes()-fechaini.getMinutes();
    var rhora=0;
    if(min<0){ 
        min = fechafin.getMinutes()+60+min;
        rhora = 1;
    }
    if(min>0){
        min = min - rmin;
    }
   
  
    var hora = fechafin.getHours()-fechaini.getHours();
    if(hora){
        hora = hora - rhora; 
    }
    
    
    if (seg<=9){
        seg  = "0"+seg;
    }
    if (min<=9){
        min  = "0"+min;
    }
    if (hora<=9){
        hora = "0"+hora;
    }
           
       
        
    var restante = hora+":"+min+":"+seg;
    return restante;
}

function diferenciarestante() {

    var hinicio = getElementsByClass("horainicio")[0].value;

    var hfin = getElementsByClass("horafinal")[0].value;

    var aux = tiempoRestante(hinicio, hfin);
    var aux2 = getElementsByClass("tiemporestante");
    aux2[0].value = aux;
    setTimeout("diferenciarestante()", 1000);
}

function tiemporeunion(){
    
    var contador = getElementsByClass("horainicio")[0].value;
    var arrayI = contador.split(":");
    
    var seg = arrayI[2];
    var segmin = parseInt(arrayI[1])*60;
    var hor = parseInt(arrayI[0])*3600;
    var seginiciales = parseInt(seg)+parseInt(segmin)+parseInt(hor);

    var fechaact = new Date();
    var segfinales = fechaact.getHours()*3600+ fechaact.getMinutes()*60+ fechaact.getSeconds() ;

    var segrestantes = 0;
    segrestantes= parseInt( segfinales )- parseInt(seginiciales);
    

    
    var segundos = pad(segrestantes%60);
    var minutos = pad(parseInt((segrestantes/60)%60));
    var horas = pad(parseInt(segrestantes/3600));
    
    getElementsByClass("tiempotranscurrido")[0].value = horas +":"+ minutos +":"+ segundos;
    
    
    

    return segrestantes


}
function contador(){
   
    setInterval(setTime , 1000);
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

