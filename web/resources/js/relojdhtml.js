/* relojdhtml.js compiled from X 4.0 with XC 0.27b. Distributed by GNU LGPL. For copyrights, license, documentation and more visit Cross-Browser.com */
var xOp7Up,xOp6Dn,xIE4Up,xIE4,xIE5,xNN4,xUA=navigator.userAgent.toLowerCase();
if(window.opera){
    var i=xUA.indexOf('opera');
    if(i!=-1){
        var v=parseInt(xUA.charAt(i+6));
        xOp7Up=v>=7;
        xOp6Dn=v<7;
    }
}else if(navigator.vendor!='KDE' && document.all && xUA.indexOf('msie')!=-1){
    xIE4Up=parseFloat(navigator.appVersion)>=4;
    xIE4=xUA.indexOf('msie 4')!=-1;
    xIE5=xUA.indexOf('msie 5')!=-1;
}else if(document.layers){
    xNN4=true;
}
xMac=xUA.indexOf('mac')!=-1;
function xGetElementById(e){
    if(typeof(e)!='string') return e;
    if(document.getElementById) e=document.getElementById(e);
    else if(document.all) e=document.all[e];else e=null;
    return e;
}
function xInnerHtml(e,h){
    if(!(e=xGetElementById(e)) || !xStr(e.innerHTML)) return null;
    var s = e.innerHTML;
    if (xStr(h)) {
        e.innerHTML = h;
    }
    return s;
}
function xStr(s){
    for(var i=0; i<arguments.length; ++i){
        if(typeof(arguments[i])!='string') return false;
    }
    return true;
}

function mueveReloj(){
    momentoActual = new Date()
    hora = momentoActual.getHours()
    if (hora<10) hora = "0" + hora
    minuto = momentoActual.getMinutes()
    if (minuto<10) minuto = "0" + minuto
    segundo = momentoActual.getSeconds()
    if (segundo<10) segundo = "0" + segundo

    horaImprimible = hora + " : " + minuto + " : " + segundo

    cambiaTexto(horaImprimible)
	
    setTimeout("mueveReloj()",1000) 
} 

function cambiaTexto(nuevaHora){
    xInnerHtml('capareloj',nuevaHora)	
}