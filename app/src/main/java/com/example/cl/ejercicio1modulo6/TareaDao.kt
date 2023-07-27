package com.example.cl.ejercicio1modulo6

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea:Tarea)
}