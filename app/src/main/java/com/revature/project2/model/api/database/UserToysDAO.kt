package com.revature.project2.model.api.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.revature.project2.model.api.alltoys.ToyItem

@Dao
interface UserToysDAO {

    @Query("SELECT * FROM usertoys")
    fun fetchAllCustomers(): List<ToyItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserToy(toy: ToyItem)

    @Query("DELETE FROM usertoys WHERE id=:id")
    suspend fun deleteUserToyById(id: Int)
}