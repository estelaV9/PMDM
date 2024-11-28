# Tema 5: Interface Gráfica II

## Activities
Una **activity** representa cada una de las pantallas dentro de una aplicación, pero no la interfaz gráfica. Generalmente, una aplicación está compuesta por varias actividades interconectadas entre sí.

Siempre hay una actividad principal, lo cual es la primera que se instancia y muestra al usuario cuendo la aplicación se ejecuta.

Cuando se inicia una nueva actividad, esta se coloca en la pila de actividades (**PILA LIFO**), mientras que la actividad anterior se pausa temporalmente

---
## Introducción a las Activities: <a href="https://developer.android.com/guide/components/activities/intro-activities?hl=es">Codelapp</a>
A diferencia de otros códigos de programación, donde las aplicaciones comienzan con un método `main()`, Android inicia el código en una instancia de `Activity`, invocando métodos específicos relacionados con las distintas etapas del ciclo de vida de la actividad.

### Registro y configuración de Activities
Para que la aplicación pueda usar actividades, hay que declararlas en el archivo manifieesto. Además, es importante gestionar correctamente el ciclo de vida de las actividades.
Para declarar una actividad, abre el archivo de manifest y agrega un elemento `<activity>` dentro del bloque `<application>`:

```xml
<manifest ... >
  <application ... >
      <activity android:name=".ExampleActivity" />
      ...
  </application>
</manifest>
```

El atributo `android:name` especifica el nombre de la clase de la actividad. En este archivo se puede agregar otros atributos opcionales, como etiquetas, íconos o temas de IU.

> [!NOTE]
> Una vez publicada la app, no se debera cambiar los nombres de las actividades ya que puede romper funcionalidades como los accesos directos

### Declara filtros de Intents
Los **filtros de intents** permiten que una actividad responda a solicitudes explícitas e implícitas. Por ejemplo, una **solicitud explícita** podría indicar que se debe iniciar la actividad "Enviar correo electrónico" en la app de Gmail, mientras que una **solicitud implícita** pediría iniciar cualquier actividad que permita enviar un correo. <br>

Para declara un filtro de intents en el manifest, se usa el bloque `<intent-filter>` dentro de la actividad:
```xml
<activity android:name=".ExampleActivity" android:icon="@drawable/app_icon">
    <intent-filter>
        <action android:name="android.intent.action.SEND" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:mimeType="text/plain" />
    </intent-filter>
</activity>
```

Ese código indica que la actividad puede enviar datos de tipo "texto plano". Posteriormente, se podrá invocar esta actividad desde otra parte de la app mediante un `Intent`:
```kotlin
val sendIntent = Intent().apply {
    action = Intent.ACTION_SEND
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, textMessage)
}
startActivity(sendIntent)
```

### Declara permisos
Se puede restringir qué aplicaciones pueden iniciar una actividad particular mediante el uso de permisos. Si una actividad superior requiere permisos especiales para ser llamada, las actividades secundarias también deben declarar los mismos permisos en su manifiesto.

Por ejemplo, si tu app necesita acceder a una funcionalidad de "compartir" en otra app, como una aplicación de redes sociales, debes declarar los permisos en el manifiesto de ambas aplicaciones:

```xml
<manifest>
  <activity android:name="..."
            android:permission="com.google.socialapp.permission.SHARE_POST" />
</manifest>
```
---

### Activities: Ciclo de Vida
#### onCreate()
El método `onCreate()` se invoca justo después de que el SO haya creado la instancia d la acitvidad. Es el único método obligatorio de implementar. Generalmente, este método solo se ejecuta una vez durante todo el ciclo de vida de la actividad.
Dentro de este método, incluimos:
- **Vincular la vista (IU)**: se establete la interfaz de usuario mediante el método `setContentView`:
  ```kotlin
    public void setContentView (View view)
  ```
  
- **Recuperar el estado de la actividad**: Si la actividad fue finalizada por el SO para liberar memoria, se puede recuperar su estado guardando en un objeto `Bundle`.
- **Vincular un ViewModel**:
- **Instanciar los componentes**(`findViewById`) o hacer el `binding` (**invocación a una función de la clase**).

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)
  inicializarComponents()  // INICIALIZACION DE VISTAS Y BOTONES
}
```


#### onStart()
El método `onStart()` se ejecuta cuando la actividad se hace visible al usuario. Este método se invoca después de `onCreate()` (o después de `onRestart()` si la actividad estaba detenida). Aquí deberíamos incluir:

- Dibujar elementos visuales en la interfaz.
- Ejecutar animaciones o efectos visuales que deben iniciarse cuando la actividad entra en la vista del usuario.
  
Si implementas `onStart()`, también debes invocar el método de la clase padre (`super.onStart()`), para asegurar el comportamiento adecuado del ciclo de vida.

```kotlin
override fun onStart() {
    super.onStart()
    Log.i("CicloVida", "La actividad se hace visible")
}
```


#### onResumen()
Cuando la actividad pasa al primer plano y el usuario puede interactuar con ella, se invoca el método `onResume()`. En este estado el usuario puede interactuar con la aplicación.

Dentro de `onResume()`, se habilitan todas las funcionalidades que la actividad necesita para que el usuario pueda interactuar con la app, como:

- **Habilitar funcionalidades interactivas** (mostrar una vista previa de la cámara).
- **Actualizar elementos visuales** en tiempo real según la interacción del usuario.
  
En este punto, el usuario puede interactuar de inmediato con los elementos de la interfaz.

```kotlin
override fun onResume() {
    super.onResume()
    Log.i("CicloVida", "La actividad tiene el foco")
}
```


#### onPause()
El método `onPause()` se ejecuta cuando la actividad deja de estar en primer plano, pero sigue siendo visible, puede ser el paso previo a la finalización de la actividad o que la actividad deje de estar visible (**Tiempo de vida visible**). Varios motivos por el que se ejecuta este método:

- Un evento que interrumpe la ejecución de la app (Ej: Te llaman por teléfono).
- La apertura de una nueva actividad (semitransparente), como un dialogo (la actividad tiene que estar visible).

El método `onPause()` es corto, solo para liberar funcionalidades.

```kotlin
override fun onPause() {
    super.onPause()
    Log.i("CicloVida", "La actividad pierde el foco principal")
}
```


#### onStop()
Cuando la actividad deja de ser visible (por ejemplo, cuando otra actividad ocupa toda la pantalla), el método `onStop()` se invoca. Este es el paso previo a la finalización de la actividad, ya sea porque el usuario ha cambiado de pantalla o porque el sistema necesita liberar recursos.

Dentro de `onStop()`, debemos realizar tareas que detengan funciones no esenciales:

- **Pausar o detener funciones que no sean necesarias mientras la actividad no sea visible**  (animaciones o actualizaciones en tiempo real).
- **Guardar datos importantes en una base de datos** (Ej: usando Room o SQLite) para garantizar que no se pierdan cambios.

Aunque la actividad sigue en memoria, el sistema puede finalizarla en cualquier momento si necesita liberar recursos, por lo que debemos asegurarnos de guardar toda la información crítica.
Desde `onStop()`, la actividad puede regresar al primer plano si el usuario vuelve a interactuar con ella, lo que invocaría `onRestart()` y luego `onStart()`, o puede ser destruida si el sistema decide liberar los recursos, lo que invoca `onDestroy()`.

```kotlin
override fun onStop() {
    super.onStop()
    Log.i("CicloVida", "La actividad ya no es visible")
}
```


#### onDestroy()
El método `onDestroy()` se invoca cuando la actividad está a punto de ser destruida. Hay varias razones por las cuales esto puede ocurrir:

- La actividad está terminando debido a que se ha llamado al método `finish()` o porque el usuario ha presionado el botón de atrás.
- El sistema operativo destruye la actividad temporalmente debido a cambios en la configuración del dispositivo (cambio de idioma, rotación de pantalla o la entrada en modo multiventana en ciertos dispositivos). En este caso, el sistema puede crear una nueva instancia de la actividad inmediatamente, invocando nuevamente `onCreate()`.

```kotlin
override fun onDestroy() {
    super.onDestroy()
    Log.i("CicloVida", "La actividad se destruye")
}
```

  

>[!NOTE]
> <a href="https://github.com/estelaV9/PMDM/tree/master/Tema5_InterfaceGraficaII/Ejercicios_DentroTema/EjemploCicloVida">Ejercicio</a> sobre el ciclo de vida.
> Se manejan sus estados mediante los métodos `onCreate()`, onStart(), `onResume()`, `onPause()`, `onStop()`, y `onDestroy()` y se incluyen métodos para guardar el estado de la actividad y manejar la interacción con otros componentes (botones y vistas).
>
> Manejo de interacciones:
> - **Botón para navegar entr actividades**:
> ```kotlin
>  boton_segundaactividad.setOnClickListener {
>    val mi_intencion = Intent(this, SegundaActividad::class.java)
>    startActivity(mi_intencion)
> }
> ```
> 
> - **Guardar el estado de la interacción**: Se guara y se restaura el valor del contador y el estado de un `CheckBox` usando `onSaveInstanceState` y `onRestoreInstanceState`:
> ```kotlin
> if (estado != null) {
>    this.botonpulsado = estado.getBoolean("estado")
>    this.valor = estado.getInt("contador")
>    this.texto.text = this.valor.toString()
> }
> ```



