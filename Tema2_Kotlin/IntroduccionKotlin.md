# Tema 2: Introducción a Kotlin
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


---

>_IES Ribera de Castilla 24/25._
