package com.sample.bollsal.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.airbnb.epoxy.*
import com.sample.bollsal.R
import com.sample.bollsal.databinding.ItemSearchKeywordBinding
import com.sample.bollsal.extension.convertDpToPx

/**
 * recyclerView에서 사용할때에서 viewHolder를 따로 작성하지 않고 ModelView를 생성하여 사용
 * -> 다른영역에서 별도의 커스텀뷰 형태로도 사용가능하여 확장성이 좋아짐
 */
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SearchKeywordItemView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val binding: ItemSearchKeywordBinding by viewBinding(ItemSearchKeywordBinding::bind)

  init {
    View.inflate(context, R.layout.item_search_keyword, this)
    setBackgroundResource(R.drawable.bg)
    setPadding(8.convertDpToPx())
  }

  @TextProp
  fun setKeyword(s: CharSequence?) {
    binding.keyword.text = s
  }

  var callback: (() -> Unit)? = null
    @CallbackProp set

  @OnVisibilityStateChanged
  fun visibleCheck(@VisibilityState.Visibility visibilityState: Int) {

  }
}

