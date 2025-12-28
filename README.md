# Ai-Sentinel-Fraud-Engine
A real-time banking security engine built with Spring Boot. It uses behavioral data to detect fraud and manages automated security challenges through multi-threading.
AI-Sentinel: Heuristic Multi-Threaded Fraud Engine 🛡️
Project Overview
AI-Sentinel is a proactive security system designed for modern banking environments. Instead of relying on static rules that hackers can easily bypass, this engine uses behavioral analysis to identify suspicious activity in real-time. It is optimized to run efficiently on standard hardware (8GB RAM) while handling high-volume transaction data.

How It Works
Behavioral Training: The engine analyzes a Kaggle dataset of 1 million banking records to learn a user's typical spending habits and location history.

Anomaly Detection: When a new transaction arrives, the "Sentinel" compares it against the learned baseline. If it detects an impossible travel scenario (e.g., India to London in minutes) or a massive spending spike, it triggers a challenge.

Adaptive Challenge: The system generates a 6-digit OTP and starts a background timer using Java Multi-threading.

Automatic Lock: If the user fails to verify their identity within 60 seconds, the engine automatically locks the account to prevent financial loss.

Technical Stack
Language: Java 17+

Framework: Spring Boot

Concurrency: ScheduledExecutorService (Multi-threading)

Data Handling: Buffered CSV Processing for memory efficiency

IDE: Eclipse

Project Structure
model: Defines the data structure for Accounts and Transactions.

service: Manages the OTP generation and the 60-second countdown logic.

ai: The decision-making core that analyzes behavioral patterns.

exception: Custom error handling for fraud-specific alerts.

config: The entry point and simulation environment.

3. How to Showcase This on Your Profile
To make this look like a real-world banking application, ensure you upload the following to your repository:

The .java files we created.

The README.md text provided above.

Note: Do not upload the actual 100MB+ Kaggle CSV file; instead, provide the link to the dataset in your README so others can download it themselves.
