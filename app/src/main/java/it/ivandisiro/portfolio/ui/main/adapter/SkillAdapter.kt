package it.ivandisiro.portfolio.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.ivandisiro.portfolio.databinding.ViewSkillAdapterBinding
import it.ivandisiro.portfolio.model.Skill

class SkillAdapter : RecyclerView.Adapter<MainViewHolder>() {
        var skills = mutableListOf<Skill>();

        @SuppressLint("NotifyDataSetChanged")
        fun setSkillsList(skills: List<Skill>) {
            this.skills = skills.toMutableList();
            notifyDataSetChanged();
        }

        @NonNull
        override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MainViewHolder =
            MainViewHolder(ViewSkillAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false));

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.apply {
                bind(skills[position]);
            }
        }

        override fun getItemCount(): Int {
            return skills.size;
        }

        companion object {
            @JvmStatic
            @BindingAdapter("loadImage")
            fun loadImage(thumbs: ImageView, url: String) {
                Glide.with(thumbs)
                    .load(url)
                    .circleCrop()
                    .into(thumbs);
            }
        }
    }

class MainViewHolder(val binding: ViewSkillAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(skill: Skill) {
        binding.skill= skill;
    }
}
