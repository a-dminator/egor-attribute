package io.adev.egor_attribute

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        class CarDrive(
                val name: String,
                val imageResource: Int)

        val carDrives = listOf(
                CarDrive(
                        name = "Pirelly",
                        imageResource = R.drawable.image),
                CarDrive(
                        name = "Yokohama",
                        imageResource = R.drawable.image),
                CarDrive(
                        name = "Mishlen",
                        imageResource = R.drawable.image))

        recyclerView {
            class CarDriveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val imageView = view.find<ImageView>(R.id.imageId)
                val textView  = view.find<TextView>(R.id.textId)
                fun bind(carDrive: CarDrive) {
                    textView.text = carDrive.name
                    imageView.imageResource = carDrive.imageResource
                }
            }
            adapter = object : RecyclerView.Adapter<CarDriveViewHolder>() {
                override fun onBindViewHolder(holder: CarDriveViewHolder, position: Int) = run {
                    val carDrive = carDrives[position]
                    holder.bind(carDrive)
                }
                override fun getItemCount() = carDrives.size
                override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = run {
                    val ui = UI {
                        verticalLayout {
                            imageView {
                                id = R.id.imageId
                            }
                            textView {
                                id = R.id.textId
                            }
                        }
                    }
                    CarDriveViewHolder(ui.view)
                }
            }
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }

}
