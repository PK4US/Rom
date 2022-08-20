package com.pk4u.listview.baseAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pk4u.listview.databinding.ItemCharacterBinding

typealias OnDeletePressedListener = (Character) -> Unit

class CharacterAdapter(
    private val characters:List<Character>,
    private val onDeletePressedListener:OnDeletePressedListener
    ):BaseAdapter(),View.OnClickListener {

    override fun getItem(position: Int): Character {
       return characters[position]
    }

    override fun getItemId(position: Int): Long {
        return characters[position].id
    }

    override fun getCount(): Int {
        return characters.size
    }

    override fun getView(position: Int, convertView: View?, parant: ViewGroup?): View {
        val binding =
            convertView?.tag as ItemCharacterBinding? ?:createBinding(parant!!.context)
        val character = getItem(position)

        binding.titleTextView.text = character.name
        binding.deleteImageView.tag = character
        binding.deleteImageView.visibility = if (character.icCustom) View.VISIBLE else View.GONE

        return binding.root
    }

    override fun onClick(v: View?) {
        val character = v?.tag as Character
        onDeletePressedListener.invoke(character)
    }

    private fun createBinding(context: Context): ItemCharacterBinding {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(context))
        binding.deleteImageView.setOnClickListener(this)
        binding.root.tag = binding
        return binding
    }
}