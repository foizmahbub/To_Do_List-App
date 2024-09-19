package com.example.to_dolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.to_dolist.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
      lateinit var binding: FragmentHomeBinding
    lateinit var Database: NoteDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        Database= Room.databaseBuilder(requireActivity(),NoteDatabase::class.java,"Note_Database")
            .allowMainThreadQueries().build()
    var notes:List<Note> =Database.getNoteDao().getAllData()
        var adapter=NoteAdapter()
        adapter.submitList(notes)
        binding.RecyclerView.adapter= adapter
            
        

binding.AddBtn.setOnClickListener{
    findNavController().navigate(R.id.action_homeFragment_to_addnoteFragment)
}


        return binding.root
    }


}