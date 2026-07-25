# Stock Market Management System 📈

> A terminal-based stock portfolio management and trend prediction system built in Core Java.

A Semester 2 project that implements a full stock analysis pipeline — from PostgreSQL-backed portfolio management to a custom machine learning engine (Batch Gradient Descent + L2 Regularization) — written entirely in Core Java without external ML libraries.

---

## 🌟 Features

| Feature | Description |
|---|---|
| 👤 **User Accounts** | Signup / Login with PAN card, Aadhaar, and mobile verification |
| 💼 **Portfolio Management** | Buy/sell stocks, track holdings using a custom Linked List |
| 📊 **Technical Indicators** | RSI, MACD, Bollinger Bands, Derived Indicators computed from scratch |
| 🤖 **Stock Prediction** | Custom Batch Gradient Descent + L2 Regularization (no ML libraries) |
| 🗄️ **Database** | PostgreSQL via JDBC — persistent storage for users, portfolios, history |
| 📁 **CSV Data** | Historical NSE data for CIPLA, HDFC Bank, Infosys, TCS |

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 24 | Core language |
| Maven | 3.x | Build tool & dependency management |
| PostgreSQL | 14+ | Relational database |
| JDBC (PostgreSQL Driver) | 42.7.3 | Database connectivity |
| Apache Commons CSV | 1.14.0 | CSV file parsing |
| Apache Commons Lang3 | 3.14.0 | Utility methods |
| Apache Commons IO | 2.19.0 | File I/O utilities |
| JUnit Jupiter | 5.10.2 | Unit testing |

---

## 📁 Project Structure

```
Stock_Market_Predictor/
│
└── Trial/                          # Maven project root
    ├── pom.xml                     # Dependencies & build config (Java 24)
    │
    └── src/main/
        ├── resources/
        │   ├── db.properties        # DB credentials (gitignored — create this!)
        │   └── db.properties.example  # Template to copy from
        │
        └── java/
            ├── Data/                # NSE historical CSV data (CIPLA, HDFC, INFY, TCS)
            │
            └── Stock_Predictor/
                ├── Main.java        # Application entry point
                ├── Color.java       # ANSI terminal colors
                │
                ├── Account/
                │   └── AccountManager.java   # Signup, login, session management
                │
                ├── JDBC/
                │   ├── JDBC_Connection.java  # DB connection (reads from db.properties)
                │   └── JDBC_Manager.java     # All SQL queries & operations
                │
                ├── PortFolioManagment/
                │   ├── Portfolio.java        # Portfolio buy/sell logic
                │   └── LinkedList.java       # Custom linked list for holdings
                │
                └── Predict_And_Analysis/
                    ├── DataPreparation.java  # ML training pipeline
                    ├── DerivedIndicators.java # RSI, MACD, Bollinger Bands
                    ├── CSV_Manager.java      # CSV reader & parser
                    ├── Stock.java            # Stock data model
                    ├── Stock_Data.java       # OHLCV data structure
                    ├── BollingerBands.java   # Bollinger Bands model
                    └── MACDResult.java       # MACD result model
```

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 24+
- Maven 3.x
- PostgreSQL 14+

### 1. Clone the Repository

```bash
gh repo clone Shlok081205/Stock_Market_Predictor
cd Stock_Market_Predictor
```

### 2. Set Up PostgreSQL Database

```sql
-- In psql or pgAdmin:
CREATE DATABASE sem_2pro;
```

### 3. Configure Database Credentials

```bash
# Copy the example config
cp Trial/src/main/resources/db.properties.example Trial/src/main/resources/db.properties
```

Edit `db.properties` with your credentials:

```properties
db.url=jdbc:postgresql://localhost:5432/sem_2pro
db.user=postgres
db.password=your_postgres_password
```

> **Note:** `db.properties` is listed in `.gitignore` and will never be committed.

### 4. Build the Project

```bash
cd Trial
mvn clean install
```

### 5. Run the Application

```bash
mvn exec:java -Dexec.mainClass="Stock_Predictor.Main"
```

---

## 🧠 Core Algorithm: Gradient Descent from Scratch

This project implements a custom ML engine in Java with **no external ML libraries**. It uses **Batch Gradient Descent** with **L2 Regularization** to optimize weights across 16 technical indicators.

```java
public void trainModel(double[][] x_train, double[] y_train, int epochs) {
    int m = x_train.length;       // Number of training examples
    int n = x_train[0].length;    // Number of features (RSI, MACD, ATR, etc.)

    double learningRate = 0.01;
    double l2Lambda     = 0.01;   // Regularization to prevent overfitting

    for (int epoch = 0; epoch < epochs; epoch++) {
        double[] gradients = new double[n];
        double biasGradient = 0.0;

        for (int i = 0; i < m; i++) {
            // Forward pass: y = w1*x1 + w2*x2 + ... + bias
            double prediction = bias;
            for (int j = 0; j < n; j++) prediction += x_train[i][j] * weights[j];

            double error = prediction - y_train[i];
            biasGradient += error;

            // Backward pass: gradients with L2 penalty
            for (int j = 0; j < n; j++)
                gradients[j] += error * x_train[i][j] + l2Lambda * weights[j];
        }

        // Weight update (Optimizer step)
        for (int j = 0; j < n; j++) weights[j] -= learningRate * (gradients[j] / m);
        bias -= learningRate * (biasGradient / m);
    }
}
```

### Technical Indicators Used as Features
| Indicator | Description |
|---|---|
| RSI | Relative Strength Index — momentum oscillator |
| MACD | Moving Average Convergence Divergence |
| Bollinger Bands | Volatility bands (upper, middle, lower) |
| SMA / EMA | Simple & Exponential Moving Averages |
| Derived Indicators | Custom computed trend features |

---

## 📊 Stocks Included (NSE Historical Data)

| Symbol | Company |
|---|---|
| 500087 | Cipla Ltd |
| 500180 | HDFC Bank Ltd |
| 500209 | Infosys Ltd |
| 532540 | TCS Ltd |

---

## 🔒 Security Note

Database credentials are loaded from `db.properties` (gitignored). **Never hardcode passwords in source files.**

---

## 👨‍💻 Authors

**TradeAlchemy Team** — Semester 2 Project

---

## 📄 License

This project was built for educational purposes as part of a semester project.
