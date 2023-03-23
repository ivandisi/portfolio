package it.ivandisiro.portfolio.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.room.RoomDatabase
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.networking.Networking
import it.ivandisiro.portfolio.room.RoomDatabaseSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

object ProfileRepository{
    val me = MutableLiveData<Me?>();

    suspend fun initData() {
        withContext(Dispatchers.IO) {
            var test = RoomDatabaseSingleton.db.profileDao().getAll();
            me.postValue(test[0]);
        }
    }

    suspend fun refreshProfile() {
        withContext(Dispatchers.IO) {
            try {
                val meUpdated = Networking().getProfileSync();
                if (meUpdated != null) {
                    me.postValue(meUpdated);
                    RoomDatabaseSingleton.db.profileDao().delete();
                    RoomDatabaseSingleton.db.profileDao().insertAll(meUpdated);
                } else {
                    Log.e(ProfileRepository.javaClass.canonicalName, "dberror");
                }
            } catch (e: Exception) {
                Log.e(ProfileRepository.javaClass.canonicalName, ""+ e?.message);
            }

        }
    }
}