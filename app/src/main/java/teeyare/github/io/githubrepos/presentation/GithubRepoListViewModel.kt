package teeyare.github.io.githubrepos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import teeyare.github.io.githubrepos.domain.GetReposUseCase
import teeyare.github.io.githubrepos.domain.GithubRepo
import teeyare.github.io.githubrepos.framework.FakeRemoteSource
import teeyare.github.io.githubrepos.framework.InMemoryPersistenceSource
import javax.inject.Inject

@HiltViewModel
class GithubRepoListViewModel @Inject constructor(private val useCase: GetReposUseCase) : ViewModel() {

    var showLoading = MutableLiveData<Boolean>()
    var showResult = MutableLiveData<List<GithubRepo>>()

    private val fakeRemoteSource = FakeRemoteSource()
    private val inMemoryPersistenceSource = InMemoryPersistenceSource()

    fun init() {
        showLoading.value = true
        viewModelScope.launch {
            showResult.value = useCase.getReposAsync().await()
        }
    }
}