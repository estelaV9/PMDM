# Tema 2: Introducción a Kotlin
>[!NOTE] Índice
> 1. Inicios en Kotlin.
> 2. Tour en Kotlin.
> 3. Arrays.
> 4. Estructuras de Control.
>    - `if`
>    - `when`
>    - `for`
>    - `while`
> 5. Funciones.
> - <a href="https://github.com/estelaV9/PMDM/tree/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos">Ejercicios básicos Kotlin</a>-
> - <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/ResumenEjerciciosKotlin.md">Puntos clave</a> de los ejercicios básicos.
> 6. Lambdas.
>    - Funciones de orden superior.
>    - Ejercicios Lambda.
> 7. Poo con Kotlin.

## 1. Inicios en Kotlin
Kotlin es un lenguaje de programación moderno que puede usarse para diferentes plataformas, incluyendo aplicaciones Android, iOS, y desarrollo multiplataforma. 
Algunas características clave son:
- **Multipropósito**: No solo se usa para Android.
- **Multiplataforma**: Desarrollo de aplicaciones para diferentes plataformas.
- **Interoperable con Java**: Kotlin puede convivir con código Java.
- **Inferencia de Tipos**: Kotlin puede deducir el tipo de datos automáticamente.

### Ejemplo de "Hola Mundo".
```kotlin
fun main() {
    println("Hola Mundo")
}
```
Este es el ejemplo básico para imprimir un _"Hola Mundo"_.

## 2. Tour en Kotlin
### Variables y Constantes
Kotlin es un lenguaje fuertemente tipado, lo que significa que el tipo de las variables no cambia durante su ciclo de vida.
- `var`: Declara una variable mutable.
- `val`: Declara una variable inmutable (similar a `const` o `final` en otros lenguajes).

```kotlin
val nombre: String = "Juan"
var edad: Int = 30
```

### Strings y Plantillas
Los strings pueden ser concatenados con el operador `+` o utilizando plantillas con el símbolo `$`.
```kotlin
val nombre = "Ana"
val saludo = "Hola, $nombre"
println(saludo) // Output: Hola, Ana
```

### Nulos
Kotlin no permite valores nulos de manera predeterminada, pero puedes permitirlos con `?`.
```kotlin
var nombre: String? = null
```

## 3. Arrays
Los arrays pueden ser definidos de diferentes formas en Kotlin:
```kotlin
fun main(args: Array<String>) {
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    println(weekDays.get(0))
}
```
Se pueden recorrer arrays en Kotlin de la siguiente manera:
```kotlin
fun main(args: Array<String>) {
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    for (posicion in weekDays.indices){
        println(weekDays.get(posicion))
    }
}
```

Puedes utilizar funciones como `map` para manipular arrays.
```kotlin
val doblados = numeros.map { it * 2 }
println(doblados) // Output: [2, 4, 6]
```

## 4. Estructuras de Control
### `if` y `when`
Kotlin permite utilizar `if` como expresión y `when` es similar a `switch` en Java.
```kotlin
val max = if (a > b) a else b
```

El uso de `when`:
```kotlin
when (x) {
    1 -> print("Uno")
    2 -> print("Dos")
    else -> print("Otro número")
}
```

### Bucles
Kotlin soporta bucles `for`, `while`, y `do-while`.
```kotlin
for (i in 1..5) {
    println(i)
}
```

## 5. Funciones
Las funciones en Kotlin se definen con la palabra clave `fun`. Kotlin soporta funciones con una única sentencia y funciones genéricas.
```kotlin
fun sumar(a: Int, b: Int): Int {
    return a + b
}

// Función con una única sentencia
fun restar(a: Int, b: Int) = a - b
```

Kotlin también soporta funciones genéricas:
```kotlin
fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}
```

## Funciones Lambda en Kotlin
### ¿Qué es un Lambda?
Un **lambda** es una función que no está declarada de la forma tradicional, sino que se define directamente como una expresión. Es una forma compacta de representar funciones y puede ser pasada como argumento a otras funciones. 

- Las **lambdas** permiten una programación más flexible y expresiva, sobre todo cuando trabajas con funciones de orden superior, donde las funciones se tratan como datos.

#### Ejemplo de Sintaxis:
```kotlin
val suma = { a: Int, b: Int -> a + b }
println(suma(5, 10))  // Salida: 15
```

### Usos Principales
#### 1. Asignación de Función a una Variable
En Kotlin, puedes asignar un **lambda** a una variable y luego invocarlo como una función:
```kotlin
val saludo = { println("Hola!") }
saludo()  // Salida: Hola!
```

#### 2. Paso de Funciones como Parámetro
Una de las principales características de Kotlin es que puedes pasar lambdas como parámetros a otras funciones, lo que habilita la programación funcional y permite escribir funciones más flexibles y reutilizables.
```kotlin
fun ejecutarOperacion(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

val resultado = ejecutarOperacion(3, 4, { x, y -> x + y })
println(resultado)  // Salida: 7
```

### Función como tipo de dato

### Funciones de Orden Superior
Las **funciones de orden superior** son funciones que reciben otras funciones como parámetros o que devuelven una función. 

### Sintaxis
```kotlin
    fun nombreFuncion (parametro:Tipo)[:TipoReturn]{sentencia}
```

### Retornar valores
- Sin sentencia return, la última instrucción es el valor de retorno.
- Con sentencia return sera necesario etiquetar con el mismo nombre que la funcion:
  ```kotlin
        (return@nombreFuncion valoraretornar)
    ```


## POO (Programación Orientada a Objetos) en Kotlin
### Definición de una Clase
Kotlin soporta POO como otros lenguajes orientados a objetos. La clase es el componente central que define un conjunto de propiedades y métodos.

#### Sintaxis de una clase:
```kotlin
    class nombreClase{\\cuerpo de la clase}
```
En el cuerpo de la clase pueden existir:
- Propiedades.
- Métodos (o funciones).
- Constructores.
Los getter y setter por defecto no se definen, el compilador los crea. Sintaxis:
```kotlin
     var nombre_propiedad[: tipo [= valor_inicial] [<getter>] [<setter>]
```  
### Instanciación de una Clase
#### Sintaxis de una instancia:
```kotlin
     {val|var} nombre_objeto=Nombre_Clase([argumentos]}
```

### Contructores
#### Por defecto
```kotlin
     class nombre_clase constructor(){ //cuerpo clase} 
```
#### Con parámetros
```kotlin
 class nombre_clase(parámetros){ //cuerpo clase}
```
Los parametros se definen con `var` o `val`.
#### Constructor principal
Solo puede haber uno sin código.
```kotlin
  class nombre_clase constructor(parametros){ //cuerpo clase} 
```
#### Constructor secundario
Se definen dentro de la clase y pueden contener código
```kotlin
  constructor(parámetros):this(param const principal){ //cuerpo const} 
```

### Herencia en Kotlin
En Kotlin, por defecto, las clases no pueden ser heredadas. Para permitir que una clase sea heredada, se debe marcar con la palabra clave `open`.

#### Sintaxis de Herencia:
```kotlin
    open class nombre_clase { //cuerpo clase}
```


---

>_IES Ribera de Castilla 24/25._
