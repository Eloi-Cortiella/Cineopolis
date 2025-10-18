package com.app.projectedbsqlite.model

data class Pelicula(val id: Int, val titol: String, val any: Int, val director: String) {
    // Constructor sense id per a noves pel·lícules
    constructor(titol: String, any: Int, director: String) : this(-1, titol, any, director)
}