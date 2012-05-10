function tiempoRestante(fechini, fechfin){
    
    var arrayhora = fechini.split(":");
    var arrayhoraf  = fechfin.split(":");
    
    var fechaini = new Date();
    var fechafin= new Date();
    
    fechaini.setHours(arrayhora[0], arrayhora[1], arrayhora[2], 0);
    fechafin.setHours(arrayhoraf[0], arrayhoraf[1], arrayhoraf[2], 0);
    

    
    var res = new Date( fechafin.getTime() - fechaini.getTime());
    
    var restante = res.getHours()+ ":"+ res.getMinutes() +":" + res.getSeconds();
    return restante;
}
function diferenciarestante(){

    var hinicio = getElementsByClass("horainicio")[0].value;
    
    var hfin =  getElementsByClass("horafinal")[0].value;
    
    
    
    var aux=tiempoRestante(hinicio,hfin);
     getElementsByClass("tiemporestante")[0].value=aux;
   // setTimeout(diferenciarestante(),5000);
}


function getElementsByClass(searchClass,node,tag) {
        var classElements = new Array();
        if ( node == null )
                node = document;
        if ( tag == null )

                tag = '*';
        var els = node.getElementsByTagName(tag);
        var elsLen = els.length;
        var pattern = new RegExp("(^|\\s)"+searchClass+"(\\s|$)");
        for (i = 0, j = 0; i < elsLen; i++) {
                if ( pattern.test(els[i].className) ) {
                        classElements[j] = els[i];
                        j++;
                }
        }
        return classElements;
}

