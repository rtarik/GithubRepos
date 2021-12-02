package teeyare.github.io.githubrepos.framework.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import teeyare.github.io.githubrepos.framework.GithubRepoService
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        val builder = OkHttpClient().newBuilder().apply {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            addInterceptor(loggingInterceptor)
        }
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideService(retrofit: Retrofit): GithubRepoService = retrofit.create(
        GithubRepoService::class.java
    )
}