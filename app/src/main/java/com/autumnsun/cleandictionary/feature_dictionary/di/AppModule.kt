package com.autumnsun.cleandictionary.feature_dictionary.di

import android.content.Context
import androidx.room.Room
import com.autumnsun.cleandictionary.feature_dictionary.data.local.Converters
import com.autumnsun.cleandictionary.feature_dictionary.data.local.WordInfoDatabase
import com.autumnsun.cleandictionary.feature_dictionary.data.remote.DictionaryApi
import com.autumnsun.cleandictionary.feature_dictionary.data.remote.DictionaryApi.Companion.BASE_URL
import com.autumnsun.cleandictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.autumnsun.cleandictionary.feature_dictionary.data.util.GsonParser
import com.autumnsun.cleandictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.autumnsun.cleandictionary.feature_dictionary.domain.usecase.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(
        @ApplicationContext context: Context
    ): WordInfoDatabase {
        return Room.databaseBuilder(
            context, WordInfoDatabase::class.java, WordInfoDatabase.DB_NAME
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}