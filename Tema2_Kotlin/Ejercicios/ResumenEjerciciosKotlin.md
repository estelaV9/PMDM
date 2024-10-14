# Puntos clave de los ejercicios de Kotlin
## Ejercicio 2: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio2_AdivinarNumeroOculto/src/main/kotlin/Main.kt">Adivinar el número oculto</a>
### Declarar el scanner
Se declara en una variable val el scanner
```kotlin
  val scanner = Scanner(System.`in`)
  var variable = scanner.nextInt()
```
### Switch
En kotlin, no existe el switch. En cambio, tenemos el metodo when:
```kotlin
  when (opcion) {
      1 -> {}
      2 -> {}
      else ->
```
### Salir del programa
```kotlin
 exitProcess(0) // TERMINAR PROGRAMA
```
### Random
1. Importar la clase Random
  ```kotlin
    import kotlin.random.Random
  ```
2. Generar un número aleatoriamente
  ```kotlin
    // GENERAR UN NUMERO ALEATORIOENTRE 0 Y 9 (EXCLUYENDO EL 10)
    numeroAleatorio = Random.nextInt(10)
  ```

## Ejercicio 4: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio3_NumDigitosParesImpares/src/main/kotlin/Main.kt">Digitos pares e impares</a>
1. Hacer una variable auxiliar para ir reduciendo digitos.
2. Poner en una variable el último digito.
3. Eliminar último digito
```kotlin
  var numAuxiliar = numIntroducido // VARIABLE AUXILIAR PARA IR REDUCIENDO
    while (numAuxiliar > 0) {
        val digito = numAuxiliar % 10 // EXTRAER EL ULTIMO DIGITO
        contadorDigitos++
        if (digito % 2 == 0) {
            contadorPares++
        } else {
            contadorImpares++
        }
        numAuxiliar = numAuxiliar / 10 // ELIMINAR EL ULTIMO DIGITO
    }
```

## Ejercicio 5: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio5_NumerosMagicos/src/main/kotlin/Main.kt">Números Mágicos</a>
### Funciones
```kotlin
  fun nombreFuncion(parametro:Tipo):TipoDeReturn{}
```

## Ejercicio 7: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio7_NumMayor/src/main/kotlin/Main.kt">Números Mayor</a>
### Listas
Para trabajar con listas y añadir datos usamos `mutableListOf<Tipo>()
```kotlin
  // DECLARAMOS UNA LISTA MUTABLE VACIA DE ENTEROS
  var listNum = mutableListOf<Int>()
  listNum.add() // AÑADIR UN VALOR
```
### Encontrar el mayor
>[!WARNING]
> Recordar igualar el mayor al primer elemento de la lista
> ```kotlin
>   // Inicializar el numero mayor con el primer elemento en la lista
>   var numMayor = listNum[0] 
> ```

## Ejercicio 8: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio8_NumerosPrimos/src/main/kotlin/Main.kt">Números Primos</a>
### Primo
Un número primo no puede ser divisible por más numeros, solo por el mismo y por uno
>[!WARNING]
> Hacer raiz cuadrada del número (así se sacan los divisibles)
> ```kotlin
>   val raizCuadrada = Math.sqrt(numero.toDouble()).toInt() // RAIZ CUADRADA
>   for (i:Int in 2..raizCuadrada){ // EMPEZAR EN 2
>       if (numero % i == 0) {
>           return false
>       } // SI HAY DIVISOR, NO ES PRIMO, SALE DEL BUCLE
>   }
> ```


## Ejercicio 9: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio9_NumCapicua/src/main/kotlin/Main.kt">Número Capicua</a>
1. Añadir digitos a un array.
2. Iterar el array desde el último digito. **IMPORTANTE**: uso de `downTo`
3. Concatenar los numeros
```kotlin
  while (numAux % 10 > 0) {
      listNumber.add(numAux % 10)
      numAux /= 10
  } // SE AÑADEN LOS DIGITOS AL ARRAY

  // SE ITERA DESDE EL ULTIMO INDICE DE ListNumber HASTA EL PRIMER INDICE
  /** Para iterar a un rango decreciente se usa 'downTo', asi el bucle
   * se itera desde el ultimo indice hasta el primero **/
  for (i:Int in listNumber.size - 1 downTo 0){
      // CONCATENA LOS NUMEROS
      numeroInvertido += listNumber[i]
  }
```

## Ejercicio 10: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio10_AdivinarPalabra/src/main/kotlin/Main.kt">Adivinar la Palabra</a>
>[!WARNING]
> Si el tamaño de la lista de letras adivinada es el mismo que el tamaño de las letras de la palabra a adivinar, entonces ha adivinado la palabra.
> ```kotlin
>  if (listPalabrasIntroducidas.size == palabraAdivinar.size) {
>     println("¡Felicidades! Has adivinado la palabra: '$palabraAdivinar'")
>     break
>   } else {
>      // MOSTRAR LAS LETRAS ADIVINADAS
>      println("Letras adivinadas: $listPalabrasIntroducidas")
>   } 
> ```
### Encontrar palabra
```kotlin
fun estaPalabra(palabra: String, palabraAdivinar: List<String>): Boolean {
    for (i: Int in 0 until palabraAdivinar.size) {
        if (palabraAdivinar[i] == palabra) {
            println("La palabra $palabra SI esta")
            return true
        } // SI EL CARACTER SE ENCUENTRA EN LA PALABRA, RETORNAR TRUE
    } // RECORRER LA LISTA DE CARACTERES PARA VER SI ESTA LA PALABRA QUE HA INTRODUCIDO
    return false
} // METODO PARA SABER SI LA PALABRA ESTA O NO
```

## Ejercicio 11: <a href="https://github.com/estelaV9/PMDM/blob/master/Tema2_Kotlin/Ejercicios/EjerciciosBasicos/Ejercicio11_MediaAritmetica/src/main/kotlin/Main.kt">Media Aritmética</a>



---
<div align="center">
  <h2>¡Disfruta de los ejercicios de Kotlin!</h2>
</div>

>_IES Ribera de Castilla 24/25._



