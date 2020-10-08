# Sound-Mixer
This is an android app for soundscape mixer. This app can fetch the mp3 files from www.freesound.org and play multiple sounds synchronously.

## Experience
This application was built as a school assignment, it was a simple app but half way through the app, I decided to implement a better architecture, which made it a bit more exciting for me.

## Screenshots

<image src="screenshots/one.png" width=300>    <image src="screenshots/two.png" width=300>
    <image src="screenshots/three.png" width=300>  <image src="screenshots/four.png" width=300>
      
## Concepts implemented

- Retrofit
- Coroutines
- ViewModel, LiveData
- Singleton
- Android navigation component
- Fragments
- Connection to www.freesound.org API service
- Phone Audio

## How to Use the App 

Browse and add sounds to media player
- Click on "Let's create sound" button
- Browse category
- Click on the mp3 file of your choice
- Click Floating Action button in the media player screen (+) and select multiple mp3 files
- Click on "play" button to play multiple sounds synchronously

## How to Install/ Run via Github on Android Studio 

1. Clone or download the project on your local machine via following link
```
https://github.com/ghaniasim/sound-mixer.git
```
2. Unzip the file
3. Open the project with Android Studio
4. Build and run on emulator or debugging enabled devive

## Special mention 
Thank you to the sound team for recording and uploading sounds to www.freesound.org

## Dependencies

```
apply plugin: "androidx.navigation.safeargs.kotlin"

implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
implementation 'com.squareup.retrofit2:retrofit:2.6.0'
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.8'
implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha07"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha07"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha07"

def nav_version = "2.3.0"
// Kotlin
implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

implementation 'com.google.android.material:material:1.2.0'
```

```
dependencies {
    def nav_version = "2.3.0"
    classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
}
