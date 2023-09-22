package com.example.catfactsfriday.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catfactsfriday.R

import com.example.catfactsfriday.data.datamodels.FactsItem
import com.example.catfactsfriday.databinding.ListItemBinding
import com.example.catfactsfriday.ui.ItemViewModel

class ItemAdapter (
    private val dataset: List<FactsItem>,
    val viewModel: ItemViewModel,
    ) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return dataset.size
        }

        @SuppressLint("ResourceType")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = dataset[position]

            holder.binding.textViewCV.setText(item.fact)

            // TODO: Alf übergeben 
            // lade das Bild mithilfe der URI in die ImageView und runde die Ecken ab
//            holder.binding.imageViewCV.load(imgUri) {
//                error(R.drawable.baseline_report_gmailerrorred_24)
//                transformations(RoundedCornersTransformation(10f))
//            }

/*            holder.binding.ItemCV.setOnClickListener {
                holder.binding.root.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(position))
            }*/
        }
    }