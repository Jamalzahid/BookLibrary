# BookLibrary
 
This project implements an Android application for managing a personal library of books. It utilizes MVVM architecture, Room database, complex queries, and dependency injection for a robust and scalable solution.

# Project Structure
app: Contains the main application code, including Activities/Fragments, ViewModels, and layouts.
dataModel: Contains all data-related classes:
entities: Database entities (Book, Author, Genre)
dao: Data Access Objects for interacting with the Room database.
repository: Repository class that abstracts data access from the ViewModel.
di: Contains Dagger/Hilt configuration for dependency injection.
util: Utility classes for common functions.
test: Unit tests for critical components like repository and ViewModel.
Building and Running the App
# Prerequisites:

Android Studio with latest tools installed.
# Steps:

Clone the repository.
Open the project in Android Studio.
Ensure you have a valid Android Virtual Device (AVD) configured.
Run the app from the "Run" menu.
Note: Dagger/Hilt requires additional configuration based on your chosen approach. Refer to their documentation for specific setup instructions.

# Additional Notes
Sample data for Books, Authors, and Genres is pre-populated in the database.
The app includes search functionality by title, author, and genre.
Sorting options allow organizing books by title, author, publication year, and genre.
Unit tests cover critical functionalities for better code maintainability.
