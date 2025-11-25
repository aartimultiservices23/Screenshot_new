
# 📸 Java Desktop Auto Screenshot App

This module is a **standalone Java desktop application** that automatically captures screenshots at fixed intervals and saves them locally. It is built using **pure Java** and has **no external dependencies**.

---

## ✨ Use Cases

This application is perfect for:

* **System Activity Monitoring**
* **Auto Logging**
* **Demonstration / Learning**
* **Background screenshot capture apps**

---

## 🚀 Features

* Captures the **entire screen** every **20 seconds** (configurable in `INTERVAL_SECONDS`).
* Saves screenshots in a dedicated `screenshots/` folder relative to the execution path.
* Produces **high-resolution PNG** output.
* **No external libraries** required.
* Works on **Windows, Linux, and macOS**.
* Built using the **Pure Java** `java.awt.Robot` API and a `Thread` loop.

---

## 📂 Folder Structure

The project has a minimal and clean structure:

```

java-desktop/
│
├── AutoScreenshot.java     \# Main Java file (core logic)
└── screenshots/            \# Images saved here automatically (created at runtime)

````

---

## 🧩 How It Works (Core Logic)

The application utilizes core Java functionality:

| Component | Purpose |
| :--- | :--- |
| `java.awt.Robot` | Performs the low-level **screen capture** operation. |
| `Toolkit.getDefaultToolkit().getScreenSize()` | Determines the dimensions of the entire screen. |
| `BufferedImage` | Stores the captured image data in memory. |
| `ImageIO.write()` | Handles saving the image data to a file as PNG. |
| `Thread.sleep()` | Implements the **20-second interval** repetition logic. |

---

## ▶️ Running the Application

### 1️⃣ Compile

Open your terminal inside the project directory and compile the main Java file:

```bash
javac AutoScreenshot.java
````

### 2️⃣ Run

Execute the compiled class file:

```bash
java AutoScreenshot
```

### 🖥️ Console Output

The application runs continuously in a loop until manually stopped (Ctrl+C).

```
🚀 AutoScreenshot service started.
⏱ Interval: 20 seconds
📁 Screenshots folder: /path/to/project/java-desktop/screenshots
🔚 Close the program or stop run to exit.

✅ Saved screenshot: /path/to/project/java-desktop/screenshots/screenshot_20251125_165924.png
✅ Saved screenshot: /path/to/project/java-desktop/screenshots/screenshot_20251125_165944.png
...
```

### 🖼️ Screenshot Naming Convention

Screenshots are named using the pattern: `screenshot_YYYYMMDD_HHmmss.png`.

**Example File Names:**

  * `screenshot_20251125_140010.png`
  * `screenshot_20251125_140030.png`
  * `screenshot_20251125_140050.png`

<!-- end list -->

```
```
