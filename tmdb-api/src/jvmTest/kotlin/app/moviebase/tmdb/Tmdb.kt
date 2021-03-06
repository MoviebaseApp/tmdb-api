package app.moviebase.tmdb

import java.io.FileInputStream
import java.nio.file.Paths
import java.util.*

val properties by lazy {
    Properties().apply {
        val parent = Paths.get(System.getProperty("user.dir")).parent
        FileInputStream("$parent/local.properties").use {
            load(it)
        }
    }
}

fun buildTmdb4(): Tmdb4 {
    val key = properties.getProperty("TMDB_API_KEY")
    print("TMDB Key: $key")
    return Tmdb4(key)
}

fun buildTmdb3(): Tmdb3 {
    val key = properties.getProperty("TMDB_API_KEY")
    print("TMDB Key: $key")
    return Tmdb3(key)
}
