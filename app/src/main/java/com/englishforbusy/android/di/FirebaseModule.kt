package com.englishforbusy.android.di

import com.android.holyeat.data.firebase.AuthFirebaseManager
import com.englishforbusy.android.data.firebase.AuthFirebaseManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

    @Provides
    fun provideFirebaseAuth(): AuthFirebaseManager {
        return AuthFirebaseManagerImpl()
    }
}