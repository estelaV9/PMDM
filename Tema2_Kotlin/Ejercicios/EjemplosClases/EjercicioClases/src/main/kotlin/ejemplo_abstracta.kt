abstract class Figura {
    public abstract var area: Double // PROPIEDAD ABSTRACTA PARA EL AREA
    public abstract fun dibujar() // METODO ABSTRACTO PARA DIBUJAR LA FIGURA
    protected abstract fun calcularArea() // METODO ABSTRACTO PARA CALCULAR EL AREA
} // CALSE ABSTRACTA QUE REPRESENTA UNA FIGURA

class Circulo : Figura {
    lateinit var color: String // PROPIEDAD COLOR SE INICIALIZA MAS TARDE
    public var radio: Double = (0).toDouble() // PROPIEDAD PARA EL RADIO DEL CIRCULO
        get() {
            return field
        } // RETORNA EL VALOR DE FIELD
        set(value) {
            field = value
        } // ASIGNA EL VALOR AL CAMPO FIELD

    public override var area: Double = 0.0 // IMPLEMENTACION DE LA PROPIEDAD ABSTRACTA AREA

    constructor(r: Double) {
        this.radio = r // ASIGNA EL VALOR DEL RADO
        calcularArea() // CALCULAR EL AREA
    } // CONSTRUCTOR QUE RECIBE EL RADIO DEL CIRCULO

    public fun inicializarColor(c: String) {
        if (!::color.isInitialized) // VERIFICA SI COLOR NO HA SIDO INICIALIZADO
            this.color = c // ASIGNA EL VALOR SI NO ESTA INICIALIZADO
    } // METODO APRA INICIALIZAR EL COLOR

    public override fun dibujar() {
        println("Muestra un circulo de radio $radio")
    } // IMPLEMENTACION DEL METODO ABSTRACTO DIBNUJAR

    protected override fun calcularArea() {
        this.area = Math.PI * Math.pow(this.radio, (2).toDouble()) /// CALCULA EL AREA USANDO LA FORMULA: π * radio^2
    } // IMPLEMENTACION DEL METODO CALCULAR AREA
} // CLASE CIRCULO, HEREDA DE FIGURA