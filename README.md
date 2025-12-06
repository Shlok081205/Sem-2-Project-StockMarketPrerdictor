# Stock Market Management System (Java)

## 🚀 Overview
A console/termial application for portfolio management and trend analysis.
**Highlight:** Features a custom implementation of **Linear Regression** written in Core Java to predict stock trends without using libraries like Scikit-learn.

## 🛠 Tech Stack
- **Language:** Java (Core, OOP, Multithreading)
- **Database:** PostgreSQL (Connected via JDBC) [cite: 280]
- **Concepts:** Collections Framework, Exception Handling [cite: 279]

## 🧮 How the Prediction Works
This project calculates the slope ($m$) and intercept ($c$) using the Least Squares method:
- `y = mx + c`
- The algorithm iterates through historical stock data stored in PostgreSQL to calculate the regression line dynamically.
