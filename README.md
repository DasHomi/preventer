# Preventer

A client side fabric mod that prevents you from doing dumb things by accident, like breaking blocks you don't want to break, or placing blocks you don't want to place.
(e.g. accidentally creating stripped logs or breaking budding amethyst)  
The whole mod is highly configurable, so you can disable any feature you don't want. 
The config can be reached in game by pressing `I`.
If you want to temporarily disable the entire mod, use the _Override Key_ (_default keybinding:_ `R`).

## Modules
<details open>
<summary><b> Interactions </b></summary>

- Prevent log stripping
  - _Prevents you from stripping logs_
- Prevent path creation
  - _Prevents you from creating path blocks_
- Prevent farmland creation
  - _Prevents you from creating farmland_
- Prevent cake eating
  - _Prevents you from eating cakes_
- Prevent copper scraping
  - _Prevents scraping oxidation from copper_
- Prevent copper de-waxing
  - _Prevents de-waxing copper_
- Prevent trapped chest opening
  - _Prevents you from opening trapped chests_
- Prevent firework rocket use
  - _Prevents you from using firework rockets while not flying_
- Prevent bed use
  - _Prevents you using beds in the End or Nether dimension_
- Prevent renamed food eating
  - _Prevents you from eating renamed food_
- Prevent note block editing
  - _Prevents you from changing the pitch of note blocks_
</details>

<details>
<summary><b> Plants </b></summary>

- Prevent glow berry harvesting
  - _Prevents you from harvesting Glow Berries_
- Prevent sweet berry harvesting
  - _Prevents you from harvesting Sweet Berries_
- Prevent non-mature crop harvesting
  - _Prevents you from harvesting (breaking) non-mature crops_
- Prevent stem breaking
  - _Prevents you from breaking pumpkin/melon stems_
</details>

<details>
<summary><b> Breaking </b></summary>

- Prevent budding amethyst block breaking
  - _Prevents you from breaking budding amethyst blocks_
- Prevent item frame breaking
  - _Prevents you from breaking item frames (and glowing item frames)_
- Prevent painting breaking
  - _Prevents you from breaking paintings_
- Prevent glass breaking
  - _Prevents you from breaking glass and glass panes_
- Prevent suspicious block breaking
  - _Prevents you from breaking suspicious sand and gravel_
</details>

<details>
<summary><b> Placing </b></summary>

- Prevent coral placing
  - _Prevents you from placing corals out of water_
- Prevent water placing
  - _Prevents you from placing water in the nether_
- Prevent renamed block placing
  - _Prevents you from placing renamed blocks_
</details>

<details>
<summary><b> Attacking </b></summary>

- Prevent villager punching
  - _Prevents you from attacking villagers_
- Prevent zombified piglin punching
  - _Prevents you from attacking Zombified Piglins_
- Prevent end crystal hitting
  - _Prevents you from hitting end crystals_
- Prevent golem hitting
  - _Prevents you from attacking iron & snow golems_
- Prevent named mob hitting
  - _Prevents you from attacking mobs with a custom name_
- Prevent tamed animal hitting
  - _Prevents you from attacking animals that have been tamed by a player (e.g. dogs, cats, ...)_
- Prevent rare mob hitting
  - _Prevents you from attacking rare mobs (parrots, axolotls, allays)_
- Prevent horse hitting
  - _Prevents you from attacking horses and similar creatures (Horses (including Skeleton & Zombie Horses), Donkeys, Mules, Llamas, Camels)_
- Prevent neutral mob hitting
  - _Prevents you from neutral mobs (as listed in the minecraft wiki)_
</details>

<details>
<summary><b> Other </b></summary>

- Low durability protection
  - _Prevent tools & weapons from breaking due to low durability_
- Prevent tool dropping
  - _Prevents you from dropping tools out of your hotbar_
- Prevent renamed item dropping
  - _Prevents you from dropping items with a custom name_
</details>

## Planed Features
- **_Missing any features? Open an [issue](https://github.com/DasHomi/preventer/issues)!_**
- Prevent Plant Breaking
- Prevent Block Under Player Breaking
- Prevent Lava Placing

## Compatibility
- Compatible with most other mods
  - Certain modules may not work for items from mods
- Compatible with most servers
  - Preventer is 100% client-side
- Fabric only (for now)
  - Forge support may be added in the future if it's doable in a reasonable amount of time

## Dependencies
**Required:**
- [Cloth Config](https://github.com/shedaniel/cloth-config)
- [Fabric API](https://github.com/FabricMC/fabric)
