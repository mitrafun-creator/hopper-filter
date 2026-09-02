# ❓ Frequently Asked Questions (FAQ)

Answers to commonly asked questions regarding **Hopper Filter**.

---

### Q: Does this work with Glow Item Frames?
**A:** Yes! Both standard **Item Frames** and **Glow Item Frames** work identically for filtering.

---

### Q: Can I filter unstackable items (Swords, Potions, Tools, Armor, Minecarts)?
**A:** Yes! Unstackable items placed inside the Item Frame will filter identically to stackable items. In vanilla redstone sorters, sorting unstackable items is notoriously difficult; with Hopper Filter, it works natively out of the box.

---

### Q: What happens if I rotate the item inside the Item Frame?
**A:** Rotating the item inside the frame only changes its visual orientation. The hopper continues to filter for that item type regardless of rotation.

---

### Q: What happens if I break the Item Frame?
**A:** The moment the item frame is broken or removed, the hopper immediately reverts to standard vanilla behavior, accepting all items.

---

### Q: Is this mod required on both Client and Server?
**A:** 
* **Dedicated Server**: The mod must be installed on the server where the item transfer logic executes.
* **Singleplayer / LAN**: Works out of the box.
* Having it on both client and server ensures maximum compatibility and smooth visual synchronization.

---

### Q: Does it affect server performance (TPS)?
**A:** Not at all! The mod uses optimized entity bounding box queries (`getEntitiesOfClass` within an inflated 0.5 radius) and lightweight Mixin injections that only trigger when an item transfer actually takes place. There are no constant background polling loops or heavy redstone updates.

---

### Q: Can I use this in my modpack?
**A:** Absolutely! **Hopper Filter** is licensed under the **MIT License**, meaning you are completely free to include it in public or private modpacks on Modrinth, CurseForge, or custom launchers.
