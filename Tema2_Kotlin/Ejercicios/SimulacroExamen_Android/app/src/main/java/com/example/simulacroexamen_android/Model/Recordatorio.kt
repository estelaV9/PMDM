package Model

import android.content.Context

interface Recordatorio {
    fun programarRecordatorio(context: Context):Unit
    fun cancelarRecordatorio(context: Context):Unit
}