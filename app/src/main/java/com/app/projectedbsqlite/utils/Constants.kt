package com.app.projectedbsqlite.utils

/**
 * Classe objecte que utilitzem per guardar les constants de la taula, les constants representen les columnes de la taula.
 * Dintre de la taula tenim les columnes: DATABASE_NAME (nom de la base de dades), DATABASE_VERSION (versió de la base de dades),
 * TABLE_PELICULES (el nom de la taula), COLUM_ID (id de la taula), COLUMN_TITOL (titol de la taula), COLUMN_ANY (any de la pel·lícula),
 * COLUMN_DIRECTOR (nom del director), COLUMN_VALORACIO (valoració de la pel·lícula).
 */
object Constants {
    const val DATABASE_NAME = "PeliculesDB"
    const val DATABASE_VERSION = 1

    const val TABLE_PELICULES = "Pelicules"
    const val COLUMN_ID = "id"
    const val COLUMN_TITOL = "titol"
    const val COLUMN_ANY = "any"
    const val COLUMN_DIRECTOR = "director"
    const val COLUM_VALORACIO = "valoracio"
}