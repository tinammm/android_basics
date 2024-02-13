# Amphibian
Amphibian is an Android app that fetches information about various amphibians using Retrofit and Coil libraries. It displays the data as a list of Amphibian Cards, including name, type, image, and description.
## Installation
1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.
   
## Features
* _Dynamic Home Screen_: The home screen of the Amphibian app adapts to different scenarios based on the API response.
  * Loading Composable: When the app is fetching data from the API, a loading indicator is displayed, providing users with feedback that information is being retrieved.
  * Error Composable: In case of API failure, an error message is presented along with a retry button, enabling users to attempt fetching the data again.
  * List of Amphibians: Upon successful API response, the app presents a list of amphibians, showcasing their names, types, images, and descriptions.

* _Integration of Retrofit and Coil Libraries_: The Amphibian app integrates Retrofit and Coil libraries to streamline the process of fetching and displaying data.
  * Retrofit Library: Enables efficient communication with the API, allowing the app to retrieve relevant information about various amphibian species.
  * Coil Library: Facilitates the loading and displaying of images within the app.

* _User-Friendly Experience_: With a focus on usability, the Amphibian app ensures a smooth and intuitive experience for users of all levels.
Clear feedback mechanisms, such as loading indicators and error messages, keep users informed throughout their interaction with the app.
### Screenshots
<div align="center">
    <img src="/Amphibian/screenshots/screenshots1.jpg?raw=true" width="140px"</img> 
    <img height="0" width="16px">
    <img src="/Amphibian/screenshots/screenshots2.jpg?raw=true" width="140px"</img>
    <img height="0" width="16px">
    <img src="/Amphibian/screenshots/screenshots3.jpg?raw=true" width="140px"</img> 
    <img height="0" width="16px">
    <img src="/Amphibian/screenshots/screenshots4.jpg?raw=true" width="140px"</img> 
</div>

## License
Copyright 2022 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
