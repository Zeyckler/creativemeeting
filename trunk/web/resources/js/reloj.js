var reloj;
 
function paraReloj(){
    clearTimeout(reloj);
}
 
function comienzaReloj(){
    var nd = new Date();
    var h, m;
    var s;
    var time = " ";
    h = nd.getHours();
    m = nd.getMinutes();
    s = nd.getSeconds();
    if (h <= 9) h = "0" + h;
    if (m <= 9) m = "0" + m;
    if (s <= 9) s = "0" + s;
    time += h + ":" + m + ":" + s; 
    //document.getElementById("reloj").innerHTML = time;
    document.getElementById("reloj").innerHTML = "PRUEBAAAAA";
    reloj = setTimeout("comienzaReloj()", 1000);
}