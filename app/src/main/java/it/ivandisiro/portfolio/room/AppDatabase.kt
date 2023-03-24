package it.ivandisiro.portfolio.room

import androidx.room.Database
import androidx.room.RoomDatabase
import it.ivandisiro.portfolio.model.Me

@Database(entities = [Me::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao;
}