package it.ivandisiro.portfolio.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import it.ivandisiro.portfolio.model.Me

@Dao
interface ProfileDao {
    @Query("SELECT * FROM me")
    fun getAll(): List<Me>;

    @Insert
    fun insertAll(profile: Me);

    @Delete
    fun delete(profile: Me);

}