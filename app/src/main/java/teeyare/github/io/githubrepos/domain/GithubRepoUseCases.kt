package teeyare.github.io.githubrepos.domain

import teeyare.github.io.githubrepos.presentation.GithubRepoViewModel

interface GithubRepoUseCases {
    fun getGithubRepoBy(page: Int): List<GithubRepoViewModel>
}