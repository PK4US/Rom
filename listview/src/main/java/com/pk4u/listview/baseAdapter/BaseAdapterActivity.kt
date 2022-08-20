package com.pk4u.listview.baseAdapter

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pk4u.listview.R
import com.pk4u.listview.databinding.ActivityBaseAdapterBinding
import com.pk4u.listview.databinding.DialogAddCharacterBinding
import kotlin.random.Random.Default.nextLong

class BaseAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseAdapterBinding

    private val data = mutableListOf(
        Character(id = 1, name = "Person1", icCustom = false),
        Character(id = 2, name = "Person2", icCustom = false),
        Character(id = 3, name = "Person3", icCustom = false),
        Character(id = 4, name = "Person4", icCustom = false),
        Character(id = 5, name = "Person5", icCustom = false),
        Character(id = 6, name = "Person6", icCustom = false),
        Character(id = 7, name = "Person7", icCustom = false),
    )

    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityBaseAdapterBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setupList()
        binding.addButton.setOnClickListener { onAddPressed() }
    }

    private fun setupList() {
        adapter = CharacterAdapter(data) {
            deleteCharacter(it)
        }
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            showCharacterInfo(adapter.getItem(position))
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
            id = nextLong() ,
            name = name,
            icCustom = true
        )
        data.add(character)
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("StringFormatInvalid")
    private fun showCharacterInfo(character: Character) {
        val dialog = AlertDialog.Builder(this)
            .setTitle(character.name)
            .setMessage(getString(R.string.character_info, character.name, character.id))
            .setPositiveButton(R.string.ok) { _, _ -> }
            .create()
        dialog.show()
    }

    private fun deleteCharacter(character: Character) {
        val listener = DialogInterface.OnClickListener { dialog, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                data.remove(character)
                adapter.notifyDataSetChanged()
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
}