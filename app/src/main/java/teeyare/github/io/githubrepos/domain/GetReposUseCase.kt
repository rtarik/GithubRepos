package teeyare.github.io.githubrepos.domain

import kotlinx.coroutines.*
import teeyare.github.io.githubrepos.data.GithubRepoRepository
import teeyare.github.io.githubrepos.framework.injection.IoDispatcher
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val repository: GithubRepoRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
    ):
    UseCase<Unit, List<GithubRepo>>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): List<GithubRepo> {
        return repository.getGithubRepositories()
    }
}