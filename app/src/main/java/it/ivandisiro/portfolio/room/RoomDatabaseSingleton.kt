package it.ivandisiro.portfolio.room

import android.content.Context
import androidx.room.Room

object RoomDatabaseSingleton {
    lateinit var db: AppDatabase;

    fun initDB(context: Context) {
        this.db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "porfolio-db"
        ).build()
    }
}