package com.example.maestro.di

import android.app.Application
import androidx.room.Room
import com.example.maestro.data.local.NewsDao
import com.example.maestro.data.local.NewsDatabase
import com.example.maestro.data.local.NewsTypeConvertor
import com.example.maestro.data.manager.LocalUserManagerImpl
import com.example.maestro.data.manager.remote.NewsApi
import com.example.maestro.data.repository.NewsRepositoryImpl
import com.example.maestro.domain.LocalUserManager
import com.example.maestro.domain.repository.NewsRepository
import com.example.maestro.domain.usecases.appentry.AppEntryUseCase
import com.example.maestro.domain.usecases.appentry.ReadAppEntry
import com.example.maestro.domain.usecases.appentry.SaveAppEntry
import com.example.maestro.domain.usecases.news.DeleteArticle
import com.example.maestro.domain.usecases.news.GetNews
import com.example.maestro.domain.usecases.news.NewsUseCase
import com.example.maestro.domain.usecases.news.SearchNews
import com.example.maestro.domain.usecases.news.SelectArticle
import com.example.maestro.domain.usecases.news.SelectedArticle
import com.example.maestro.domain.usecases.news.UpsetArticle
import com.example.maestro.utils.Constants.BASE_URL
import com.example.maestro.utils.Constants.NEWS_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ):LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
    @Provides
    @Singleton

    fun providesRetrofit():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao

    ):NewsRepository = NewsRepositoryImpl(newsApi,newsDao)

    @Provides
    @Singleton

    fun provideNewsUseCase(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ):NewsUseCase{
        return NewsUseCase(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            upsetArticle = UpsetArticle(newsRepository),
            selectArticle = SelectArticle(newsRepository),
            selectedArticle = SelectedArticle(newsRepository)

        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabse(application: Application):NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name =NEWS_DB
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun proovideNewsDao(
        newsDatabase: NewsDatabase
    ):NewsDao = newsDatabase.newsDao
}