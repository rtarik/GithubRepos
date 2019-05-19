package teeyare.github.io.githubrepos.domain

import teeyare.github.io.githubrepos.model.GithubRepoRepository
import teeyare.github.io.githubrepos.presentation.GithubRepoViewModel

class GithubRepoInteractor(private val repository: GithubRepoRepository): GithubRepoUseCases {
    override fun getGithubRepoBy(page: Int): List<GithubRepoViewModel> {
        return repository.getRepoList()
            .value
            ?.map { GithubRepoViewModel() } ?: listOf()
    }
}