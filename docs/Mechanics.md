# ⚙️ Core Mechanics

Understanding how **Hopper Filter** handles item detection, multi-item whitelisting, and item transfers.

---

## 🔍 How Item Detection Works

Whenever an item attempts to enter a hopper, the mod inspects all 6 faces of the hopper block (`North`, `South`, `East`, `West`, `Up`, `Down`) for attached **Item Frames** (both regular and **Glow Item Frames**).

### 1. The Filtering Rule
* **No Frames Attached**: The hopper operates exactly like a vanilla hopper (accepts everything).
* **Empty Frame Attached**: If all attached frames are empty, the hopper operates normally.
* **Frames with Items**: The hopper enters **Filter Mode**. It will **ONLY** accept items that match at least one of the items displayed in the attached frames.

---

## 📋 Multi-Item Whitelisting

You can attach multiple item frames to different faces of the same hopper:
* **1 Face with Frame** $\rightarrow$ Filters for **1 item** type.
* **2 Faces with Frames** $\rightarrow$ Filters for **2 item** types (e.g., *Oak Log* AND *Birch Log*).
* **Up to 6 Faces** $\rightarrow$ Filters up to **6 different items** into the same container!

If an incoming item matches **any** of the attached non-empty frames, it will be accepted.

---

## 🔄 Supported Transfer Types

Hopper Filter provides complete coverage across all vanilla and modded inventory transfer methods:

### 1. Floating Item Entity Pickup (Sucking from Above)
* When items fall or flow over the top of the hopper, the hopper checks if the item entity matches the filter.
* **Matching items**: Sucked into the hopper instantly.
* **Non-matching items**: Remain floating on top (perfect for water streams to carry them to the next hopper!).

### 2. Container Extraction (Pulling from Above)
* When a Chest, Barrel, Shulker Box, Furnace, or any modded container is placed directly above the hopper.
* The hopper will only extract items from that container that match the active filter.
* Non-matching items inside the chest are left untouched.

### 3. Direct Insertion (Piping & Hopper Chains)
* When another hopper, dropper, or modded pipe attempts to push an item into the filtered hopper from any direction.
* The item insertion is blocked if the item does not match the filter, allowing items to divert to other paths or stay in the source container.

---

## 🏷️ Item Matching Logic

* Items are matched using Minecraft'\''s native item equality (`isSameItem`).
* Non-stackable items (e.g. Swords, Bows, Armor, Potions, Minecarts, Boats) are fully supported.
* Rotating an item inside the frame changes only its visual orientation and does not affect the filtering logic.
