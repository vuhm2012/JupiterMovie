package com.vuhm.jupitermovie.presentation.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import com.vuhm.jupitermovie.R

fun Context.createLoadingDialog(): Dialog {
    val dialog: Dialog
    val view: View = LayoutInflater.from(this).inflate(R.layout.dialog_loading, null)
    val builder = AlertDialog.Builder(this)
        .setView(view)
        .setCancelable(false)


    dialog = builder.create()
    dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    return dialog
}
