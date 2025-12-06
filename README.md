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
- ## 🧠 Core Algorithm: Gradient Descent from Scratch
This project implements a custom machine learning engine in Java without external libraries. It uses **Batch Gradient Descent** with **L2 Regularization** to optimize weights for 16 different technical indicators.

```java
public void trainModel(double[][] x_train, double[] y_train, int epochs) {
    int m = x_train.length;       // Number of training examples
    int n = x_train[0].length;    // Number of features (RSI, MACD, etc.)
    
    // Hyperparameters
    double learningRate = 0.01;
    double l2Lambda = 0.01;       // Regularization term to prevent overfitting

    for (int epoch = 0; epoch < epochs; epoch++) {
        double[] gradients = new double[n];
        double biasGradient = 0.0;

        // 1. Calculate Gradients (Partial Derivatives)
        for (int i = 0; i < m; i++) {
            // Forward Pass: Calculate prediction: y = w1*x1 + w2*x2 + ... + bias
            double prediction = bias;
            for (int j = 0; j < n; j++) {
                prediction += x_train[i][j] * weights[j];
            }

            // Calculate Error
            double error = prediction - y_train[i];
            biasGradient += error;

            // Backward Pass: Calculate gradients for weights with L2 penalty
            for (int j = 0; j < n; j++) {
                gradients[j] += error * x_train[i][j] + l2Lambda * weights[j];
            }
        }

        // 2. Update Weights (Optimizer Step)
        for (int j = 0; j < n; j++) {
            weights[j] -= learningRate * (gradients[j] / m);
        }
        bias -= learningRate * (biasGradient / m);
    }
}
