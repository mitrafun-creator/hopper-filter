# 🔍 Hopper Filter

> Simple & vanilla-friendly item filtering for hoppers using item frames. No bulky redstone sorters required!

**Hopper Filter** is a lightweight, vanilla-friendly mod for **NeoForge 1.21.1** created by **MitraFun**. It allows you to filter items passing through hoppers simply by attaching **Item Frames** to them.

---

## ✨ Features

- 🖼️ **Intuitive Item Filtering**: Attach an **Item Frame** to any side of a hopper and insert an item into it. The hopper will only accept and process items matching the item in the frame.
- 📦 **Multi-Item Filtering**: Attach multiple item frames to different faces of the same hopper to create a multi-item whitelist.
- 🔄 **100% Vanilla Aesthetic**: No new blocks, items, or complicated GUIs needed. Everything uses standard vanilla hoppers and item frames.
- ⚡ **Full Transfer Coverage**:
  - Item entities sucked from above.
  - Pulling items from chests and containers above.
  - Inserting/piping items into the hopper from any side via standard inventory capabilities.
- ⚙️ **Vanilla Fallback**: If no frames (or empty frames) are attached, the hopper behaves completely like a standard vanilla hopper.
- 🌐 **Dedicated Server & Singleplayer Friendly**: Lightweight Mixins with zero TPS overhead.

---

## 🎮 How It Works

1. Place down any standard **Hopper**.
2. Attach an **Item Frame** (or Glow Item Frame) to any side of the hopper.
3. Place the item you want to allow inside the Item Frame.
4. *Done!* The hopper will now only pull, suck, or receive items that match the frame's filter.

---

## 📦 Requirements & Compatibility

- **Minecraft Version**: `1.21.1`
- **Mod Loader**: `NeoForge` (`21.1.57+`)
- **Environment**: Client & Server
- **Author**: MitraFun
- **License**: MIT

---

## 🛠️ Building from Source

```bash
git clone https://github.com/mitrafun-creator/hopper-filter.git
cd hopper-filter/prebuild
./gradlew build
```

The compiled mod JAR will be generated in `prebuild/build/libs/hopperfilter-1.0.0.jar`.
