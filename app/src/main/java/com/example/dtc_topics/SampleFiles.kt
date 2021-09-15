package com.example.dtc_topics



/**
 * List of remote sample files to be used in the different samples
 */
object SampleFiles {
    val images = listOf(
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Balcony%20Toss/card.jpg",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Dance%20Search/card.jpg",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Extra%20Spicy/card.jpg",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Get%20Your%20Money's%20Worth/card.jpg"
    )

    val video = listOf(
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Balcony%20Toss.mp4",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Dance%20Search.mp4",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Extra%20Spicy.mp4",
        "https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Get%20Your%20Money's%20Worth.mp4"
    )

    val media = images + video

    val texts = listOf(
        "https://raw.githubusercontent.com/android/storage-samples/main/README.md",
        "https://raw.githubusercontent.com/android/security-samples/main/README.md"
    )

    val documents = listOf(
        "https://developer.android.com/images/jetpack/compose/compose-testing-cheatsheet.pdf",
        "https://developer.android.com/images/training/dependency-injection/hilt-annotations.pdf",
        "https://android.github.io/android-test/downloads/espresso-cheat-sheet-2.1.0.pdf"
    )

    val archives = listOf(
        "https://github.com/android/storage-samples/archive/refs/heads/main.zip",
        "https://github.com/android/security-samples/archive/refs/heads/main.zip"
    )

    val nonMedia = texts + documents + archives
}
