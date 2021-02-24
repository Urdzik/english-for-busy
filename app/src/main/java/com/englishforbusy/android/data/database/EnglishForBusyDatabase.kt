package com.englishforbusy.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.data.model.UserModel


@Database(
    entities = [
        UserModel::class, NutritionistModel::class
               ],
    version = 1,
    exportSchema = false
)

abstract class EnglishForBusyDatabase : RoomDatabase() {

    abstract fun dao(): DatabaseApi

    companion object {
        const val DATABASE_NAME = "db"
    }
}