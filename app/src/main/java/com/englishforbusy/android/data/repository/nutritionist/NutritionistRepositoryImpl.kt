package com.android.holyeat.data.repository.nutritionist

import com.englishforbusy.android.data.database.DatabaseApi
import com.android.holyeat.data.model.NutritionistModel
import com.englishforbusy.android.data.repository.nutritionist.NutritionistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NutritionistRepositoryImpl @Inject constructor(private val databaseApi: DatabaseApi) :
    NutritionistRepository {
    override suspend fun getNutritionists(): Flow<List<NutritionistModel>> {
        return databaseApi.getNutritionists()
    }


}