var puntaje=0;

fun main() {
    var lanzamientos=21
    var lanzamiento=0
    var conjunto=false
    val datos = mutableListOf<Int>()
    var aux=0
    while(lanzamientos>0){
        lanzamiento= readLine()!!.toInt()
        if(conjunto==false){
            if(lanzamiento==10&&lanzamiento>=0){
                datos.add(lanzamiento)
                lanzamientos-=2
            }else if(lanzamiento<10&&lanzamiento>=0){
                conjunto=true
                aux=lanzamiento
                datos.add(lanzamiento)
                lanzamientos--
            }
        }else{
            if(lanzamiento+aux==10|| lanzamiento+aux<10){
                datos.add(lanzamiento)
                conjunto=false
                lanzamientos--
            }
        }
    }
    println("Score: " + puntosSumar(datos) + " :)")
}

fun open(pos: Int, datos: MutableList<Int>){
    puntaje+=datos.get(pos)+datos.get(pos+1)
}
fun spare(pos: Int, datos: MutableList<Int>){
    puntaje+=datos.get(pos)+datos.get(pos+1)
    +datos.get(pos+2)
}
fun strike(pos: Int, datos: MutableList<Int>){
    if(pos+2<datos.size){
        puntaje+=datos.get(pos)+datos.get(pos+1)
        +datos.get(pos+2)
    }else if(pos+1==datos.size-1){
        puntaje+=datos.get(pos)
        +datos.get(pos+1)
    }
}
fun puntosSumar(numeros: MutableList<Int>): Int{
    var pos=0
    while(pos<numeros.size){
        if(pos==numeros.size-1){
            if(numeros.get(pos)==10){puntaje+=10}
            pos++
        }else if(pos<numeros.size&&numeros.get(pos)==10) {
            strike(pos,numeros)
            pos++
        }else if(pos<numeros.size&&(numeros.get(pos)+numeros.get(pos+1))<10){
            open(pos,numeros)
            pos+=2
        }else if(pos<numeros.size&&(numeros.get(pos)+numeros.get(pos+1))==10) {
            spare(pos, numeros)
            pos+=2
        }
    }
    return puntaje
}

