package com.example.to_dolist

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Database
import androidx.room.Room
import com.example.to_dolist.databinding.FragmentAddnoteBinding
import java.util.Calendar


class AddNoteFragment : Fragment() {
    lateinit var  binding:FragmentAddnoteBinding
       var showTime: String?=null
     var  showDate: String?=null
    lateinit var Database: NoteDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddnoteBinding.inflate(inflater,container,false)

        // 1st step->  picADate() =if we want to show date  automatically
        // 2nd step->  picATime() = if we want to show date  automatically

         Database=Room.databaseBuilder(requireActivity(),NoteDatabase::class.java,"Note_Database")
             .allowMainThreadQueries().build()
        binding.dateBtn.setOnClickListener {
            picADate()
        }
        binding.timeBtn.setOnClickListener{
            picATime()
        }
        binding.submitBtn.setOnClickListener {
            val tittleStr =binding.EditTv.text.toString()
            val timeStr=showTime ?:"00:00"
            val dateStr=showDate ?:"00/00/0000"
            val note=Note(title = tittleStr, time = timeStr, date = dateStr)
            Database.getNoteDao().insertData(note)
            findNavController().navigate(R.id.action_addnoteFragment_to_homeFragment)
        }

        return binding.root
    }


    @SuppressLint("SuspiciousIndentation")
    private fun picATime() {
       val calender=Calendar.getInstance()
        val munite=calender.get(Calendar.MINUTE)
        val hour = calender.get(Calendar.HOUR_OF_DAY)

      val ShowTime= TimePickerDialog(requireActivity(),TimePickerDialog.OnTimeSetListener{view,hourOfDay,minute->
             showTime="$hour:$minute"
           binding.timeBtn.text=showTime
        },hour,munite,false)
        ShowTime.show()


    }


    @SuppressLint("SuspiciousIndentation")
    private fun picADate() {
        val calender= Calendar.getInstance()
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val month = calender.get(Calendar.MONTH)
        val year = calender.get(Calendar.YEAR)

     val showDatePicker = DatePickerDialog(requireActivity(),DatePickerDialog.OnDateSetListener{view,Year,month,dayOfMonth->
             showDate="$year/${month+1}/$day"
          binding.dateBtn.text=showDate

      },year,month,day)
        showDatePicker.show()

    }


}