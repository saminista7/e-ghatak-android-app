# e-Ghatak (Android Matchmaking Application)

e-Ghatak is an Android-based matchmaking application developed using **Kotlin** and **Firebase**, designed to introduce a novel interaction-driven matching mechanism.  
Instead of traditional swipe-based selection, the application engages users in a progressive elimination process to arrive at a final match.

This project was developed as part of a university **Software Development Lab** coursework.

---

## Overview
e-Ghatak presents users with two randomly selected profiles at a time. The user eliminates one profile, and a new profile replaces the eliminated one. This comparison-and-elimination cycle continues for a fixed number of rounds.

At the end of a session, the remaining profile is selected as the user’s final choice. A match is established only if both users select each other as their final choice.

This approach emphasizes engagement and deliberate selection rather than rapid, swipe-based decisions.

---

## Core Matching Logic
- Two profiles are shown at a time
- User eliminates one profile per round
- A new profile replaces the eliminated one
- The process continues for multiple rounds
- A final profile is selected at the end
- Mutual final selection results in a match

---

## Key Features
- Android application built entirely with **Kotlin**
- Custom matchmaking logic based on profile elimination
- Firebase-backed authentication and user data management
- Profile storage including images and metadata
- Role-based dashboards (admin and user)
- Real-time data synchronization with Firebase
- Clean and structured UI with focus on usability

---

## Technology Stack
- **Language:** Kotlin
- **Platform:** Android (Android Studio)
- **Backend & Database:** Firebase (Authentication, Realtime Database / Firestore)
- **Storage:** Firebase Storage for profile images

---

## System Architecture
- Android client written in Kotlin
- Firebase used for:
  - User authentication
  - Profile data storage
  - Image hosting
  - Admin and user role management
- Application logic handled entirely on the client side with cloud-backed data persistence

---

## Academic Context
This project was developed as part of an undergraduate **Software Development Lab** course.  
The primary focus was on applying mobile application development principles, clean architecture, database integration, and real-time data handling.

---

## Notes
This repository is maintained for academic reference and demonstration of Android development and backend integration skills.
