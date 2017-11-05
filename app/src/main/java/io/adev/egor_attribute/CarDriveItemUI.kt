package io.adev.egor_attribute

import android.content.Context
import org.jetbrains.anko.*

class CarDriveItemUI : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        verticalLayout {
            imageView {
                id = R.id.imageId
            }
            textView {
                id = R.id.textId
            }
        }
    }
}