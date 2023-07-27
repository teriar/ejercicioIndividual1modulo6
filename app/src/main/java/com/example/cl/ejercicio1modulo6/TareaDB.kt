package com.example.cl.ejercicio1modulo6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea::class], version = 1)
abstract class tareaBaseDatos : RoomDatabase() {

 abstract fun getTareaDao(): TareaDao

 companion object {
  @Volatile
  private var INSTANCE: tareaBaseDatos? = null

  fun getDatabase(context: Context): tareaBaseDatos {
   val tempInstance = INSTANCE
   if (tempInstance != null) {
    return tempInstance
   }
   synchronized(this) {
    val instance = Room.databaseBuilder(
     context.applicationContext,
     tareaBaseDatos::class.java,
     "tarea_database"
    ).build()

    INSTANCE = instance
    return instance
   }
  }
 }
}