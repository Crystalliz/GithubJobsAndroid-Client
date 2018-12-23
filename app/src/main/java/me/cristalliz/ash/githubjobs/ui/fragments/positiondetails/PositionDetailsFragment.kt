package me.cristalliz.ash.githubjobs.ui.fragments.positiondetails

import android.databinding.DataBindingUtil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import me.cristalliz.ash.githubjobs.R
import me.cristalliz.ash.githubjobs.databinding.PositionDetailsFragmentBinding
import javax.inject.Inject

class PositionDetailsFragment : DaggerFragment() {

    companion object {
        fun newInstance() = PositionDetailsFragment()
    }

    @Inject
    lateinit var viewModel: PositionDetailsViewModel

    private lateinit var binding: PositionDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<PositionDetailsFragmentBinding>(
        inflater, R.layout.position_details_fragment, container, false
    ).also {
        binding = it
        binding.model = viewModel
    }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
