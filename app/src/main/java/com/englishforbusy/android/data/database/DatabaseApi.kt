package com.englishforbusy.android.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.data.model.UserModel
import kotlinx.coroutines.flow.Flow


@Dao
interface DatabaseApi {

    @Insert
    suspend fun insertUser(data: UserModel): Long

    @Insert
    suspend fun insertNutritionist(data: List<NutritionistModel>): List<Long>


    @Query("SELECT* FROM nutritionist")
    fun getNutritionists(): Flow<List<NutritionistModel>>


    @Query("SELECT* FROM user LIMIT 1")
    fun getUser(): Flow<UserModel>

}