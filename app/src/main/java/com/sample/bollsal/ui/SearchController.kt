package com.sample.bollsal.ui

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.sample.bollsal.widget.searchKeywordItemView

class SearchController() : EpoxyController() {

  private val keywordList: List<String> = listOf("a", "a", "a", "a", "a", "a", "a", "a")

  override fun buildModels() {

    keywordList.forEachIndexed { index, s ->
      searchKeywordItemView {
        keyword("ddd")
        callback { }
        id(index)
        onVisibilityChanged { model, view, percentVisibleHeight, percentVisibleWidth, heightVisible, widthVisible ->
          Log.d("bollsal", "onVisibilityChanged: ")
        }
      }
    }
  }
}
