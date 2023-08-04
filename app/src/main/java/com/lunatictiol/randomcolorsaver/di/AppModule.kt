package com.lunatictiol.randomcolorsaver.di

import android.app.Application
import androidx.room.Room
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.data_source.RandomColorDatabase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.repository.RandomColorRepositoryImpl
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository.RandomColorRepository
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases.AddRandomColorUseCase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases.GetColorListUseCase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases.SaveToFireBaseUseCase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesDataBase(app: Application):RandomColorDatabase{
        return Room.databaseBuilder(
            app,
            RandomColorDatabase::class.java,
            RandomColorDatabase.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun providesRepository(db:RandomColorDatabase):RandomColorRepository{
        return RandomColorRepositoryImpl(db.randomColorDao)
    }
    @Provides
    @Singleton
    fun providesUseCases(repository: RandomColorRepository):UseCases{
        return UseCases(
            getColorListUseCase = GetColorListUseCase(repository),
            addRandomColorUseCase = AddRandomColorUseCase(repository),
            saveToFireBaseUseCase = SaveToFireBaseUseCase(repository)
        )
    }

}