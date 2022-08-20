package com.pk4u.listview

import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pk4u.listview.databinding.ActivityArrayAdapterBinding
import com.pk4u.listview.databinding.DialogAddCharacterBinding
import java.util.*


class ArrayAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArrayAdapterBinding
    private lateinit var adapter: ArrayAdapter<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityArrayAdapterBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setupListWithArrayAdapter()
        binding.addButton.setOnClickListener { onAddPressed() }
    }


    private fun setupListWithArrayAdapter() {
        val data = mutableListOf(
            Character(id = UUID.randomUUID().toString(), name = "Andy"),
            Character(id = UUID.randomUUID().toString(), name = "Sergey"),
            Character(id = UUID.randomUUID().toString(), name = "Daniel"),
            Character(id = UUID.randomUUID().toString(), name = "Eugene"),
            Character(id = UUID.randomUUID().toString(), name = "Maxim"),
        )

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            data
        )

        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener{ parent,view,position,id ->
            deleteCharacter(adapter.getItem(position)!!)
        }
    }

    private fun onAddPressed() {
        val dialogBinding = DialogAddCharacterBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle(R.string.create_character)
            .setView(dialogBinding.root)
            .setPositiveButton(R.string.add) { dialog, which ->
                val name = dialogBinding.characterNameEditText.text.toString()
                if (name.isNotBlank()) {
                    createCharacter(name)
                }
            }
            .create()
        dialog.show()
    }

    private fun createCharacter(name: String) {
        val character = Character(
            id = UUID.randomUUID().toString(),
            name = name
        )
        adapter.add(character)
    }

    private fun deleteCharacter(character: Character) {
        val listener = DialogInterface.OnClickListener { dialog, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                adapter.remove(character)
            }
        }
        val dialog = AlertDialog.Builder(this)
            .setTitle(R.string.delete_character)
            .setMessage(R.string.delete_message)
            .setPositiveButton("Delete", listener)
            .setNegativeButton("Cancel", listener)
            .create()
        dialog.show()
    }


    class Character(val id: String, val name:String) {
        override fun toString(): String {
            return name
        }
    }
}