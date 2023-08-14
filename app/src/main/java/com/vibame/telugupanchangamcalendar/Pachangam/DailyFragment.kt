package com.vibame.telugupanchangamcalendar.Pachangam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vibame.telugupanchangamcalendar.databinding.FragmentDailyBinding
import java.text.SimpleDateFormat
import java.util.*


class DailyFragment : Fragment() {


    private var position: Int = -1
    lateinit var binding: FragmentDailyBinding

    var dateString: String? = null
    var calendar: Calendar? = null
    var targetCalendar: Calendar? = null
    var startCalendar:java.util.Calendar? = null


    companion object {
        private const val ARG_POSITION = "position"

        fun newInstance(position: Int): DailyFragment {
            val fragment = DailyFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }




    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arguments?.let {
            position = it.getInt(ARG_POSITION)
        }
        // Inflate the layout for this fragment
        binding = FragmentDailyBinding.inflate(inflater, container, false)


      //  binding.tvDate.text = "Page $position"


        targetCalendar = Calendar.getInstance()
        targetCalendar!!.set(Calendar.YEAR, 2024)
        targetCalendar!!.set(Calendar.MONTH, Calendar.APRIL)
        targetCalendar!!.set(Calendar.DAY_OF_MONTH, 9)
        calendar = Calendar.getInstance()
        updateUI(calendar!!.getTime())


        return binding.root

    }


    private fun updateUI(date: Date) {
        // Format the date as a string
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        dateString = dateFormat.format(date)

        binding.tvDate.setText(dateString.toString())
//        tvDate1.setText(dateString.toString())
//        val Date = dateFormat.format(date)
//        panchangamlist(DailyPanchangamActivity.convertDateFormat(Date))
//        arrowleft.setEnabled(true)
//        ivArrowLeft.setEnabled(true)
    }




}