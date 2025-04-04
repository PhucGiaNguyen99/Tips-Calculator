# Tips-Calculator

An Android application built with Kotlin that helps users calculate tips based on cost, number of ppl, and service quality. This project is also a personal learning journey to practice and explore Android app development concepts.

---

## Current Features (Completed)
### MainActivity
- Input total bill amount
- Input number of people
- Select service quality (Excellent, Average, Below Average)
- Automatically calculates:
    - Tip total
    - Total amount
    - Per person amount
- Clear button to reset all inputs
- Button to open update screen for custom tip percentages

### UpdateTipActivity
- Receives current tip percentages
- Displays them as hints in editable fields
- Lets users update one, some, or all percentages
- Returns the updated values back to `MainActivity`
- Cancel button discards all changes

### Configuration Handling
- Retains custom tip percentages on configuration changes (e.g. phone rotation)
- Uses `onSaveInstanceState` and `onRestoreInstanceState`

---

## Planned Features (In Progress)

### Tip History
- Save previous calculations with timestamp
- Store transactions in SharedPreferences for local storage
- Show a history screen using RecyclerView
- Improve the transactions history: 
  + Display each TipRecord as a styled CardView
  + Use a GridLayout with columns
  + Improve layout spacing, font sizes, and visual design
- Now:
  + Modern, card-styled tip history items
  + 2-column responsive grid
  + Clean margins, padding, elevation, and font styles

### Timestamp Display
- Record and display the time/date of each calculation

### UI Improvements
- Use Material Design components
- Add custom themes, colors, and polished layout

### Tip Visualization
- Add pie chart or bar chart for tip breakdown using MPAndroidChart

### Share Calculation
- Share tip summary via email, messaging apps, or clipboard

### Smart Tip Suggestions
- Suggest tip percentages based on history or average of past data

## Tech Stack
- Kotlin
- Android SDK
- Android Studio
- XML Layouts
- XML Layouts
- Intents and Bundles
- Configuration Change Handling

---

##  How to Build & Run
1. Clone the repo or download the project folder.
2. Open with Android Studio.
3. Click ▶️ to build and run the app on a device or emulator.

---