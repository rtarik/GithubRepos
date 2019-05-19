package teeyare.github.io.githubrepos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import teeyare.github.io.githubrepos.framework.FakeRemoteSource
import teeyare.github.io.githubrepos.data.GithubRepoRepository
import teeyare.github.io.githubrepos.framework.InMemoryPersistenceSource
import teeyare.github.io.githubrepos.domain.GetReposUseCase
import teeyare.github.io.githubrepos.domain.GithubRepo

class GithubRepoListViewModel : ViewModel() {

    var showLoading = MutableLiveData<Boolean>()
    var showResult = MutableLiveData<List<GithubRepo>>()

    private val fakeRemoteSource = FakeRemoteSource()
    private val inMemoryPersistenceSource = InMemoryPersistenceSource()
    val useCase: GetReposUseCase = GetReposUseCase(GithubRepoRepository(
        inMemoryPersistenceSource, fakeRemoteSource
    ))

    fun init() {
        showLoading.value = true
        viewModelScope.launch {
            showResult.value = useCase.getReposAsync().await()
        }
    }
}