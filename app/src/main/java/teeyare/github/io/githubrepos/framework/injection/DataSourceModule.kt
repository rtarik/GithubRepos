package teeyare.github.io.githubrepos.framework.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import teeyare.github.io.githubrepos.data.GithubRepoPersistenceSource
import teeyare.github.io.githubrepos.data.GithubRepoRemoteSource
import teeyare.github.io.githubrepos.framework.FakeRemoteSource
import teeyare.github.io.githubrepos.framework.InMemoryPersistenceSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindPersistenceSource(implementation: InMemoryPersistenceSource): GithubRepoPersistenceSource

    @Binds
    abstract fun bindRemoteSource(implementation: FakeRemoteSource): GithubRepoRemoteSource
}