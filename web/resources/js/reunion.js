function tiempoRestante(fechini, fechfin){
    
    var arrayhora = fechini.split(":");
    var arrayhoraf  = fechfin.split(":");
    
    var fechaini= new Date(Date.getYear(), Date.getMonth(), Date.getDay(), arrayhora[0] ,arrayhora[1], arrayhora[2]);
    var fechafin= new Date(Date.getYear(), Date.getMonth(), Date.getDay(), arrayhoraf[0] ,arrayhoraf[1], arrayhoraf[2]);
    
    var res = fechafin.getTime() - fechaini.getTime();
    
    var restante = res.getHours()+ ":"+ res.getMinutes() +":" + res.getSeconds();
    return restante;
}
function diferenciarestante(){
    var hinicio = getElementById("horainicio", 0).value;
    window.alert(hinicio.value);
    var hfin = getElementById("horafinal", 0).value;
    var aux=tiempoRestante(hinicio,hfin);
    getElementsByClassName("tiemporestante", 0).value=aux;
    setTimeout(diferenciarestante(),1000);
}






function getElementsByClassName(classname, node)  {
    if(!node) node = document.getElementsByTagName("body")[0];
    var a = [];
    var re = new RegExp('\\b' + classname + '\\b');
    var els = node.getElementsByTagName("*");
    for(var i=0,j=els.length; i<j; i++)
        if(re.test(els[i].className))a.push(els[i]);
    return a;
}