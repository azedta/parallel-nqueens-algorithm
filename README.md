# ♛ Parallel N-Queens Solver (Java)

This project is a **parallel Java implementation of the N-Queens problem** using a **hill-climbing search algorithm** enhanced with **multithreading** to significantly improve performance for large board sizes.

Instead of relying on a single search path, multiple solver threads explore different regions of the search space concurrently. The system terminates all remaining threads as soon as one valid solution is found.

---

## 🧠 Problem Overview

The **N-Queens problem** consists of placing `N` queens on an `N × N` chessboard such that:
- No two queens share the same row
- No two queens share the same column
- No two queens share the same diagonal

As `N` grows, the search space increases rapidly, making naive approaches inefficient.

---

## 🚀 Solution Approach

This implementation uses:

- **Hill Climbing Search**
  - Starts from a random board configuration
  - Iteratively improves the state by minimizing conflicts
- **Parallel Execution**
  - Multiple solver threads run simultaneously
  - Each thread starts from a different random configuration
- **Thread Coordination**
  - Threads are organized under a `ThreadGroup`
  - Once a solution is found, all remaining threads are interrupted and stopped

This approach dramatically reduces the time required to find solutions for large values of `N`.

---

## ✨ Key Features

- ♻️ Randomized hill-climbing strategy
- ⚡ Parallel search using Java threads
- 🧵 ThreadGroup-based coordination
- 🛑 Graceful interruption of all threads when a solution is found
- 📈 Scales effectively for large board sizes (e.g. `N > 40`)

---
## 🧠 What This Project Demonstrates

- Designing **parallel algorithms** for search problems
- Practical use of **Java concurrency primitives**
- Thread lifecycle management and interruption
- Performance-oriented problem solving
- Applying AI-inspired heuristics (hill climbing)



---

📌 *A performance-focused Java project showcasing concurrency, optimization, and algorithmic problem solving.*
