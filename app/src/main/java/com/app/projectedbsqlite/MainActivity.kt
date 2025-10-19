package com.app.projectedbsqlite

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.projectedbsqlite.data.BaseDeDades
import com.app.projectedbsqlite.model.Pelicula
import com.app.projectedbsqlite.utils.Constants

// Tag per als missatges de Log
private const val TAG = "PeliculesApp"

class MainActivity : ComponentActivity() {
    // Variable per emmagatzemar la instància de la base de dades
    private lateinit var db: BaseDeDades

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicialitzem la base de dades
        db = BaseDeDades(this)
        Log.d(TAG, "Base de dades inicialitzada")

        // Carreguem i mostrem les pel·lícules per Logcat
        carregarPeliculesAlLogcat()
    }

    /**
     * Funció que carrega les pel·lícules de la base de dades i les mostra al Logcat
     */
    fun carregarPeliculesAlLogcat() {
        Log.d(TAG, "Començant la càrrega de pel·lícules de la base de dades")

        val readableDb = db.readableDatabase
        val cursor = readableDb.query(
            Constants.TABLE_PELICULES,
            null,
            null,
            null,
            null,
            null,
            null
        )

        Log.d(TAG, "Consulta SQL executada. Nombre de resultats: ${cursor.count}")

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(Constants.COLUMN_ID))
                val titol = getString(getColumnIndexOrThrow(Constants.COLUMN_TITOL))
                val any = getInt(getColumnIndexOrThrow(Constants.COLUMN_ANY))
                val director = getString(getColumnIndexOrThrow(Constants.COLUMN_DIRECTOR))
                val valoracio = getFloat(getColumnIndexOrThrow(Constants.COLUMN_VALORACIO))

                val pelicula = Pelicula(id, titol, any, director, valoracio)

                // Mostrem cada pel·lícula al Logcat
                Log.i(
                    TAG,
                    "Pel·lícula trobada: ID=$id, Títol=$titol, Any=$any, Director=$director, Valoració=$valoracio"
                )
            }
        }

        cursor.close()
        Log.d(TAG, "Càrrega de pel·lícules finalitzada")
    }
}



/**
 * Funció que defineix el tema visual de l'aplicació
 * @param content Contingut que s'ha de mostrar amb aquest tema
 */
@Composable
fun ProjecteDBSQLiteTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        content = content
    )
}
