package me.cristalliz.ash.githubjobs.ui.fragments.positiondetails

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter
import android.net.Uri
import com.squareup.picasso.Picasso
import me.cristalliz.ash.githubjobs.data.LocalRepository.LocalDataSource
import javax.inject.Inject
import android.text.Html
import android.widget.ImageView


class PositionDetailsViewModel @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val picasso: Picasso
) : ViewModel() {
    fun position() = localDataSource.getDetailedPotition().data
    fun description() = Html.fromHtml(position()?.description, Html.FROM_HTML_MODE_COMPACT).toString()
}
