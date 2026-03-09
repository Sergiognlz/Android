package com.example.tarjetacumple.ui.theme

import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.tarjetacumple.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fuenteCumpleaños = FontFamily(
    Font(googleFont = GoogleFont("Pacifico"), fontProvider = provider)
)