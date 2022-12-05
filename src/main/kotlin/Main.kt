var puntos=0
fun main() {
    var tiras=21
    var aux=0
    var tirada=0
    var conjunto=false
    val numeros = mutableListOf<Int>()
    while(tiras>0){
        tirada = readLine()!!.toInt()
        if(conjunto==false){
            if(tirada==10&&tirada>=0){
                numeros.add(tirada)
                tiras-=2
            }else if(tirada<10&&tirada>=0){
                conjunto=true
                aux=tirada
                numeros.add(tirada)
                tiras--
            }
        }else{
            if(tirada+aux==10|| tirada+aux<10){
                numeros.add(tirada)
                conjunto=false
                tiras--
            }
        }

    }
    println(puntosSumar(numeros))
}

fun puntosSumar(numeros: MutableList<Int>): Int{
    var pos=0
    while(pos<numeros.size){
        if(pos==numeros.size-1){
            if(numeros.get(pos)==10){puntos+=10}
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
    return puntos
}

fun strike(pos: Int, numeros: MutableList<Int>){
    if(pos+2<numeros.size){
        puntos+=numeros.get(pos)+numeros.get(pos+1)+numeros.get(pos+2)
    }else if(pos+1==numeros.size-1){
        puntos+=numeros.get(pos)+numeros.get(pos+1)
    }
}

fun spare(pos: Int, numeros: MutableList<Int>){
    puntos+=numeros.get(pos)+numeros.get(pos+1)+numeros.get(pos+2)
}

fun open(pos: Int, numeros: MutableList<Int>){
    puntos+=numeros.get(pos)+numeros.get(pos+1)
}
