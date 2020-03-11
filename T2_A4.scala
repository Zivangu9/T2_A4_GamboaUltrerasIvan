class Paciente(nombre:String,primerAp:String,segundoAp:String,edad:Byte,var fecha:Array[String],var horaReg:Array[String],nivelBienestar:Array[Byte],temperatura:Array[Double],humedad:Array[Double]){
    
    def obtenerPromediosNivelBienestar(): Double = {
        var p = 0.0
        for(nb<-nivelBienestar){
            p+=nb
        }
        p/nivelBienestar.length
    }
    def obtenerTemperaturaMayor(): String = {
        var mayor = temperatura(0)
        var pos = 0
        for(t<-0 until temperatura.length){
            if(temperatura(t)>mayor){
                mayor = temperatura(t)
                pos = t
            }
        }
        "Temperatura mayor registrada"+
        "\nFecha: "+fecha(pos)+
        "\nHora: "+horaReg(pos)+
        "\nNivel de Bienestar: "+nivelBienestar(pos)+
        "\nTemperatura: "+temperatura(pos)+
        "\nHumedad: "+humedad(pos)
    }
    def obtenerTemperaturaMenor(): String = {
        var menor = temperatura(0)
        var pos = 0
        for(t<-0 until temperatura.length){
            if(temperatura(t) < menor){
                menor = temperatura(t)
                pos = t
            }
        }
        "Temperatura menor registrada"+
        "\nFecha: "+fecha(pos)+
        "\nHora: "+horaReg(pos)+
        "\nNivel de Bienestar: "+nivelBienestar(pos)+
        "\nTemperatura: "+temperatura(pos)+
        "\nHumedad: "+humedad(pos)
    }
    override def toString: String = "Paciente\nNombre: "+nombre+"\nPrimer Apellido: "+primerAp+"\nSegundo Apellido: "+segundoAp+"\nEdad: "+edad
}

object Prueba{	
	def main(args: Array[String]): Unit ={
        val paciente1 = new Paciente(
            "Ivan","Gamboa","Ultreras",21,
            Array[String]("11/03/2020","12/03/2020","13/03/2020","14/03/2020"),
            Array[String]("11:14","11:20","11:10","12:00"),
            Array[Byte](1,2,4,5),
            Array[Double](50.3,46.4,40.2,36.5),
            Array[Double](12.2,45.2,78.2,100.0))
        println(paciente1)
        println("Promedio de Bienestar: "+paciente1.obtenerPromediosNivelBienestar)
        println(paciente1.obtenerTemperaturaMayor)
        println(paciente1.obtenerTemperaturaMenor)
    }
}