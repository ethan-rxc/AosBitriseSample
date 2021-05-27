package com.sample.bollsal.ui

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.*
import com.sample.bollsal.R
import com.sample.bollsal.databinding.FragmentSearchBinding
import com.sample.bollsal.extension.hideKeyboard
import com.sample.bollsal.widget.SearchKeywordItemViewModel_
import kotlinx.coroutines.delay

/**
 * 검색 페이지
 * 시나리오
 * 1. 진입시 로컬에 저장된 or 서버에 저장된 키≤워드를 가지고와서 보여준다.
 * 2. 검색을 하면 해당 키워드에 맞는 결과를 보여준다.
 * 3. 검색결과를 누르면 토스트
 * 4. 검색결과가 없으면 빈결과 페이지
 *
 */

class SearchFragment : Fragment(), MavericksView, EpoxyRecyclerView.ModelBuilderCallback {

  private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
  private val viewModel: SearchViewModel by fragmentViewModel()
  private val controller: SearchController by lazy { SearchController() }
  private val keywordList: List<String> = listOf("abc", "abc", "abc", "a", "a", "abc", "a", "abc")

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_search, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initViews()
    loadPreKeyword()
    initRecyclerView()
  }

  private fun initViews() {
    with(binding) {
      searchInput.setOnKeyListener { _, keyCode, event ->
        if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
          searchInput.hideKeyboard(context)
          if (searchInput.text.trim().isNotEmpty()) {
            viewModel.search()
          }
          false
        } else {
          false
        }
      }

      //searchIcon.setOnClickListener { viewModel.search() }
      searchIcon.setOnClickListener {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        findNavController().navigate(R.id.action_global_globalActionFragment)
      }
    }

    /**
     * invalidate == viewModel onEach
     * 특정 state만 체크도 가능
     *
     */
//    viewModel.onEach {}
//    viewModel.onEach(SearchState::response) {}
//    viewModel.onEach(SearchState::currentStep) {}


    viewModel.onAsync(SearchState::response,
      UniqueOnly(""),   // 상태가 변경이 된 경우에만 업데이트 수행
      onFail = { e -> Log.e("bollsal", "onFail: ${e.message}") },
      onSuccess = { response ->
        binding.loadingProgress.isVisible = true
        delay(2000)
        binding.loadingProgress.isVisible = false

        controller.requestModelBuild()
      })
  }

  override fun invalidate() = withState(viewModel) {
  }

  private fun loadPreKeyword() {
    // 이전 검색어 & 인기검색어 쿼리 API
    // viewModel.loadPopularKeywords()
  }

  private fun initRecyclerView() {
    binding.recyclerView.apply {
      //layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
      //adapter = controller.adapter
      //setControllerAndBuildModels(controller)
      //setController(controller)
      buildModelsWith(this@SearchFragment)
      setItemSpacingDp(4)
    }
  }

  /**
   * EpoxyRecyclerView.ModelBuilderCallback을 상속받아 fragment에서 바로 정의하여 사용하면
   * 데이터에 대한 접도 용이한듯
   */
  override fun buildModels(controller: EpoxyController) {
    val carouselList = mutableListOf<SearchKeywordItemViewModel_>()
    keywordList.forEachIndexed { index, s ->
      carouselList.add(
        SearchKeywordItemViewModel_()
          .keyword("kk $index")
          .callback { }
          .id(index)
      )
      SearchKeywordItemViewModel_()
        .keyword("kk $index")
        .callback { }
        .id(index)
        .addTo(controller)
    }
    CarouselModel_()
      .id("carousel")
      .numViewsToShowOnScreen(1.3f)
      .models(carouselList)
      .addTo(controller)
  }



}
