package com.app.projectedbsqlite.model

/**
 * Classe que representa la nostra taula SQL amb les propietats de la pel·lícula.
 * id, titol, any, director, valoració
 */
data class Pelicula(val id: Int, val titol: String, val any: Int, val director: String, val valoracio: Float) {
    // Constructor sense id per a noves pel·lícules
    constructor(titol: String, any: Int, director: String, valoracio: Float) : this(-1, titol, any, director, valoracio)
}