package com.semyong.scalabletask.presentation.fragments.detailsfragment

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.semyong.scalabletask.data.entities.OfficialLinks
import com.semyong.scalabletask.databinding.FragmentHomedetailsBinding
import com.semyong.scalabletask.presentation.fragments.BaseFragment
import com.semyong.scalabletask.presentation.helpers.DateXAxisFormatter
import com.semyong.scalabletask.presentation.helpers.UIHelpers.Companion.generateLink
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.math.BigDecimal


class HomeListDetailsFragment : BaseFragment() {
    private val viewModel: HomeListDetailsViewModel by viewModel()
    private lateinit var binding: FragmentHomedetailsBinding

    //    Navigation.findNavController(fragment_detail_title).popBackStack()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomedetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewMOodel()
        arguments?.let {
            HomeListDetailsFragmentArgs.fromBundle(it).currencyItem.let {
                it.symbol?.let { viewModel.getCurrency(it) }
                it.slug?.let { viewModel.getCurrencyTimeSeries(it) }
            }
        }
    }

    private fun observeViewMOodel() {
        viewModel.mCurrency.observe(viewLifecycleOwner, Observer { currencyItem ->
            val overview = currencyItem.profile?.general?.overview
            binding.fragmentHomedetailsProjectDetails.apply {
                setClickable(true)
                setMovementMethod(LinkMovementMethod.getInstance())
            }
            overview?.let {
                binding.fragmentHomedetailsProjectDetails.text = Html.fromHtml(it.projectDetails)
                binding.fragmentHomedetailsTagline.text = it.tagline
                showLinks(it.officialLinks)
            }
        })

        viewModel.mCurrencyTimeSeries.observe(viewLifecycleOwner, Observer { currencyItem ->
            val entries =
                currencyItem.valuesList?.map {
                    Entry(
                        BigDecimal.valueOf(it[0]).toPlainString().toFloat(),
                        it[3].toFloat()
                    )
                }
            val setComp1 = LineDataSet(entries, "Price/Days")
            setComp1.axisDependency = AxisDependency.LEFT
            entries?.let { initChart(LineData(setComp1)) }
        })
    }

    private fun showLinks(officialLinks: List<OfficialLinks>?) {
        officialLinks?.let {
            for (officialLink in it) {
                val linkTxt = TextView(context)
                linkTxt.apply {
                    setClickable(true)
                    setMovementMethod(LinkMovementMethod.getInstance())
                    text = Html.fromHtml(generateLink(officialLink.name, officialLink.link))
                }
                val layoutParams =
                    binding.fragmentHomedetailsLinksContainer.layoutParams as FrameLayout.LayoutParams
                layoutParams.setMargins(0, 0, 16, 0)
                binding.fragmentHomedetailsLinksContainer.addView(linkTxt, layoutParams)
            }
        }
    }

    private fun initChart(lineData: LineData) {
        with(binding.chartView) {
            xAxis.setValueFormatter(IndexAxisValueFormatter());
            val xAxisFormatter = DateXAxisFormatter()
            xAxis.valueFormatter = xAxisFormatter
        }
        binding.chartView.data = lineData
        binding.chartView.invalidate()
    }

}
