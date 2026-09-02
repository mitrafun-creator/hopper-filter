# 📦 Building Sorting Systems

Thanks to **Hopper Filter**, building automated storage and sorting systems in Minecraft is drastically simpler, more compact, and lag-free.

---

## 🌊 Design 1: Linear Water Stream Sorter (Recommended)

This is the most popular, high-speed bulk sorting design.

```text
[Water Source] ~ ~ ~ (Items Flowing) ~ ~ ~ [Overflow Chest]
      ↓                 ↓                 ↓
 [Hopper: Iron]   [Hopper: Gold]   [Hopper: Diamonds]
      ↓                 ↓                 ↓
 [Iron Chest]      [Gold Chest]      [Diamond Chest]
```

### Steps to Build:
1. Place a line of double chests with a **Hopper** pointing down into each chest.
2. Place an **Item Frame** on the front of each hopper.
3. Put the target item for each chest into its corresponding item frame.
4. Create a standard water stream flowing over the top of the hoppers.
5. Drop your unsorted loot into the water stream at the start!

> 💡 **Why it is better than vanilla**:
> * 1-wide tileable with **zero gap needed between slices**.
> * No hopper locking or overflow issues.
> * If a chest gets full, excess items simply float downstream to an overflow chest instead of breaking the entire system.

---

## 🗄️ Design 2: Multi-Item Category Sorting

Sort multiple related items into a single categorized chest (e.g. "Wood Chest", "Stone Chest", "Mob Drops").

```text
                       [Water / Input Stream]
                                 ↓
                     +-----------------------+
                     | [Frame: Oak Log]      |
[Frame: Birch Log] --|   FILTERED HOPPER     |-- [Frame: Spruce Log]
                     | [Frame: Jungle Log]   |
                     +-----------------------+
                                 ↓
                         [ All Woods Chest ]
```

### Steps to Build:
1. Place a hopper over a designated category chest.
2. Attach item frames to up to 4 exposed horizontal sides (and even top/bottom if configured).
3. Put different items from the same category into each frame (e.g., Oak Log on Front, Birch Log on Left, Spruce Log on Right, Dark Oak Log on Back).
4. The hopper will collect all 4 wood types into that single chest while ignoring everything else!

---

## ⚡ Design 3: Direct In-Line Hopper Pipe

```text
[Unsorted Chest]
       ↓
[Filtered Hopper (Picks only Ore)] ──► [Ore Processing Furnace]
       ↓
[Filtered Hopper (Picks Wood)]     ──► [Wood Storage]
```

* Simply chain hoppers directly beneath an unsorted input chest.
* Each hopper with a filter attached will pull only its specific item out of the top chest, leaving the rest for lower hoppers in the chain.
