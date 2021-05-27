package com.sample.bollsal.ui

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sample.bollsal.R

/**
 * viewHolder역할을 하는 EpoxyModel
 * recyclerView의 item들도 ModelView로 사용할것이기 때문에 사용빈도는 떨어지게 되거나 없을듯. 참고용
 */
@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_search_keyword)
abstract class SearchKeywordModel : EpoxyModelWithHolder<SearchKeywordModel.SearchkeywordHolder>() {

  @EpoxyAttribute
  var keyword: String = ""

  override fun bind(holder: SearchkeywordHolder) {
    holder.keywordView.text = "bollsal"
  }

  class SearchkeywordHolder : EpoxyHolder() {
    lateinit var keywordView: TextView

    override fun bindView(itemView: View) {
      keywordView = itemView.findViewById<TextView>(R.id.keyword)
    }
  }
}

